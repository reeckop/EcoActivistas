/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import java.util.List;
import models.Activista;

/**
 *
 * @author omarb
 */
public interface IActivistaController {
    public boolean agregarActivista(String nombre, String correo, String telefono);
    Activista obtenerPorID(int idActivista);
    List<Activista> obtenerTodos();
    boolean actualizar(Activista activista);
    boolean eliminar(int idActivista);
}
