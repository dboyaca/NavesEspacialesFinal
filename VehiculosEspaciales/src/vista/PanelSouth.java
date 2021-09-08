/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class PanelSouth extends JPanel{
        
    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------
    private PanelControles panelControles;
    private PanelConsultas panelConsultas;
    
    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public PanelSouth(PanelResultados panelResultados)
    {
        TitledBorder border = BorderFactory.createTitledBorder("");
        border.setTitleColor(Color.DARK_GRAY);
        setBorder(border);
        
        setLayout(new GridLayout(2,1));
        
        
        setVisible(true);
        
        
        panelConsultas = new PanelConsultas(panelResultados);
        
        add(panelConsultas);
        
        
        panelControles = new PanelControles(panelResultados);

        add(panelControles);

        
    }
    
}
