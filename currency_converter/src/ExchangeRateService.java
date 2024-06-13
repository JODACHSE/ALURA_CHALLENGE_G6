import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRateService {
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String apiKey, String fromCurrency, String toCurrency) {
        String url = API_BASE_URL + apiKey + "/latest/" + fromCurrency;
        URI direccion = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la API: " + response.statusCode());
            }
            // System.out.println("Respuesta de la API: " + response.body());
            return parseExchangeRate(response.body(), toCurrency);
        } catch (Exception e) {
            throw new RuntimeException("No se puede realizar la conversión.", e);
        }
    }

    private double parseExchangeRate(String responseBody, String toCurrency) {
        JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        if (!conversionRates.has(toCurrency)) {
            throw new RuntimeException("Divisa destino no encontrada: " + toCurrency);
        }
        return conversionRates.get(toCurrency).getAsDouble();
    }
}
