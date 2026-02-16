package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Cliente;

/**
 *
 * @author LABORATORIOS
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public boolean insertar(Cliente cliente) {
        String query = "INSERT INTO cliente(nombre, direccion, telefonos) VALUES(?, ?, ?)";
        
        try {
            Connection con = ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(1, cliente.getDireccion());
            ps.setString(1, cliente.getTelefonos());
            
        } catch (SQLException e) {
            System.out.println("Error al intentar insertar el cliente" + e.getMessage());
        }
    }

    @Override
    public Cliente obtenerPorID(int idCliente) {
        String query = "SELECT * FROM clientes WHERE idCliente = ?";
        Cliente cliente = null;
        
        try {
            Connection con = ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(idCliente);
                cliente.setNombre(query);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al intentar insertar el cliente" + e.getMessage());
        }
    }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
