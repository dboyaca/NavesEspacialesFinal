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
import vista.*;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class ClickEventPanelControles implements ActionListener {

    //---------------------------------------------------------
    //                      Atributos
    //--------------------------------------------------------- 
    private PanelControles panelControles;
    private PanelResultados panelResultados;
    
        
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    
    public ClickEventPanelControles(PanelControles panelControles, PanelResultados panelResultados)
    {
        this.panelControles = panelControles;
        this.panelResultados = panelResultados;
    }
   
    
    //---------------------------------------------------------
    //                      Métodos
    //---------------------------------------------------------     
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        if(actionEvent.getSource() == this.panelControles.getButCrear()) 
        {        
            if(panelControles.getCbxTipoVehiculo().getSelectedIndex() == 0)
            {
                
               DialogoCrearVehiculoLigero dialogoCrear = new DialogoCrearVehiculoLigero(panelResultados);
               dialogoCrear.setVisible(true);
                
            }
            else if(panelControles.getCbxTipoVehiculo().getSelectedIndex() == 1)
            {
               DialogoCrearVehiculoTransporte dialogoCrear = new DialogoCrearVehiculoTransporte(panelResultados);
               dialogoCrear.setVisible(true);
            }  
     
        }
        
        else if(actionEvent.getSource() == this.panelControles.getButActualizar())
        {
            int filaSeleccionada = panelResultados.getTblResults().getSelectedRow();
            //System.out.println(filaSeleccionada);
            
            if (filaSeleccionada == -1)
            {
                JOptionPane.showMessageDialog( null, "Seleccione en la tabla la fila que desea borrar", "", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                
                int matricula = Integer.parseInt(panelResultados.getTblResults().getValueAt(filaSeleccionada, 0).toString());
                String nombre = panelResultados.getTblResults().getValueAt(filaSeleccionada, 1).toString();
                double velocidad = Double.parseDouble(panelResultados.getTblResults().getValueAt(filaSeleccionada, 2).toString());
                double longitud = Double.parseDouble(panelResultados.getTblResults().getValueAt(filaSeleccionada, 3).toString());
                
                VehiculoModel vehiculo = new VehiculoModel(matricula, nombre, velocidad, longitud);
                
                DialogoActualizarVehiculo dialogoActualizar = new DialogoActualizarVehiculo(vehiculo, panelResultados);
                
                dialogoActualizar.setVisible(true);
                       
            }
        }
        
        else if(actionEvent.getSource() == this.panelControles.getButBorrar())
        {
            int filaSeleccionada = panelResultados.getTblResults().getSelectedRow();
            
            if (filaSeleccionada == -1)
            {
                JOptionPane.showMessageDialog( null, "Seleccione en la tabla la fila que desea borrar", "", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                int matricula = Integer.parseInt(panelResultados.getTblResults().getValueAt(filaSeleccionada, 0).toString());
                
                VehiculoDAO vehiculoDAO = new VehiculoDAO();
                
                vehiculoDAO.borrarVehiculo(matricula);
                 
                InitialData initialData = new InitialData();
                panelResultados.setTblResults(initialData.getVehiculos());
                
            }
            
        }
            
    }
    
}
