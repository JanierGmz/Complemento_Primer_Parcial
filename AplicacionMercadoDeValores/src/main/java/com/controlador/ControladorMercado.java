/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlador;

import com.modelo.Accion;
import com.observadores.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Janier Yulder Gomez Galindez
 * @author Harold Andres Molano Rosero
 */
// Controlador: Clase que gestiona las interacciones del usuario
public class ControladorMercado {
    private List<Accion> acciones = new ArrayList<>();

    public boolean agregarAccion(String nombreAccion, double precioInicial) {
        String nombre = nombreAccion.toUpperCase();
        if(existeAccion(nombre)){
            return false;
        }
        Accion accion = new Accion(nombre, precioInicial);
        acciones.add(accion);
        return true;
    }

    public boolean establecerUmbrales(String nombreAccion, double umbralInferior, double umbralSuperior) {
        String nombre = nombreAccion.toUpperCase();
        boolean flag = false;
        for (Accion accion : acciones) {
            if (accion.getNombre().equals(nombre)) {
                flag = accion.establecerUmbrales(umbralInferior, umbralSuperior);
                break;
            }
        }
        return flag;
    }

    public void actualizarPrecioAccion(String nombreAccion, double nuevoPrecio) {
        String nombre = nombreAccion.toUpperCase();
        for (Accion accion : acciones) {
            if (accion.getNombre().equals(nombre)) {
                accion.actualizarPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public void agregarObservador(String nombreAccion, Observador observador) {
        String nombre = nombreAccion.toUpperCase();
        for (Accion accion : acciones) {
            if (accion.getNombre().equals(nombre)) {
                accion.agregarObservador(observador);
                break;
            }
        }
    }

    public List<Accion> obtenerAcciones() {
        return acciones;
    }

    public void eliminarAccion(String nombreAccion) {
        String nombre = nombreAccion.toUpperCase();
        acciones.removeIf(accion -> accion.getNombre().equals(nombre));
    }
    
    public boolean existeAccion(String nombreAccion){
        String nombre = nombreAccion.toUpperCase();
        for (Accion a : acciones) {
            if (a.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}

