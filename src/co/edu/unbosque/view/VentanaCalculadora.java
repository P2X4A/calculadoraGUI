package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import co.edu.unbosque.util.Constant;

public class VentanaCalculadora extends JFrame {

    private JLabel lblResultados;

    //Botones para operaciones
    private JButton btnSumar, btnRestar, btnMultiplicacion, btnDividir, btnPunto, btnResultado, btnLimpiar;

    //Botones para numeros
    private JButton btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve;

    public VentanaCalculadora(ActionListener actionListener) {
        configurarVentana();
        inicializarComponentes(actionListener);
        organizarCalculadora();
        setVisible(true);
    }

    public void configurarVentana() {
        setTitle("Calculadora");
        setSize(350, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes(ActionListener actionListener) {
        // Inicializar pantalla resultado
        lblResultados = new JLabel("0");
        lblResultados.setFont(new Font("Arial", Font.BOLD, 30));
        lblResultados.setHorizontalAlignment(JLabel.RIGHT);
        lblResultados.setBorder(BorderFactory.createEtchedBorder());
        lblResultados.setPreferredSize(new Dimension(350, 70));

        // Botones operaciones
        btnSumar = new JButton("+");
        btnRestar = new JButton("-");
        btnMultiplicacion = new JButton("*");
        btnDividir = new JButton("/");
        btnPunto = new JButton(".");
        btnResultado = new JButton("=");
        btnLimpiar = new JButton("AC");

        // Botones dígitos
        btnCero = new JButton("0");
        btnUno = new JButton("1");
        btnDos = new JButton("2");
        btnTres = new JButton("3");
        btnCuatro = new JButton("4");
        btnCinco = new JButton("5");
        btnSeis = new JButton("6");
        btnSiete = new JButton("7");
        btnOcho = new JButton("8");
        btnNueve = new JButton("9");

        // Asignar constantes a botones de operaciones
        btnSumar.setActionCommand(Constant.OPERACION_SUMA);
        btnRestar.setActionCommand(Constant.OPERACION_RESTA);
        btnMultiplicacion.setActionCommand(Constant.OPERACION_MULTIPLICACION);
        btnDividir.setActionCommand(Constant.OPERACION_DIVISION);
        btnPunto.setActionCommand(Constant.OPERACION_PUNTO);
        btnResultado.setActionCommand(Constant.OPERACION_RESULTADO);
        btnLimpiar.setActionCommand(Constant.BOTON_LIMPIAR);

        // Asignar constantes a los dígitos
        btnCero.setActionCommand(Constant.NUMERO_0);
        btnUno.setActionCommand(Constant.NUMERO_1);
        btnDos.setActionCommand(Constant.NUMERO_2);
        btnTres.setActionCommand(Constant.NUMERO_3);
        btnCuatro.setActionCommand(Constant.NUMERO_4);
        btnCinco.setActionCommand(Constant.NUMERO_5);
        btnSeis.setActionCommand(Constant.NUMERO_6);
        btnSiete.setActionCommand(Constant.NUMERO_7);
        btnOcho.setActionCommand(Constant.NUMERO_8);
        btnNueve.setActionCommand(Constant.NUMERO_9);

        // Añadir listeners
        btnSumar.addActionListener(actionListener);
        btnRestar.addActionListener(actionListener);
        btnMultiplicacion.addActionListener(actionListener);
        btnDividir.addActionListener(actionListener);
        btnPunto.addActionListener(actionListener);
        btnResultado.addActionListener(actionListener);
        btnLimpiar.addActionListener(actionListener);

        btnCero.addActionListener(actionListener);
        btnUno.addActionListener(actionListener);
        btnDos.addActionListener(actionListener);
        btnTres.addActionListener(actionListener);
        btnCuatro.addActionListener(actionListener);
        btnCinco.addActionListener(actionListener);
        btnSeis.addActionListener(actionListener);
        btnSiete.addActionListener(actionListener);
        btnOcho.addActionListener(actionListener);
        btnNueve.addActionListener(actionListener);
    }

    private void organizarCalculadora() {
        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 8, 8));

        // Agregar botones en orden típico calculadora
        panelBotones.add(btnLimpiar);   // Clear
        panelBotones.add(new JPanel()); // Espacio vacío para cuadrícula
        panelBotones.add(new JPanel());
        panelBotones.add(btnDividir);

        panelBotones.add(btnSiete);
        panelBotones.add(btnOcho);
        panelBotones.add(btnNueve);
        panelBotones.add(btnMultiplicacion);

        panelBotones.add(btnCuatro);
        panelBotones.add(btnCinco);
        panelBotones.add(btnSeis);
        panelBotones.add(btnRestar);

        panelBotones.add(btnUno);
        panelBotones.add(btnDos);
        panelBotones.add(btnTres);
        panelBotones.add(btnSumar);

        panelBotones.add(btnCero);
        panelBotones.add(btnPunto);
        panelBotones.add(btnResultado);
        panelBotones.add(new JPanel());

        add(lblResultados, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }

    public JLabel getLblResultados() {
        return lblResultados;
    }
}
