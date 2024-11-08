package org.example;

public class ConversionData {
    private String base_code;
    private String target_code;
    private float conversion_rate;
    private float conversion_result;

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public void setConversion_rate(float conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public float getConversion_rate() {
        return conversion_rate;
    }

    public float getConversion_result() {
        return conversion_result;
    }

    // Método toString para facilitar a exibição do resultado
    @Override
    public String toString() {
        return "Moeda Base: " + base_code + "\n" +
                "Moeda de Destino: " + target_code + "\n" +
                "Taxa de Conversão: " + conversion_rate + "\n" +
                "Resultado da Conversão: " + conversion_result;
    }
}
