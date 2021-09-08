/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClickEventDialogoActualizar;
import controlador.ClickEventDialogoLigero;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.VehiculoModel;
import static vista.DialogoCrearVehiculoLigero.ACEPTAR;
import static vista.DialogoCrearVehiculoLigero.CANCELAR;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class DialogoActualizarVehiculo extends JDialog{
    // -----------------------------------------------------------------
    //                          Constantes 
    // -----------------------------------------------------------------    
    
    public static final String ACTUALIZAR = "Actualizar";
    public static final String CANCELAR = "Cancelar";
    
    // -----------------------------------------------------------------
    //                          Atributos 
    // -----------------------------------------------------------------
    
    private JButton butActualizar;
    private JButton butCancelar;
    
    private JLabel labMatricula;
    private JLabel labNombre;
    private JLabel labVelocidad;
    private JLabel labLongitud;

    
    private JTextField txtMatricula;
    private JTextField txtNombre;
    private JTextField txtVelocidad;
    private JTextField txtLongitud;

    
    public DialogoActualizarVehiculo(VehiculoModel vehiculo, PanelResultados panelResultados)
    {
        setTitle( "Actualizar vehículo" );
        setSize( 430, 280 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        setLayout( new GridLayout( 5, 2, 5, 5 ) );
        
        this.labMatricula = new JLabel("Matricula: ");
        add(labMatricula);
        this.txtMatricula = new JTextField();
        add(txtMatricula);
        this.txtMatricula.setText(Integer.toString(vehiculo.getMatricula()));
        this.txtMatricula.setEditable(false);
        
        
        this.labNombre = new JLabel("Nombre: ");
        add(labNombre);
        this.txtNombre = new JTextField();
        add(txtNombre);  
        this.txtNombre.setText(vehiculo.getNombre());

        
        this.labVelocidad = new JLabel("Velocidad: ");
        add(labVelocidad);
        this.txtVelocidad = new JTextField();
        add(txtVelocidad); 
        this.txtVelocidad.setText(Double.toString(vehiculo.getVelocidad()));

        
        this.labLongitud = new JLabel("Longitud: ");
        add(labLongitud);
        this.txtLongitud = new JTextField();
        add(txtLongitud);
        this.txtLongitud.setText(Double.toString(vehiculo.getLongitud()));

        
        ClickEventDialogoActualizar clickEvent = new ClickEventDialogoActualizar(this, panelResultados);

        
        //BOTÓN ACTUALIZAR
        this.butActualizar = new JButton(ACTUALIZAR);
        add(butActualizar);
        this.butActualizar.addActionListener(clickEvent);
        
        //BOTÓN CANCELAR
        this.butCancelar = new JButton(CANCELAR);
        add(butCancelar);
        this.butCancelar.addActionListener(clickEvent);
        
        
    }

    public DialogoActualizarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the butActualizar
     */
    public JButton getButActualizar() {
        return butActualizar;
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
    
}
