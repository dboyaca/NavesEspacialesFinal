/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClickEventDialogoTransporte;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class DialogoCrearVehiculoTransporte extends JDialog{
    
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
    private JLabel labTripulantes;
    private JLabel labPasajeros;
    

    private JTextField txtMatricula;
    private JTextField txtNombre;
    private JTextField txtVelocidad;
    private JTextField txtLongitud;
    private JTextField txtTripulantes;
    private JTextField txtPasajeros;
    
    // -----------------------------------------------------------------
    //                          Constructor 
    // -----------------------------------------------------------------
    
    public DialogoCrearVehiculoTransporte(PanelResultados panelResultados)
    {
        setTitle( "Crear Vehículo Transporte" );
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

        this.labTripulantes = new JLabel("Tripulantes: ");
        add(labTripulantes);
        this.txtTripulantes = new JTextField();
        add(txtTripulantes);        
        
        this.labPasajeros = new JLabel("Pasajeros: ");
        add(labPasajeros);
        this.txtPasajeros = new JTextField();
        add(txtPasajeros);        
        
        
        ClickEventDialogoTransporte clickEvent = new ClickEventDialogoTransporte(this, panelResultados);
        
        //BOTÓN CREAR 
        this.butAceptar = new JButton(ACEPTAR);
        add(butAceptar);
        this.butAceptar.addActionListener(clickEvent);
        
        //BOTÓN CANCELAR
        this.butCancelar = new JButton(CANCELAR);
        add(butCancelar);
        this.butCancelar.addActionListener(clickEvent);
    //RECUERDE MOSTRARLO VISIBLE CUANDO LO LLEVE AL CONTROLADOR
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
     * @return the txtTripulantes
     */
    public JTextField getTxtTripulantes() {
        return txtTripulantes;
    }

    /**
     * @return the txtPasajeros
     */
    public JTextField getTxtPasajeros() {
        return txtPasajeros;
    }
    
    public void resetearDialogo()
    {
        txtMatricula.setText("");
        txtNombre.setText("");
        txtVelocidad.setText("");
        txtLongitud.setText("");
        txtTripulantes.setText("");
        txtPasajeros.setText("");
    }
}
