package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;

/**
 *
 * @author Ricardo
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public boolean insertar(Cliente cliente) {
        String query = "INSERT INTO cliente(nombre, direccion, telefonos) VALUES(?, ?, ?)";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al intentar insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Cliente obtenerPorID(int idCliente) {
        String query = "SELECT idCliente, nombre, direccion, telefonos FROM cliente WHERE idCliente = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefonos")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cliente por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        String query = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefonos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        String query = "UPDATE cliente SET nombre = ?, direccion = ?, telefonos = ? WHERE idCliente = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            ps.setInt(4, cliente.getId());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        String query = "DELETE FROM cliente WHERE idCliente = ?";
        
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}