/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import java.util.List;
import models.Problema;

/**
 *
 * @author omarb
 */
public interface IProblemaController {
    public boolean insertarProblema(Problema problema);
    Problema obtenerPorID(int idProblema);
    List<Problema> obtenerTodos();
    boolean actualizarProblema(Problema problema);
    boolean eliminarProblema(int idProblema);
    boolean finalizarProblema(int idProblema);
}
