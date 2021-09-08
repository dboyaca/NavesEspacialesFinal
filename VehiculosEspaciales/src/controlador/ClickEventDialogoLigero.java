/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import utils.InitialData;
import acess.LigeroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.LigeroModel;
import vista.DialogoCrearVehiculoLigero;
import vista.DialogoCrearVehiculoTransporte;
import vista.PanelControles;
import vista.PanelResultados;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class ClickEventDialogoLigero implements ActionListener{

    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------     
    
    private PanelResultados panelResultados;
    private DialogoCrearVehiculoLigero dialogoLigero;
    
    
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public ClickEventDialogoLigero(DialogoCrearVehiculoLigero dialogoLigero, PanelResultados panelResultados)
    {
        this.dialogoLigero = dialogoLigero;
        this.panelResultados = panelResultados;
    }

    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        if(actionEvent.getSource() == this.dialogoLigero.getButAceptar()) 
        {        
            String matriculaStr = dialogoLigero.getTxtMatricula().getText();
            String nombreStr = dialogoLigero.getTxtNombre().getText();
            String velocidadStr = dialogoLigero.getTxtVelocidad().getText();
            String longitudStr = dialogoLigero.getTxtLongitud().getText();
            String colorStr = dialogoLigero.getTxtColor().getText();
            String androideStr = dialogoLigero.getTxtAndroide().getText();

            if(matriculaStr.equals( "" ) || nombreStr.equals( "" ) || velocidadStr.equals( "" ) || longitudStr.equals( "" ) || colorStr.equals( "" ))
            {
                JOptionPane.showMessageDialog( null, "Debe llenar todos los campos a excepción de \"Androide\".", "", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int matricula = Integer.parseInt(matriculaStr);
                    double velocidad = Double.parseDouble(velocidadStr);
                    double longitud = Double.parseDouble(longitudStr);
                    
                    if ( matricula < 0 || velocidad < 0 || longitud < 0 ) 
                    {
                        JOptionPane.showMessageDialog( null, "La cantidad matricula, velocidad, longitud, no pueden ser valores negativos.", "", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        LigeroDAO ligeroDAO = new LigeroDAO();
                        int verificacion = ligeroDAO.crearLigero(new LigeroModel(matricula, nombreStr, velocidad, longitud, colorStr, androideStr));

                        if (verificacion > 0)
                        {
                            this.dialogoLigero.resetearDialogo();
                            
                            InitialData initialData = new InitialData();
                            panelResultados.setTblResults(initialData.getVehiculos());
                            
                        }   
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog( null, "La matrícula, velocidad y longitud deben ser valores numéricos", "", JOptionPane.ERROR_MESSAGE );
                }
             
            }

        }
        else if(actionEvent.getSource() == this.dialogoLigero.getButCancelar())
        {
            dialogoLigero.dispose();
        }
        
        
        
        
    }
    
    
}
