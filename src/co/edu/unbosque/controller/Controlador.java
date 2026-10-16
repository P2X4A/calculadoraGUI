package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.util.Constant;
import co.edu.unbosque.view.VentanaCalculadora;

public class Controlador implements ActionListener {

    private VentanaCalculadora vista;
    //Stringbuilder para crear y manipular Strings de manera eficiente y mutable
    private StringBuilder numerosIngresados; // Para construir número actual
    private double operando1;
    private double operando2;
    private String operacionActual; // "+", "-", "*", "/"
    private boolean esperandoSegundoOperando;

    public Controlador() {
        numerosIngresados = new StringBuilder();
        operando1 = 0;
        operando2 = 0;
        operacionActual = "";
        esperandoSegundoOperando = false;
    }

    public void ejecutar() {
        vista = new VentanaCalculadora(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.startsWith("NUMERO_")) {
            manejarNumero(comando);
        } else {
            switch (comando) {
                case Constant.OPERACION_SUMA:
                case Constant.OPERACION_RESTA:
                case Constant.OPERACION_MULTIPLICACION:
                case Constant.OPERACION_DIVISION:
                    manejarOperacion(comando);
                    break;
                case Constant.OPERACION_PUNTO:
                    manejarPunto();
                    break;
                case Constant.OPERACION_RESULTADO:
                    calcularResultado();
                    break;
                case Constant.BOTON_LIMPIAR:
                    limpiarCalculadora();
                    break;
                default:
                    // No hacer nada o agregar manejo a futuro
                    break;
            }
        }
    }

    private void manejarNumero(String comando) {
        String digito = comando.substring(7); // Extrae el número
        // Si se está esperando un segundo operando y no hay número ingresado, se limpia el lbl de resultado
        if (esperandoSegundoOperando) {
            numerosIngresados.setLength(0);
            esperandoSegundoOperando = false;
        }
        // Agregar el dígito al builder
        numerosIngresados.append(digito);
        actualizarDisplay();
    }

    private void manejarPunto() {
        if (!numerosIngresados.toString().contains(".")) {
            if (numerosIngresados.length() == 0) {
                numerosIngresados.append("0");
            }
            numerosIngresados.append(".");
            actualizarDisplay();
        }
    }

    private void manejarOperacion(String operacion) {
        try {
            if (numerosIngresados.length() > 0) {
                operando1 = Double.parseDouble(numerosIngresados.toString());
            }
        } catch (NumberFormatException ex) {
            limpiarCalculadora();
            vista.getLblResultados().setText("Error");
            return;
        }
        operacionActual = operacion;
        esperandoSegundoOperando = true;
    }

    private void calcularResultado() {
        try {
            if (numerosIngresados.length() > 0) {
                operando2 = Double.parseDouble(numerosIngresados.toString());
            } else {
                operando2 = operando1; // Para utilizar mismo operando si no se digitó nada
            }
        } catch (NumberFormatException ex) {
            limpiarCalculadora();
            vista.getLblResultados().setText("Error");
            return;
        }

        double resultado = 0;
        boolean error = false;

        switch (operacionActual) {
            case Constant.OPERACION_SUMA:
                resultado = operando1 + operando2;
                break;
            case Constant.OPERACION_RESTA:
                resultado = operando1 - operando2;
                break;
            case Constant.OPERACION_MULTIPLICACION:
                resultado = operando1 * operando2;
                break;
            case Constant.OPERACION_DIVISION:
                if (operando2 == 0) {
                    error = true;
                } else {
                    resultado = operando1 / operando2;
                }
                break;
            default:
                // Ninguna operación seleccionada
                resultado = operando2;
                break;
        }

        if (error) {
            vista.getLblResultados().setText("Error: Div/0");
        } else {
            String resStr = String.valueOf(resultado);
            // Si es entero, mostrar sin decimal
            if (resultado == (int) resultado) {
                resStr = String.valueOf((int) resultado);
            }
            vista.getLblResultados().setText(resStr);
            operando1 = resultado;
        }

        numerosIngresados.setLength(0);
        esperandoSegundoOperando = true;
    }

    private void limpiarCalculadora() {
        numerosIngresados.setLength(0);
        operando1 = 0;
        operando2 = 0;
        operacionActual = "";
        esperandoSegundoOperando = false;
        vista.getLblResultados().setText("0");
    }

    private void actualizarDisplay() {
        if (numerosIngresados.length() > 0) {
            vista.getLblResultados().setText(numerosIngresados.toString());
        } else {
            vista.getLblResultados().setText("0");
        }
    }
}
