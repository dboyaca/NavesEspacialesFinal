/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import acess.LigeroDAO;
import acess.TransporteDAO;
import acess.VehiculoDAO;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Diego Boyacá
 */
public class IntefazVehEspacialesTests {
    
    public static void main(String[] args) {
        
        VehiculoDAO daovehiculo = new VehiculoDAO();
        LigeroDAO daoligero = new LigeroDAO();
        TransporteDAO daotransporte = new TransporteDAO();
        ArrayList<VehiculoModel> vehicles = new ArrayList<>();
        
        
        /*
        ArrayList<VehiculoModel> vehiculos = daovehiculo.obtenerTodoVehiculo();
        
        for(VehiculoModel veh: vehiculos)
        {
            System.out.println(veh);
        }
        */
        
        /*
        int actualizadas = daovehiculo.crearVehiculo(new VehiculoModel(13, "Raptor", 13.8, 25));
        
        System.out.println(actualizadas);
        */
        
     
        /*
        daoligero.crearLigero(new LigeroModel(21, "Raptor2", 13.8, 25, "Blanco", "Android"));
        */
        
        /*
        daotransporte.crearTransporte(new TransporteModel(15, "Transmi", 20, 25, 2, 250));
        */
        
        vehicles = daovehiculo.obtenerVehiculosNombre("Ejecutor");
        
        for (VehiculoModel vehicle : vehicles)
        {
            System.out.println(vehicle);
        }

    }
      
}
