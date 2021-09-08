/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class LigeroModel extends VehiculoModel{

//---------------------------------------------------------
//                      Atributos
//---------------------------------------------------------
    
    private String color;
    private String androide;

//---------------------------------------------------------
//                      Constructores
//---------------------------------------------------------
    
    /**
     * Construye un objeto de tipo LigeroModel el cual es conducido por un Androide
     * @param unaMatricula
     * @param unNombre
     * @param unaVelocidad
     * @param unaLongitud
     * @param unColor
     * @param unAndroide 
     */
    public LigeroModel(int unaMatricula, String unNombre, double unaVelocidad, double unaLongitud, String unColor, String unAndroide) 
    {       
        super(unaMatricula, unNombre, unaVelocidad, unaLongitud);
        this.color    = unColor;
        this.androide = unAndroide;
    }

//---------------------------------------------------------
//                      Métodos
//---------------------------------------------------------
    /**
     * @return the color
     */
    public String getColor() 
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) 
    {
        this.color = color;
    }

    /**
     * @return the androide
     */
    public String getAndroide() 
    {
        return androide;
    }

    /**
     * @param androide the androide to set
     */
    public void setAndroide(String androide) 
    {
        this.androide = androide;
    }
    

    
}
