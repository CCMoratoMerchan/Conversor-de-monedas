package Principal;

public class ProcesadorTasas {
    public void mostrarTodasLasTasas(Conversion conversion) {
        conversion.conversion_rates().forEach((currency, rate) ->
                System.out.println(currency + ": " + rate));
    }

    public void filtrarMonedas(Conversion conversion, String[] monedasDeseadas) {
        for (String moneda : monedasDeseadas) {
            if (conversion.conversion_rates().containsKey(moneda)) {
                System.out.println(moneda + ": " + conversion.conversion_rates().get(moneda));
            } else {
                System.out.println("La moneda " + moneda + " no está disponible.");
            }
        }
    }
}
