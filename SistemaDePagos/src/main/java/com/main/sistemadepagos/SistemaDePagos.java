package com.main.sistemadepagos;

import com.strategy.FormaDePago;
import com.strategy.PayPal;
import com.strategy.TarjetaDeCredito;
import com.strategy.TransferenciaBancaria;
import java.util.Scanner;

/**
 *
 * @author Janier Gomez y Harold Molano
 */
public class SistemaDePagos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monto = 100000.0; // Monto a pagar

        System.out.println("Seleccione el medio de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. PayPal");
        System.out.println("3. Transferencia Bancaria");

        int opcion = scanner.nextInt();

        FormaDePago formaDePago = null;

        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese el número de tarjeta de crédito:");
                String numeroTarjeta = scanner.next();
                System.out.println("Ingrese el límite de la tarjeta de crédito:");
                double limiteTarjeta = scanner.nextDouble();
                formaDePago = new TarjetaDeCredito(numeroTarjeta, limiteTarjeta);
            }
            case 2 -> {
                System.out.println("Ingrese su correo electrónico de PayPal:");
                String correoPayPal = scanner.next();
                System.out.println("Ingrese su contraseña de PayPal:");
                String contraseñaPayPal = scanner.next();
                formaDePago = new PayPal(correoPayPal, contraseñaPayPal);
            }
            case 3 -> {
                System.out.println("Ingrese el nombre del propietairio de la"
                        + " cuenta bancaria:");
                String nombrePropietario = scanner.next();
                System.out.println("Ingrese el número de cuenta bancaria:");
                String numeroCuenta = scanner.next();
                formaDePago = new TransferenciaBancaria(nombrePropietario, numeroCuenta);
            }
            default -> System.out.println("Opción no válida");
        }

        if (formaDePago != null && formaDePago.procesarPago(monto)) {
            System.out.println("Pago exitoso.");
        } else {
            System.out.println("Pago fallido.");
        }
    }
}
