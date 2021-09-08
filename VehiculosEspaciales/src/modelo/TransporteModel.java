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
public class TransporteModel extends VehiculoModel {
    
//---------------------------------------------------------
//                      Atributos
//---------------------------------------------------------
    
    private int tripulantes;
    private int pasajeros;
    
//---------------------------------------------------------
//                      Constructores
//---------------------------------------------------------   
    
    public TransporteModel(int unaMatricula, String unNombre, double unaVelocidad, double unaLongitud, int tripulantes, int pasajeros) 
    {
        super(unaMatricula, unNombre, unaVelocidad, unaLongitud);
        this.tripulantes = tripulantes;
        this.pasajeros = pasajeros;
    }
    
//---------------------------------------------------------
//                      Métodos
//---------------------------------------------------------   

    /**
     * @return the tripulantes
     */
    public int getTripulantes() 
    {
        return tripulantes;
    }

    /**
     * @param tripulantes the tripulantes to set
     */
    public void setTripulantes(int tripulantes) 
    {
        this.tripulantes = tripulantes;
    }

    /**
     * @return the pasajeros
     */
    public int getPasajeros() 
    {
        return pasajeros;
    }

    /**
     * @param pasajeros the pasajeros to set
     */
    public void setPasajeros(int pasajeros) 
    {
        this.pasajeros = pasajeros;
    }
    
    
    
}
