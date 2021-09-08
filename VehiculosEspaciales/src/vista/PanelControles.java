/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClickEventPanelControles;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class PanelControles extends JPanel{
    
    //--------------------------------------------
    //              Constantes
    //--------------------------------------------
    
    public final static String BORRAR = "Borrar";
    public final static String ACTUALIZAR = "Actualizar";
    public final static String CONSULTAR = "Consultar";
    public final static String CREAR = "Crear";
    
    
    
    
    //--------------------------------------------
    //              Atributos
    //--------------------------------------------
    
    private JLabel labCrear;
    private JLabel labEliminar;
    private JLabel labActualizar;
    
    private JComboBox cbxTipoVehiculo;
    
    private JButton butBorrar;
    private JButton butActualizar;
    private JButton butCrear;
    
    
    //private PanelAgregar panelAgregar;
    
    //--------------------------------------------
    //              Constructor
    //--------------------------------------------
    public PanelControles( PanelResultados panelResultados )
    {
        
        //Configuración propiedades del Panel
        
        setLayout( new GridLayout(1,5,4,0) );
        setVisible(true);
        TitledBorder border = BorderFactory.createTitledBorder("Control Vehiculos");
        border.setTitleColor(Color.DARK_GRAY);
        setBorder(border);
        
        // Inicialización de componentes del panel
        
        //this.labCrear = new JLabel("Agregar");
        //this.labEliminar = new JLabel("Agregar Nave");
        //this.labActualizar = new JLabel("Agregar Nave");
        
        
        this.butBorrar = new JButton(BORRAR);
        
        this.butActualizar = new JButton(ACTUALIZAR);
        
        this.butCrear = new JButton(CREAR);
        
        this.cbxTipoVehiculo = new JComboBox();
        
        this.cbxTipoVehiculo.addItem("Ligero");
        this.cbxTipoVehiculo.addItem("Transporte");
        this.cbxTipoVehiculo.setSelectedIndex(0);
        
        // Agregar componentes al Panel
        
        add(this.cbxTipoVehiculo);
        
        ClickEventPanelControles clickEvent = new ClickEventPanelControles(this, panelResultados);
        
        //BOTÓN CREAR
        add(this.butCrear);       
        this.butCrear.addActionListener(clickEvent);


        add(new JLabel(""));
        
        
        //BOTÓN ACTUALIZAR
        add(this.butActualizar);
        this.butActualizar.addActionListener(clickEvent);
        
        
        //BOTÓN BORRAR
        add(this.butBorrar);
        this.butBorrar.addActionListener(clickEvent);
        
        
        

    }

    /**
     * @return the labCrear
     */
    public JLabel getLabCrear() {
        return labCrear;
    }

    /**
     * @return the labEliminar
     */
    public JLabel getLabEliminar() {
        return labEliminar;
    }

    /**
     * @return the labActualizar
     */
    public JLabel getLabActualizar() {
        return labActualizar;
    }

    /**
     * @return the butBorrar
     */
    public JButton getButBorrar() {
        return butBorrar;
    }

    /**
     * @return the butActualizar
     */
    public JButton getButActualizar() {
        return butActualizar;
    }

    /**
     * @return the butCrear
     */
    public JButton getButCrear() {
        return butCrear;
    }

    /**
     * @return the cbxTipoVehiculo
     */
    public JComboBox getCbxTipoVehiculo() {
        return cbxTipoVehiculo;
    }


    
    
}
