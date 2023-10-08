package com.strategy;

/**
 *
 * @author Janier Gomez y Harold Molano
 */
public class TransferenciaBancaria implements FormaDePago {
    private String nombrePropietario;
    private String numeroCuenta;

    public TransferenciaBancaria(String nombrePropietario, String numeroCuenta) {
        this.nombrePropietario = nombrePropietario;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Se esta procesando el pago por transferencia bancaria");
        // Lógica para procesar pagos con transferencia bancaria
        // Realizar la transferencia y validar la información de la cuenta
        return true;
    }
}
