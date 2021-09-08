/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import utils.InitialData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.VehiculoModel;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class PanelResultados extends JPanel{
        
    //---------------------------------------------------------
    //                      Atributos
    //--------------------------------------------------------- 
    private JTable  tblResults;
    private JScrollPane jspPane;
    
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public PanelResultados()
    {

        this.tblResults = new JTable();
        
        //this.tblResults.setEnabled(false); DESACTIVAMOS LA SELECCIÓN DE FILAS
        
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        this.jspPane = new JScrollPane(this.tblResults);
        add(jspPane,BorderLayout.CENTER);
        
        setPreferredSize(new Dimension(1020, 800));
        
        InitialData initialData = new InitialData();
        
        ArrayList<VehiculoModel> vehiculos = initialData.getVehiculos();
        this.setTblResults(vehiculos);
        
    }
    
    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 
    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    
    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
    
    public void setTblResults(ArrayList<VehiculoModel> vehiculos) 
    {
        String[] headers = {"Matricula", "Nombre", "Velocidad", "Longitud"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        
        for(int i=0; i<vehiculos.size(); i++){
            tableModel.addRow(vehiculos.get(i).toArray());
        }
    }
        
        
}
