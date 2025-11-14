import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnector {

    //
    // !!! IMPORTANTE: Substitua "SUA_API_KEY_AQUI" pela sua chave pessoal !!!
    //
    private static final String API_KEY = "256fef6a7a6b96d4558bbecf";
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getConversionRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {

        // Monta a URL para a requisição de "par de moedas"
        String urlString = API_BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;

        // 1. Cria o Cliente HTTP (Java 11+)
        HttpClient client = HttpClient.newHttpClient();

        // 2. Cria a Requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        // 3. Envia a requisição e obtém a resposta como String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica se a requisição foi bem-sucedida
        if (response.statusCode() != 200) {
            throw new IOException("Falha na requisição: Código " + response.statusCode());
        }

        // 4. Usa Gson para "parsear" o JSON
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

        if (!"success".equals(apiResponse.result())) {
            throw new IOException("A API retornou um erro (verifique as moedas ou a chave).");
        }

        // 5. Retorna a taxa de conversão
        return apiResponse.conversionRate();
    }
}