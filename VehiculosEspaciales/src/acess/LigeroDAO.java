/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.LigeroModel;
import modelo.VehiculoModel;
import utils.ConexionDB;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class LigeroDAO {
    
    private Connection conexion = null;
    
    public int crearLigero(LigeroModel ligero)
    {
        int verificacion;
        
       if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }

        try 
        {
            VehiculoDAO daovehiculo = new VehiculoDAO();
            
            VehiculoModel vehiculo = new VehiculoModel(ligero.getMatricula(), ligero.getNombre(), ligero.getVelocidad(), ligero.getLongitud());
            daovehiculo.crearVehiculo(vehiculo);
            
            String sql = "INSERT INTO ligero(l_matricula, l_color, l_androide) VALUES(?,?,?)";
            
            PreparedStatement consulta = conexion.prepareStatement(sql);
            
            consulta.setInt(1, ligero.getMatricula());
            consulta.setString(2, ligero.getColor());
            consulta.setString(3, ligero.getAndroide());
            
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
