package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class VehiculoModel {

//---------------------------------------------------------
//                      Atributos
//---------------------------------------------------------
    
    protected int matricula;
    protected String nombre;
    protected double velocidad;
    protected double longitud;
    
//---------------------------------------------------------
//                      Constructores
//---------------------------------------------------------    
    
    /**
     * Construye un objeto de tipo VehículoModel
     * @param unaMatricula
     * @param unNombre
     * @param unaVelocidad
     * @param unaLongitud 
     */
    public VehiculoModel(int unaMatricula, String unNombre, double unaVelocidad, double unaLongitud)
    {
        this.matricula = unaMatricula;
        this.nombre    = unNombre;
        this.velocidad = unaVelocidad;
        this.longitud  = unaLongitud;
    }

//---------------------------------------------------------
//                      Métodos
//--------------------------------------------------------- 

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the velocidad
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }
    
    public String toString()
    {

        return this.nombre;
    }
    
    /**
     * Método usado con fines de que la tabla principal pueda insertar cada objeto
     * @return data
     */
    public Object[] toArray()
    {
        Object[] data = {matricula, nombre, velocidad, longitud};
        return data;
    }
    
}
