package com.strategy;

/**
 *
 * @author Janier Gomez y Harold Molano
 */
public class TarjetaDeCredito implements FormaDePago {
    private String numeroTarjeta;
    private double limite;

    public TarjetaDeCredito(String numeroTarjeta, double limite) {
        this.numeroTarjeta = numeroTarjeta;
        this.limite = limite;
    }

    @Override
    public boolean procesarPago(double monto) {
    System.out.println("Se esta procesando el pago por tarjeta de credito");
    // Lógica para procesar pagos con tarjeta de crédito
        if (verificarLimite(monto)) {
            // Realizar el pago y actualizar el límite de la tarjeta
            limite -= monto;
            return true;
        }
        return false;
    }
    
    public boolean verificarLimite(double monto){
            if (monto <= limite) {
                return true;
            }
            return false;
    }
}
