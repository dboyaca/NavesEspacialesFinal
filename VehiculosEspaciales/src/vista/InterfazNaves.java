/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.org.apache.xerces.internal.xs.PSVIProvider;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class InterfazNaves extends JFrame{
    
    
    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------         
    PanelImagen imagen;
    PanelResultados panelResultados;
    PanelSouth panelSouth;
    

    //---------------------------------------------------------
    //                      Constructor
    //--------------------------------------------------------- 
    public InterfazNaves()
    {
        //Propiedades de la ventana principal
        
        setSize(600,750);
        setResizable(false);
        setTitle("Naves Espaciales");
        setVisible(true); 
        setLayout(new BorderLayout());
        
        //Inicialización de los componentes de la ventana
        
        imagen = new PanelImagen();
        panelResultados = new PanelResultados();
        panelSouth = new PanelSouth(panelResultados);
        
        //  panelControles = new PanelControles();

        //Agregar componentes a la interfaz
        
        add(imagen, BorderLayout.NORTH);
        
        add(panelResultados, BorderLayout.CENTER);
                
        add(panelSouth, BorderLayout.SOUTH);
        
        //  add(panelControles, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
       
    public static void main(String[] args) 
    {
        InterfazNaves intefaz = new InterfazNaves();

    }
    
}
