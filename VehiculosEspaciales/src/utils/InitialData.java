/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import acess.VehiculoDAO;
import java.util.ArrayList;
import modelo.VehiculoModel;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class InitialData {
    
    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------       
    private ArrayList<VehiculoModel> vehiculos = null;
    
    public InitialData()
    {
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        this.vehiculos = vehiculoDAO.obtenerTodoVehiculo();
    }
    
    
    //---------------------------------------------------------
    //                      Métodos
    //---------------------------------------------------------     
    /**
     * @return the vehicles
     */
    public ArrayList<VehiculoModel> getVehiculos() {
        return vehiculos;
    }
}
