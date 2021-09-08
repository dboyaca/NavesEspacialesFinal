/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClickEventDialogoLigero;
import controlador.ClickEventPanelControles;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class DialogoCrearVehiculoLigero extends JDialog {
    // -----------------------------------------------------------------
    //                          Constantes 
    // -----------------------------------------------------------------    
    
    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    
    // -----------------------------------------------------------------
    //                          Atributos 
    // -----------------------------------------------------------------
    
    private JButton butAceptar;
    private JButton butCancelar;
    
    private JLabel labMatricula;
    private JLabel labNombre;
    private JLabel labVelocidad;
    private JLabel labLongitud;
    //
    private JLabel labColor;
    private JLabel labAndroide;
    
    private JTextField txtMatricula;
    private JTextField txtNombre;
    private JTextField txtVelocidad;
    private JTextField txtLongitud;
    //
    private JTextField txtColor;
    private JTextField txtAndroide;
    
    
    
    // -----------------------------------------------------------------
    //                          Constructor 
    // -----------------------------------------------------------------
    
    public DialogoCrearVehiculoLigero(PanelResultados panelResultados)
    {
        setTitle( "Crear Vehículo Ligero" );
        setSize( 430, 280 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        setLayout( new GridLayout( 7, 2, 5, 5 ) );
        
        this.labMatricula = new JLabel("Matricula: ");
        add(labMatricula);
        this.txtMatricula = new JTextField();
        add(txtMatricula);
        
        this.labNombre = new JLabel("Nombre: ");
        add(labNombre);
        this.txtNombre = new JTextField();
        add(txtNombre);     
        
        this.labVelocidad = new JLabel("Velocidad: ");
        add(labVelocidad);
        this.txtVelocidad = new JTextField();
        add(txtVelocidad);  
        
        this.labLongitud = new JLabel("Longitud: ");
        add(labLongitud);
        this.txtLongitud = new JTextField();
        add(txtLongitud);        
        
        this.labColor = new JLabel("Color: ");
        add(labColor);
        this.txtColor = new JTextField();
        add(txtColor);        
        
        this.labAndroide = new JLabel("Androide ");
        add(labAndroide);
        this.txtAndroide = new JTextField();
        add(txtAndroide);        
        
        
        ClickEventDialogoLigero clickEvent = new ClickEventDialogoLigero(this, panelResultados);
        
        //BOTÓN ACEPTAR
        this.butAceptar = new JButton(ACEPTAR);
        add(butAceptar);
        this.butAceptar.addActionListener(clickEvent);
        
        //BOTÓN CANCELAR
        this.butCancelar = new JButton(CANCELAR);
        add(butCancelar);
        this.butCancelar.addActionListener(clickEvent);
                
    }


    /**
     * @return the butAceptar
     */
    public JButton getButAceptar() {
        return butAceptar;
    }

    /**
     * @return the butCancelar
     */
    public JButton getButCancelar() {
        return butCancelar;
    }

    /**
     * @return the txtMatricula
     */
    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    /**
     * @return the txtNombre
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * @return the txtVelocidad
     */
    public JTextField getTxtVelocidad() {
        return txtVelocidad;
    }

    /**
     * @return the txtLongitud
     */
    public JTextField getTxtLongitud() {
        return txtLongitud;
    }

    /**
     * @return the txtColor
     */
    public JTextField getTxtColor() {
        return txtColor;
    }

    /**
     * @return the txtAndroide
     */
    public JTextField getTxtAndroide() {
        return txtAndroide;
    }
    
    public void resetearDialogo()
    {
        txtMatricula.setText("");
        txtNombre.setText("");
        txtVelocidad.setText("");
        txtLongitud.setText("");
        txtColor.setText("");
        txtAndroide.setText("");
    }
    
    
}
