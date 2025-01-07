package Principal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaConversor conversion = new ConsultaConversor();
        Conversion intentoConversion = conversion.consultaConversion();
        int opcion = 0;
        double tasaDeUsd = conversion.consultaConversion().conversion_rates().get("USD");
        double tasaDeCop = conversion.consultaConversion().conversion_rates().get("COP");
        double tasaDeMxn = conversion.consultaConversion().conversion_rates().get("MXN");
        String menu = """
                
                ** Bienvenido/a al conversor de monedas, ¿qué moneda quieres convertir hoy?**
                1 - COP >>>> USD
                2 - USD >>>> COP
                3 - MXN >>>> USD
                4 - USD >>>> MXN
                5 - MXN >>>> COP
                6 - COP >>>> MXN
                9 - Salir
                ** Selecciona una opción válida **""";
        Scanner teclado = new Scanner(System.in);

        while (opcion != 9) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Cuál es el valor en COP que quieres convertir a USD?");
                    double valorAConvertir1 = teclado.nextDouble();
                    double valor1 = valorAConvertir1 * (tasaDeUsd/tasaDeCop);
                    BigDecimal valorConvertidoCopAUsd = new BigDecimal(valor1);
                    valorConvertidoCopAUsd = valorConvertidoCopAUsd.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir1 + "COP es equivalente a "
                            + valorConvertidoCopAUsd + "USD");
                    break;
                case 2:
                    System.out.println("Cuál es el valor en USD que quieres convertir a COP?");
                    double valorAConvertir2 = teclado.nextDouble();
                    double valor2 = valorAConvertir2 * (tasaDeCop/tasaDeUsd);
                    BigDecimal valorConvertidoUsdACop = new BigDecimal(valor2);
                    valorConvertidoUsdACop = valorConvertidoUsdACop.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir2 + "USD es equivalente a "
                            + valorConvertidoUsdACop + "COP");
                    break;
                case 3:
                    System.out.println("Cuál es el valor en MXN que quieres convertir a USD?");
                    double valorAConvertir3 = teclado.nextDouble();
                    double valor3 = valorAConvertir3 * (tasaDeUsd/tasaDeMxn);
                    BigDecimal valorConvertidoMxnAUsd = new BigDecimal(valor3);
                    valorConvertidoMxnAUsd = valorConvertidoMxnAUsd.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir3 + "MXN es equivalente a "
                            + valorConvertidoMxnAUsd + "USD");
                    break;
                case 4:
                    System.out.println("Cuál es el valor en USD que quieres convertir a MXN?");
                    double valorAConvertir4 = teclado.nextDouble();
                    double valor4 = valorAConvertir4 * (tasaDeMxn/tasaDeUsd);
                    BigDecimal valorConvertidoUsdAMxn = new BigDecimal(valor4);
                    valorConvertidoUsdAMxn = valorConvertidoUsdAMxn.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir4 + "USD es equivalente a "
                            + valorConvertidoUsdAMxn + "MXN");
                    break;
                case 5:
                    System.out.println("Cuál es el valor en MXN que quieres convertir a COP?");
                    double valorAConvertir5 = teclado.nextDouble();
                    double valor5 = valorAConvertir5 * (tasaDeCop/tasaDeMxn);
                    BigDecimal valorConvertidoMxnACop = new BigDecimal(valor5);
                    valorConvertidoMxnACop = valorConvertidoMxnACop.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir5 + "MXN es equivalente a "
                            + valorConvertidoMxnACop + "COP");
                    break;
                case 6:
                    System.out.println("Cuál es el valor en COP que quieres convertir a MXN?");
                    double valorAConvertir6 = teclado.nextDouble();
                    double valor6 = valorAConvertir6 * (tasaDeMxn/tasaDeCop);
                    BigDecimal valorConvertidoCopAMxn = new BigDecimal(valor6);
                    valorConvertidoCopAMxn = valorConvertidoCopAMxn.setScale(2, RoundingMode.HALF_UP);
                    System.out.println("El valor "+ valorAConvertir6 + "COP es equivalente a "
                            + valorConvertidoCopAMxn + "MXN");
                    break;
                case 9:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }


        }
    }
}