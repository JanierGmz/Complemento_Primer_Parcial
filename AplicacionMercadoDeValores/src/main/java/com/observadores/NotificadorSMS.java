/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.observadores;

import com.modelo.Accion;


/**
 *
 * @author Janier Yulder Gomez Galindez
 * @author Harold Andres Molano Rosero
 */
public class NotificadorSMS implements Observador {
    private String numeroTelefono;

    public NotificadorSMS(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void actualizar(Accion accion) {
        double precioActual = accion.getPrecioActual();
        double umbralInferior = accion.getUmbralInferior();
        double umbralSuperior = accion.getUmbralSuperior();
        String nombreAccion = accion.getNombre();

        if (precioActual <= umbralInferior || precioActual >= umbralSuperior) {
            enviarMensaje(nombreAccion, precioActual);
        }
    }

    private void enviarMensaje(String nombreAccion, double precioActual) {
        // Lógica para enviar un mensaje SMS al número de teléfono especificado
        System.out.println("SMS enviado a " + numeroTelefono + ": El precio de " + nombreAccion + " ha alcanzado $" + precioActual);
    }
}
