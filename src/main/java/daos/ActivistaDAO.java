package daos;

import config.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Activista;

/**
 *
 * @author Ricardo
 */
public class ActivistaDAO implements IActivistaDAO {
    @Override
    public boolean insertar(Activista activista) {
        String query = "INSERT INTO activista(nombre, correo, telefono) VALUES(?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getCorreo());
            ps.setString(3, activista.getTelefono());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar activista: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Activista obtenerPorID(int idActivista) {
        String query = "SELECT * FROM activista WHERE idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idActivista);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Activista(rs.getInt("idActivista"), rs.getString("nombre"), 
                                        rs.getString("correo"), rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener activista: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activista> obtenerTodos() {
        String query = "SELECT * FROM activista";
        List<Activista> lista = new ArrayList<>();
        try (Connection con = ConexionDB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                lista.add(new Activista(rs.getInt("idActivista"), rs.getString("nombre"), 
                                        rs.getString("correo"), rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar activistas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Activista activista) {
        String query = "UPDATE activista SET nombre=?, correo=?, telefono=? WHERE idActivista=?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getCorreo());
            ps.setString(3, activista.getTelefono());
            ps.setInt(4, activista.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean eliminar(int idActivista) {
        String query = "DELETE FROM activista WHERE idActivista = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idActivista);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
