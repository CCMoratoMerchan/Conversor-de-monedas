import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversor{

    Conversion consultaConversion(){
        HttpClient client = HttpClient.newHttpClient();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6aca29438ce90fef3ffb6a0d/latest/USD");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        ProcesamientoTasas procesamientoTasas = new Gson().fromJson(response.body(), ProcesamientoTasas.class);

        return new Conversion(procesamientoTasas.getConversion_rates());
    }
}
