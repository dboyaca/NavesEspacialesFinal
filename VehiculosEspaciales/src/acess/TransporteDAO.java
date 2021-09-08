/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.TransporteModel;
import modelo.VehiculoModel;
import utils.ConexionDB;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class TransporteDAO {
    
    private Connection conexion = null;
    
    
    public int crearTransporte(TransporteModel transporte)
    {
        int verificacion;
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }

        try 
        {
            VehiculoDAO daovehiculo = new VehiculoDAO();
            
            VehiculoModel vehiculo = new VehiculoModel(
                    transporte.getMatricula(),
                    transporte.getNombre(),
                    transporte.getVelocidad(),
                    transporte.getLongitud());
            
            daovehiculo.crearVehiculo(vehiculo);
            
            String sql = "INSERT INTO transporte(t_matricula, t_tripulantes, t_pasajeros) VALUES(?,?,?)";
            
            PreparedStatement consulta = conexion.prepareStatement(sql);
            
            consulta.setInt(1, transporte.getMatricula());
            consulta.setInt(2, transporte.getTripulantes());
            consulta.setInt(3, transporte.getPasajeros());
            
            verificacion = consulta.executeUpdate();
            
            if (verificacion > 0)
            {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
                return verificacion;
            }
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        return 0;
    }
    
    
    
    
}
