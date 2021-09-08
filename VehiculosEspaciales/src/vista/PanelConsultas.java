/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClickEventPanelConsultas;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class PanelConsultas extends JPanel{
    
    
    //--------------------------------------------
    //              Constantes
    //--------------------------------------------
    
    public final static String CONSULTAR = "Consultar";
    
    //--------------------------------------------
    //              Atributos
    //--------------------------------------------
    
    
    private JButton butConsultar;
    private JLabel labFiltro;
    private JComboBox cbxFiltro;
    private JLabel labParametro;
    private JTextField txtParametro;
    
    //--------------------------------------------
    //              Constructor
    //--------------------------------------------
    public PanelConsultas(PanelResultados panelResultados)
    {
        setLayout( new GridLayout(1,6,6,0) );
        setVisible(true);
        
        TitledBorder border = BorderFactory.createTitledBorder("Consultar  Vehículos");
        border.setTitleColor(Color.DARK_GRAY);
        setBorder(border);
        
        
        this.labFiltro = new JLabel("Filtrar por: ");
        this.labParametro = new JLabel("Parametro: ");
        
        this.txtParametro = new JTextField();
        this.cbxFiltro = new JComboBox();
        
        this.butConsultar = new JButton(CONSULTAR);
        
        cbxFiltro.addItem("Matricula");
        cbxFiltro.addItem("Nombre");
       
        cbxFiltro.setSelectedIndex(0);
        
        add(this.labFiltro);
        add(this.cbxFiltro);
        add(new JLabel(""));
        add(this.labParametro);
        add(this.txtParametro);
        
        
        ClickEventPanelConsultas clickEvent = new ClickEventPanelConsultas(this, panelResultados);
        
        //BOTÓN CONSULTAR
        add(this.butConsultar);
        this.butConsultar.addActionListener(clickEvent);
 
    }

    /**
     * @return the butConsultar
     */
    public JButton getButConsultar() {
        return butConsultar;
    }

    /**
     * @return the cbxFiltro
     */
    public JComboBox getCbxFiltro() {
        return cbxFiltro;
    }

    /**
     * @return the txtParametro
     */
    public JTextField getTxtParametro() {
        return txtParametro;
    }
    
    
}
