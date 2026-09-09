/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redn_a_l_p;

/**
 *
 * @author Alejo
 */
public class ArbolN {
    private Participante raiz;
    private double aporteMinimo;
    private double porcentajeRetorno;

    public ArbolN() {
        raiz = null;
    }

    public Participante getRaiz() {
        return raiz;
    }

    public void setAporteMinimo(double aporteMinimo) {
        this.aporteMinimo = aporteMinimo;
    }

    public double getAporteMinimo() {
        return aporteMinimo;
    }

    public void setPorcentajeRetorno(double porcentajeRetorno) {
        this.porcentajeRetorno = porcentajeRetorno;
    }

    public double getPorcentajeRetorno() {
        return porcentajeRetorno;
    }
    public boolean agregarRaiz(Participante participante) {

        if (raiz == null) {
            raiz = participante;
            return true;
        }

        return false;
    }
    public Participante buscar(String id) {

        return buscarRecursivo(raiz, id);
    }

    private Participante buscarRecursivo(
            Participante actual, String id) {

        if (actual == null) {
            return null;
        }

        if (actual.getIdentificacion().equals(id)) {
            return actual;
        }

        for (Participante hijo : actual.getHijos()) {

            Participante encontrado =
                    buscarRecursivo(hijo, id);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }
    public boolean agregarHijo(String idPadre,
            Participante nuevo) {

        Participante padre = buscar(idPadre);

        if (padre != null) {
            padre.agregarHijo(nuevo);
            return true;
        }

        return false;
    }
    public void preorden() {

        preordenRecursivo(raiz, 0);
    }
    private void preordenRecursivo(
            Participante actual, int nivel) {

        if (actual == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }

        System.out.println("- " + actual.getNombre()
                + " | ID: " + actual.getIdentificacion()
                + " | Ciudad: " + actual.getCiudad()
                + " | Aporte: $" + actual.getAporte());

        for (Participante hijo : actual.getHijos()) {
            preordenRecursivo(hijo, nivel + 1);
        }
    }
    public double totalAportado() {

        return totalAportadoRecursivo(raiz);
    }

    private double totalAportadoRecursivo(
            Participante actual) {

        if (actual == null) {
            return 0;
        }

        double total = actual.getAporte();

        for (Participante hijo : actual.getHijos()) {
            total += totalAportadoRecursivo(hijo);
        }

        return total;
    }
    public double totalPorCiudad(String ciudad) {

        return totalPorCiudadRecursivo(raiz, ciudad);
    }

    private double totalPorCiudadRecursivo(
            Participante actual, String ciudad) {

        if (actual == null) {
            return 0;
        }

        double total = 0;

        if (actual.getCiudad().equalsIgnoreCase(ciudad)) {
            total = actual.getAporte();
        }

        for (Participante hijo : actual.getHijos()) {
            total += totalPorCiudadRecursivo(hijo, ciudad);
        }

        return total;
    }
    public int contar() {

        return contarRecursivo(raiz);
    }

    private int contarRecursivo(Participante actual) {

        if (actual == null) {
            return 0;
        }

        int cantidad = 1;

        for (Participante hijo : actual.getHijos()) {
            cantidad += contarRecursivo(hijo);
        }

        return cantidad;
    }
    public int altura() {

        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(Participante actual) {

        if (actual == null) {
            return 0;
        }

        int mayor = 0;

        for (Participante hijo : actual.getHijos()) {

            int altura = alturaRecursiva(hijo);

            if (altura > mayor) {
                mayor = altura;
            }
        }

        return mayor + 1;
    }
    public double pendiente() {

        return pendienteRecursivo(raiz);
    }

    private double pendienteRecursivo(
            Participante actual) {

        if (actual == null) {
            return 0;
        }

        double total = 0;

        if (!actual.isPago()) {

            double retorno =
                    actual.getAporte()
                    * porcentajeRetorno / 100;

            total = actual.getAporte() + retorno;
        }

        for (Participante hijo : actual.getHijos()) {
            total += pendienteRecursivo(hijo);
        }

        return total;
    }
    public double pagar(double dinero) {

        return pagarRecursivo(raiz, dinero);
    }

    private double pagarRecursivo(
            Participante actual, double dinero) {

        if (actual == null) {
            return dinero;
        }

        double pago = actual.getAporte()
                + (actual.getAporte()
                * porcentajeRetorno / 100);

        if (!actual.isPago() && dinero >= pago) {

            dinero = dinero - pago;
            actual.setPago(true);

            System.out.println(
                    "Pago realizado a: "
                    + actual.getNombre()
                    + " | $" + pago);

        } else if (!actual.isPago()) {

            System.out.println(
                    "No se puede pagar a: "
                    + actual.getNombre());
        }

        for (Participante hijo : actual.getHijos()) {

            dinero = pagarRecursivo(hijo, dinero);
        }

        return dinero;
    }
}
