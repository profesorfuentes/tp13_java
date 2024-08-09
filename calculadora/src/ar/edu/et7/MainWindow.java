package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JTextField parametroA;
    private JTextField parametroB;
    private JTextField parametroC;
    private JTextField importeField;
    private JTextField descuentoField;
    private JButton botonCalcularSuma;
    private JButton botonCalcularDetalles;
    private JTextArea resultado;
    private Calculos calc;

    public MainWindow() {
        // Configuración de la ventana principal
        setTitle("Calculadora de Suma y Detalles");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        // Crear los componentes para la suma
//        parametroA = new JTextField(10);
//        parametroB = new JTextField(10);
//        parametroC = new JTextField(10);
//        botonCalcularSuma = new JButton("Calcular Suma");

        // Crear los componentes para el cálculo de descuento, IVA e Ingresos Brutos
        importeField = new JTextField(10);
        descuentoField = new JTextField(10);
        botonCalcularDetalles = new JButton("Calcular Detalles");

        // Crear el área de texto para mostrar resultados
        resultado = new JTextArea(5, 30);
        resultado.setEditable(false);

        // Instanciar la clase de cálculos
        this.calc = new Calculos();

        // Panel para los inputs de suma
//        JPanel panelInputsSuma = new JPanel();
//        panelInputsSuma.setLayout(new GridLayout(4, 2));
//        panelInputsSuma.add(new JLabel("Parámetro A:"));
//        panelInputsSuma.add(parametroA);
//        panelInputsSuma.add(new JLabel("Parámetro B:"));
//        panelInputsSuma.add(parametroB);
//        panelInputsSuma.add(new JLabel("Parámetro C:"));
//        panelInputsSuma.add(parametroC);
//        panelInputsSuma.add(new JLabel(""));  // Placeholder
//        panelInputsSuma.add(botonCalcularSuma);

        // Panel para los inputs de detalles
        JPanel panelInputsDetalles = new JPanel();
        panelInputsDetalles.setLayout(new GridLayout(3, 2));
        panelInputsDetalles.add(new JLabel("Importe:"));
        panelInputsDetalles.add(importeField);
        panelInputsDetalles.add(new JLabel("Descuento (%):"));
        panelInputsDetalles.add(descuentoField);
        panelInputsDetalles.add(new JLabel(""));  // Placeholder
        panelInputsDetalles.add(botonCalcularDetalles);

        // Panel para el resultado
        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(new BorderLayout());
        panelResultado.add(new JLabel("Resultado:"), BorderLayout.NORTH);
        panelResultado.add(new JScrollPane(resultado), BorderLayout.CENTER);

        // Agregar los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        //getContentPane().add(panelInputsSuma, BorderLayout.NORTH);
        getContentPane().add(panelInputsDetalles, BorderLayout.CENTER);
        getContentPane().add(panelResultado, BorderLayout.SOUTH);

        // Configurar la acción del botón de suma
//        botonCalcularSuma.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                calcularSuma();
//            }
//        });

        // Configurar la acción del botón de detalles
        botonCalcularDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDetalles();
            }
        });
    }

    private void calcularSuma() {
        try {
            // Obtener los valores de los campos de texto
            int a = Integer.parseInt(parametroA.getText());
            int b = Integer.parseInt(parametroB.getText());
            int c = Integer.parseInt(parametroC.getText());

            // Calcular
            int suma = calc.sumar(a, b, c);

            // Mostrar el resultado en el área de texto
            resultado.setText("Resultado: " + suma);
        } catch (NumberFormatException ex) {
            // Manejar el caso en que los inputs no sean números válidos
            resultado.setText("Por favor, ingrese números válidos.");
        }
    }

    private void calcularDetalles() {
        try {
            // Obtener los valores de los campos de texto
            float importe = Float.parseFloat(importeField.getText());
            float descuentoPorcentaje = Float.parseFloat(descuentoField.getText());

            // Calcular detalles
            String detalles = calc.calcularDetalles(importe, descuentoPorcentaje);

            // Mostrar el resultado en el área de texto
            resultado.setText(detalles);
        } catch (NumberFormatException ex) {
            // Manejar el caso en que los inputs no sean números válidos
            resultado.setText("Por favor, ingrese números válidos.");
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
