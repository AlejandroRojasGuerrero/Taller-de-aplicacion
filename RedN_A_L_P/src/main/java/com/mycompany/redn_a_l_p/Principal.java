/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redn_a_l_p;

/**
 *
 * @author Alejo
 */
import java.util.Scanner;
public class Principal {
      public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArbolN red = new ArbolN();

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("        RED N - REDN");
            System.out.println("==============================");
            System.out.println("1. Configurar red");
            System.out.println("2. Registrar participante");
            System.out.println("3. Buscar participante");
            System.out.println("4. Mostrar red");
            System.out.println("5. Total aportado");
            System.out.println("6. Aporte por ciudad");
            System.out.println("7. Cantidad de participantes");
            System.out.println("8. Altura de la red");
            System.out.println("9. Total pendiente");
            System.out.println("10. Realizar pagos");
            System.out.println("0. Salir");
            System.out.println("==============================");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Aporte mínimo: ");
                    double minimo = teclado.nextDouble();

                    System.out.print("Porcentaje de retorno: ");
                    double porcentaje = teclado.nextDouble();

                    red.setAporteMinimo(minimo);
                    red.setPorcentajeRetorno(porcentaje);

                    System.out.println(
                            "Configuración realizada.");

                    break;

                case 2:

                    System.out.print("Identificación: ");
                    String id = teclado.nextLine();

                    if (red.buscar(id) != null) {

                        System.out.println(
                                "ERROR: la identificación ya existe.");

                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ciudad: ");
                    String ciudad = teclado.nextLine();

                    System.out.print("Aporte: ");
                    double aporte = teclado.nextDouble();
                    teclado.nextLine();

                    if (nombre.isEmpty() || ciudad.isEmpty()) {

                        System.out.println(
                                "ERROR: nombre y ciudad "
                                + "no pueden estar vacíos.");

                        break;
                    }

                    if (aporte < red.getAporteMinimo()) {

                        System.out.println(
                                "ERROR: el aporte debe ser "
                                + "mayor o igual al mínimo.");

                        break;
                    }

                    Participante nuevo =
                            new Participante(
                                    id,
                                    nombre,
                                    ciudad,
                                    aporte);

                    if (red.getRaiz() == null) {

                        red.agregarRaiz(nuevo);

                        System.out.println(
                                "Participante registrado como raíz.");

                    } else {

                        System.out.print(
                                "Identificación del padre: ");

                        String padre = teclado.nextLine();

                        if (red.agregarHijo(padre, nuevo)) {

                            System.out.println(
                                    "Participante registrado.");

                        } else {

                            System.out.println(
                                    "ERROR: el padre no existe.");
                        }
                    }

                    break;

                case 3:

                    System.out.print(
                            "Identificación a buscar: ");

                    String buscar = teclado.nextLine();

                    Participante encontrado =
                            red.buscar(buscar);

                    if (encontrado != null) {

                        System.out.println(
                                "\nParticipante encontrado:");
                        System.out.println(
                                "ID: "
                                + encontrado.getIdentificacion());
                        System.out.println(
                                "Nombre: "
                                + encontrado.getNombre());
                        System.out.println(
                                "Ciudad: "
                                + encontrado.getCiudad());
                        System.out.println(
                                "Aporte: $"
                                + encontrado.getAporte());
                        System.out.println(
                                "Estado: "
                                + (encontrado.isPago()
                                ? "Pagado"
                                : "Pendiente"));

                    } else {

                        System.out.println(
                                "Participante no encontrado.");
                    }

                    break;

                case 4:

                    System.out.println(
                            "\n--- ESTRUCTURA DE LA RED ---");

                    red.preorden();

                    break;

                case 5:

                    System.out.println(
                            "Total aportado: $"
                            + red.totalAportado());

                    break;

                case 6:

                    System.out.print("Ciudad: ");
                    String ciudadBuscar =
                            teclado.nextLine();

                    System.out.println(
                            "Total aportado en "
                            + ciudadBuscar
                            + ": $"
                            + red.totalPorCiudad(
                                    ciudadBuscar));

                    break;

                case 7:

                    System.out.println(
                            "Cantidad de participantes: "
                            + red.contar());

                    break;

                case 8:

                    System.out.println(
                            "Altura de la red: "
                            + red.altura());

                    break;

                case 9:

                    System.out.println(
                            "Total pendiente: $"
                            + red.pendiente());

                    break;

                case 10:

                    System.out.print(
                            "Dinero disponible: $");

                    double dinero =
                            teclado.nextDouble();

                    System.out.println(
                            "\n--- PROCESO DE PAGO ---");

                    double restante =
                            red.pagar(dinero);

                    System.out.println(
                            "Dinero restante: $"
                            + restante);

                    break;

                case 0:

                    System.out.println(
                            "Programa finalizado.");

                    break;

                default:

                    System.out.println(
                            "Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
