/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import utils.InitialData;
import acess.VehiculoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.VehiculoModel;
import vista.DialogoActualizarVehiculo;
import vista.PanelResultados;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class ClickEventDialogoActualizar implements ActionListener{

    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------     
    private DialogoActualizarVehiculo dialogoActualizar;
    private PanelResultados panelResultados;
    
    //---------------------------------------------------------
    //                      Constructor
    //---------------------------------------------------------     
    public ClickEventDialogoActualizar(DialogoActualizarVehiculo dialogoActualizar, PanelResultados panelResultados)
    {
        this.dialogoActualizar = dialogoActualizar;
        this.panelResultados = panelResultados;
    }
    
    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        if(actionEvent.getSource() == this.dialogoActualizar.getButActualizar())
        {
            String matriculaStr = dialogoActualizar.getTxtMatricula().getText();
            String nombreStr = dialogoActualizar.getTxtNombre().getText();
            String velocidadStr = dialogoActualizar.getTxtVelocidad().getText();
            String longitudStr = dialogoActualizar.getTxtLongitud().getText();            
            
            if(matriculaStr.equals( "" ) || nombreStr.equals( "" ) || velocidadStr.equals( "" ) || longitudStr.equals( "" ))
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
                    
                    if ( matricula < 0 || velocidad < 0 || longitud < 0 ) 
                    {
                        JOptionPane.showMessageDialog( null, "La cantidad matricula, velocidad, longitud, no pueden ser valores negativos.", "", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        VehiculoDAO vehiculoDAO = new VehiculoDAO();
                        VehiculoModel vehiculo = new VehiculoModel(matricula, nombreStr, velocidad, longitud);
                        vehiculoDAO.actualizarVehiculo(vehiculo);
                        
                        
                        //ACTUALIZAR TABLA CON NUEVOS RESULTADOS
                        
                        InitialData initialData = new InitialData();
                        panelResultados.setTblResults(initialData.getVehiculos());
                        
                        
                    }
                  
                    
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog( null, "La matrícula, velocidad y longitud deben ser valores numéricos", "", JOptionPane.ERROR_MESSAGE );
                }
                    
            
            
            
            }
        }
        else if (actionEvent.getSource() == this.dialogoActualizar.getButCancelar())
        {
            dialogoActualizar.dispose();
            
        }
    }
    
}
