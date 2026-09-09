/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redn_a_l_p;

/**
 *
 * @author Alejo
 */
import java.util.ArrayList;

public class Participante {
    
    private String identificacion;
    private String nombre;
    private String ciudad;
    private double aporte;
    private boolean pago;
    
    private ArrayList<Participante> hijos;

    public Participante(String identificacion, String nombre,
            String ciudad, double aporte) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.aporte = aporte;
        this.pago = false;
        this.hijos = new ArrayList<>();
    }
    
      public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public ArrayList<Participante> getHijos() {
        return hijos;
    }

    public void agregarHijo(Participante hijo) {
        hijos.add(hijo);
    }
}
