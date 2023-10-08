/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.observadores.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author Janier Yulder Gomez Galindez
 * @author Harold Andres Molano Rosero
 */
// Modelo: Clase para representar una acción
public class Accion {
    private String nombre;
    private double precioActual;
    private double precioAnterior;
    private double umbralInferior;
    private double umbralSuperior;
    private List<Observador> observadores = new ArrayList<>();

    public Accion(String nombre, double precioInicial) {
        this.nombre = nombre;
        this.precioActual = precioInicial;
        this.precioAnterior = precioInicial;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public boolean establecerUmbrales(double umbralInferior, double umbralSuperior) {
        if(umbralInferior > this.precioActual || umbralSuperior< this.precioActual){
            return false;
        }
        this.umbralInferior = umbralInferior;
        this.umbralSuperior = umbralSuperior;
        return true;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        this.precioAnterior = this.precioActual;
        this.precioActual = nuevoPrecio;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public double getPrecioAnterior() {
        return precioAnterior;
    }

    public double getUmbralInferior() {
        return umbralInferior;
    }

    public double getUmbralSuperior() {
        return umbralSuperior;
    }
}
