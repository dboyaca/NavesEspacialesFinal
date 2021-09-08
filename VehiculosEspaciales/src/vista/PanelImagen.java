/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class PanelImagen extends JPanel {
    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------     
    private JLabel lblImagen;
    
    //---------------------------------------------------------
    //                      Constructor
    //---------------------------------------------------------     
    public PanelImagen()
    {
        setLayout( new BorderLayout( ) );

        setPreferredSize(new Dimension(600, 140));
        ImageIcon icono = new ImageIcon( "./data/imagenes/encabezado2.jpg");
        lblImagen = new JLabel( "" );

        lblImagen.setIcon( icono );
        lblImagen.setBorder( new TitledBorder( "" ) );
        add( lblImagen, BorderLayout.CENTER );
        
    }
    
}
