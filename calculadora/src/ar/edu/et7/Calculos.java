package ar.edu.et7;

public class Calculos {

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
    
    // Función para calcular descuento, IVA e Ingresos Brutos
    public String calcularDetalles(float importe, float descuentoPorcentaje) {
        // Calcular descuento en pesos
        float descuento = importe * (descuentoPorcentaje / 100);
        // Calcular importe después del descuento
        float importeDescontado = importe - descuento;
        // Calcular IVA (21%)
        float iva = importeDescontado * 0.21f;
        // Calcular Ingresos Brutos (3%)
        float ingresosBrutos = importeDescontado * 0.03f;

        // Construir el resultado como un String
        return String.format(
            "Descuento: %.2f pesos\nIVA (21%%): %.2f pesos\nIngresos Brutos (3%%): %.2f pesos",
            descuento, iva, ingresosBrutos
        );
    }
}
