/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import acess.VehiculoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.VehiculoModel;
import vista.PanelConsultas;
import vista.PanelResultados;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class ClickEventPanelConsultas implements ActionListener {
 
    
    //---------------------------------------------------------
    //                      Atributos
    //--------------------------------------------------------- 
    private PanelConsultas panelConsultas;
    private PanelResultados panelResultados;

    
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public ClickEventPanelConsultas(PanelConsultas panelConsultas, PanelResultados panelResultados)
    {
        this.panelConsultas = panelConsultas;
        this.panelResultados = panelResultados;
    }
    
    
    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        if(actionEvent.getSource() == this.panelConsultas.getButConsultar())
        {
            
            String filtroStr = (String)panelConsultas.getCbxFiltro().getSelectedItem();
            String parametroStr = panelConsultas.getTxtParametro().getText();

            
            if(filtroStr.equals("Matricula"))
            {
                try
                {
                    int parametro = Integer.parseInt(parametroStr);

                    if (parametro < 0)
                    {

                        JOptionPane.showMessageDialog( null, "El valor de la matrícula debe ser positivo", "", JOptionPane.ERROR_MESSAGE );

                    }
                    else
                    {

                        VehiculoDAO vehiculoDAO = new VehiculoDAO();

                        VehiculoModel vehiculo = vehiculoDAO.obtenerVehiculoMatricula(parametro);
                        if(vehiculo != null){
                            ArrayList<VehiculoModel> vehiculos = new ArrayList<>();


                            vehiculos.add(vehiculo);

                            panelResultados.setTblResults(vehiculos);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog( null, "El vehículo no existe", "", JOptionPane.ERROR_MESSAGE );
                        }
                    }

                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog( null, "El valor de la matrícula debe ser numérico", "", JOptionPane.ERROR_MESSAGE );
                }
            
            }
            else if (filtroStr.equals("Nombre"))
            {
                
                VehiculoDAO vehiculoDAO = new VehiculoDAO();
                
                ArrayList<VehiculoModel> vehiculos = vehiculoDAO.obtenerVehiculosNombre(parametroStr);
                
                panelResultados.setTblResults(vehiculos);
 
            }

        }
        
        
    }
     
}
