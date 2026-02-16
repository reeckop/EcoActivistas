/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Problema;

/**
 *
 * @author jalt2
 */
public class ProblemaDAO implements IProblemaDAO{

    public ProblemaDAO() {
    }
    
    
    
    @Override
    public boolean insertar(Problema problema) {
        String query = "INSERT INTO problema(fch_ini, fch_fin, estado,idCliente) VALUES(?, ?, ?,?)";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setDate(1, java.sql.Date.valueOf(problema.getFch_inicio()));
            ps.setDate(2, java.sql.Date.valueOf(problema.getFch_fin()));
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al intentar insertar el problema: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Problema obtenerPorID(int idProblema) {
        String query = "SELECT idProblema, fch_ini, fch_fin, estado, idCliente FROM problema WHERE idProblema = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, idProblema);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Date fechaIniSQL = rs.getDate("fch_ini");
                    Date fechaFinSQL = rs.getDate("fch_fin");
                    
                    return new Problema(
                        rs.getInt("idProblema"),
                        fechaIniSQL != null ? fechaIniSQL.toLocalDate() : null,
                        fechaFinSQL != null ? fechaFinSQL.toLocalDate() : null,
                        rs.getString("estado"),
                        rs.getInt("idCliente")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el problema por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Problema> obtenerTodos() {
        String query = "SELECT * FROM problema";
        List<Problema> problemas = new ArrayList<>();
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Date fechaIniSQL = rs.getDate("fch_ini");
                Date fechaFinSQL = rs.getDate("fch_fin");
                problemas.add(new Problema(
                    rs.getInt("idProblema"),
                    fechaIniSQL != null ? fechaIniSQL.toLocalDate() : null,
                    fechaFinSQL != null ? fechaFinSQL.toLocalDate() : null,
                    rs.getString("estado"),
                    rs.getInt("idCliente")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar problemas: " + e.getMessage());
        }
        return problemas;
    }

    @Override
    public boolean actualizarProblema(Problema problema) {
        String query = "UPDATE problema SET fch_ini = ?, fch_fin = ?, estado = ?, idCliente = ? WHERE idProblema = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setDate(1, java.sql.Date.valueOf(problema.getFch_inicio()));
            ps.setDate(2, java.sql.Date.valueOf(problema.getFch_fin()));
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            ps.setInt(5, problema.getIdProblema());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar problema: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarProblema(int idProblema) {
        String query = "DELETE FROM problema WHERE idProblema = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, idProblema);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar problema: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean finalizarProblema(int idProblema) {
        String query = "UPDATE problema SET fch_fin = CURDATE(), estado ='concluido'  WHERE idProblema = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            
            ps.setInt(1, idProblema);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al marcar problema como finalizado: " + e.getMessage());
            return false;
        }
        
    }
}
