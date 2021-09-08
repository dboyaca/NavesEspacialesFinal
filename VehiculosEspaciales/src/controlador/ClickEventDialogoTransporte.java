/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import utils.InitialData;
import acess.LigeroDAO;
import acess.TransporteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.LigeroModel;
import modelo.TransporteModel;
import vista.DialogoCrearVehiculoTransporte;
import vista.PanelResultados;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class ClickEventDialogoTransporte implements ActionListener{
    
    //---------------------------------------------------------
    //                      Atributos
    //--------------------------------------------------------- 
    
    private DialogoCrearVehiculoTransporte dialogoTransporte;
    private PanelResultados panelResultados;
    
    
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public ClickEventDialogoTransporte(DialogoCrearVehiculoTransporte dialogoTransporte, PanelResultados panelResultados)
    {
        this.dialogoTransporte = dialogoTransporte;
        this.panelResultados = panelResultados;
        
    }
    
    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        if(actionEvent.getSource() == this.dialogoTransporte.getButAceptar()) 
        {        
            String matriculaStr = dialogoTransporte.getTxtMatricula().getText();
            String nombreStr = dialogoTransporte.getTxtNombre().getText();
            String velocidadStr = dialogoTransporte.getTxtVelocidad().getText();
            String longitudStr = dialogoTransporte.getTxtLongitud().getText();
            String tripulantesStr = dialogoTransporte.getTxtTripulantes().getText();
            String pasajerosStr = dialogoTransporte.getTxtPasajeros().getText();

            if(matriculaStr.equals( "" ) || nombreStr.equals( "" ) || velocidadStr.equals( "" ) || longitudStr.equals( "" ) || tripulantesStr.equals( "" ) || pasajerosStr.equals( "" ))
            {
                JOptionPane.showMessageDialog( null, "Debe llenar todos los campos", "", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int matricula = Integer.parseInt(matriculaStr);
                    double velocidad = Double.parseDouble(velocidadStr);
                    double longitud = Double.parseDouble(longitudStr);
                    int tripulantes = Integer.parseInt(tripulantesStr);
                    int pasajeros = Integer.parseInt(pasajerosStr);
                    
                    if ( matricula < 0 || velocidad < 0 || longitud < 0 || tripulantes < 0 || pasajeros < 0 ) 
                    {
                        JOptionPane.showMessageDialog( null, "La cantidad matricula, velocidad, longitud, tripulantes, pasajeros no pueden ser valores negativos.", "", JOptionPane.ERROR_MESSAGE );
                    }
                    
                    else
                    {
                    
                        TransporteDAO  transporteDAO = new TransporteDAO();
                        int verificacion = transporteDAO.crearTransporte(new TransporteModel(matricula, nombreStr, velocidad, longitud, tripulantes, pasajeros));

                        if (verificacion > 0)
                        {
                            this.dialogoTransporte.resetearDialogo();
                            
                            InitialData initialData = new InitialData();
                            panelResultados.setTblResults(initialData.getVehiculos());
                        }
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog( null, "La matrícula, velocidad, longitud, tripulantes, pasajeros deben ser valores numéricos", "", JOptionPane.ERROR_MESSAGE );
                }
        
            }
    
    
        }
        else if (actionEvent.getSource() == this.dialogoTransporte.getButCancelar())
        {
            dialogoTransporte.dispose();
            
        }
       
}
    
}
