/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author jalt2
 */
public class Problema {
    private int idProblema;
    private Date fch_inicio;
    private Date fch_fin;
    private String estado;
    private int idCliente;

    public Problema() {
    }

    public Problema(int idProblema, Date fch_inicio, Date fch_fin, String estado, int idCliente) {
        this.idProblema = idProblema;
        this.fch_inicio = fch_inicio;
        this.fch_fin = fch_fin;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    /*Constructor sin id*/
    public Problema(Date fch_inicio, Date fch_fin, String estado, int idCliente) {
        this.fch_inicio = fch_inicio;
        this.fch_fin = fch_fin;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public Date getFch_inicio() {
        return fch_inicio;
    }

    public void setFch_inicio(Date fch_inicio) {
        this.fch_inicio = fch_inicio;
    }

    public Date getFch_fin() {
        return fch_fin;
    }

    public void setFch_fin(Date fch_fin) {
        this.fch_fin = fch_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
