/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author daya
 */
public class ProblemaActivistaDAO implements IProblemaActivistaDAO{
    @Override
    public boolean insertar(ProblemaActivista problemaActivista) {
        String query = "INSERT INTO atiende(idProblema, idActivista) VALUES(?, ?)";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, problemaActivista.getIdProblema());
            ps.setInt(2, problemaActivista.getIdActivista());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar relación problema-activista: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ProblemaActivista obtenerPorID(int idProblema, int idActivista) {
        String query = "SELECT idProblema, idActivista FROM atiende WHERE idProblema = ? AND idActivista = ?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idProblema);
            ps.setInt(2, idActivista);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ProblemaActivista(
                            rs.getInt("idProblema"),
                            rs.getInt("idActivista")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener relación problema-activista: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<ProblemaActivista> obtenerTodos() {
        String query = "SELECT idProblema, idActivista FROM atiende";
        List<ProblemaActivista> lista = new ArrayList<>();

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new ProblemaActivista(
                        rs.getInt("idProblema"),
                        rs.getInt("idActivista")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar relaciones problema-activista: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean eliminar(int idProblema, int idActivista) {
        String query = "DELETE FROM atiende WHERE idProblema = ? AND idActivista = ?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idProblema);
            ps.setInt(2, idActivista);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar relación problema-activista: " + e.getMessage());
            return false;
        }
    }
}
