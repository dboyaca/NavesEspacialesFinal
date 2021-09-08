/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.VehiculoModel;
import utils.ConexionDB;

/**
 *
 * @author Diego Boyacá & Felipe Padilla
 */
public class VehiculoDAO {

    //---------------------------------------------------------
    //                      Atributos
    //---------------------------------------------------------     
    private Connection conexion = null;
    
    //---------------------------------------------------------
    //                      Métodos
    //--------------------------------------------------------- 
    public ArrayList<VehiculoModel> obtenerTodoVehiculo()
    {
        ArrayList<VehiculoModel> vehiculos = new ArrayList<>();
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }
        try 
        {
        
        Statement declaraciones = conexion.createStatement();
        
            ResultSet rs = declaraciones.executeQuery(
                    "SELECT v_matricula, v_nombre, v_velocidad, v_longitud FROM vehiculo");
            
            while(rs.next())
            {
                VehiculoModel vehiculo = new VehiculoModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                vehiculos.add(vehiculo);
                
            }
            
            return vehiculos;
            
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    public VehiculoModel obtenerVehiculoMatricula(int matricula)
    {
        
        VehiculoModel vehiculo = null;
        
        boolean hayRegistros = false;
    
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }
        try 
        {
            String sql = "SELECT v_matricula, v_nombre, v_velocidad, v_longitud FROM vehiculo WHERE v_matricula = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
        
            consulta.setInt(1,matricula);
            
            ResultSet rs = consulta.executeQuery();
            
            while(rs.next())
            {
                vehiculo = new VehiculoModel(matricula, rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                hayRegistros = true;
            }
            
            return vehiculo;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        return vehiculo;
        
    }
    
    public ArrayList<VehiculoModel> obtenerVehiculosNombre(String nombre)
    {
        ArrayList<VehiculoModel> vehiculos = new ArrayList<>();
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }
        try 
        {
            String sql = "SELECT v_matricula, v_nombre, v_velocidad, v_longitud FROM vehiculo WHERE v_nombre LIKE ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, "%"+nombre+"%");
            
                    
            ResultSet rs = consulta.executeQuery();
            
            while(rs.next())
            {
                VehiculoModel vehiculo = new VehiculoModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                vehiculos.add(vehiculo);
            }
            
            return vehiculos;
            
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        return vehiculos;
    
    }
    
    
    public void crearVehiculo(VehiculoModel vehiculo)
    {
        
        int verificacion;
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }

        try 
        {
            String sql = "INSERT INTO vehiculo(v_matricula, v_nombre, v_velocidad, v_longitud) VALUES(?,?,?,?)";
            
            PreparedStatement consulta = conexion.prepareStatement(sql);
            
            consulta.setInt(1, vehiculo.getMatricula());
            consulta.setString(2, vehiculo.getNombre());
            consulta.setDouble(3, vehiculo.getVelocidad());
            consulta.setDouble(4, vehiculo.getLongitud());
            
            verificacion = consulta.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void borrarVehiculo(int matricula)
    {
        
        int verificacion = 0;
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }
        
        try 
        {
            
            String sql = "DELETE FROM vehiculo WHERE v_matricula = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            consulta.setInt(1, matricula);
            
            int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro que desea borrarlo?",
                            "Confirmacion",
                            JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION)
            {
                verificacion = consulta.executeUpdate();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se modificaron registros");
            }
            

            
            if(verificacion > 0)
            {
                JOptionPane.showMessageDialog(null, "Borrado exitoso");
            }

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        

    }
    
    public void actualizarVehiculo(VehiculoModel vehiculo)
    {
        
        int verificacion = 0;
        
        if ( conexion == null)
        {
            conexion = ConexionDB.darConexion();
        }
        
        try 
        {
            
            String sql = "UPDATE vehiculo SET v_nombre = ?, v_velocidad = ?, v_longitud = ? WHERE v_matricula = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);

            consulta.setString(1, vehiculo.getNombre());
            consulta.setDouble(2, vehiculo.getVelocidad());
            consulta.setDouble(3, vehiculo.getLongitud());
            consulta.setInt(4, vehiculo.getMatricula());
            
            verificacion = consulta.executeUpdate();

            if(verificacion > 0)
            {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado!");
            }

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        

    }
   
}
    
    
            
           
            
          
    
