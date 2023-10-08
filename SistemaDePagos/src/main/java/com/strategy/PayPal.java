package com.strategy;

/**
 *
 * @author Janier Gomez y Harold Molano
 */

public class PayPal implements FormaDePago {
    private String correo;
    private String contraseña;

    public PayPal(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    @Override
    public boolean procesarPago(double monto) {
    System.out.println("Se esta procesando el pago por PayPal");        
    // Lógica para procesar pagos con PayPal
        if (autenticar()) {
            // Realizar el pago
            return true;
        }
        return false;
    }

    private boolean autenticar() {
        // Lógica de autenticación con PayPal
        return true;
    }
}
