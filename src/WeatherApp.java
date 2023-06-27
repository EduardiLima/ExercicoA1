import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    public static void main(String[] args) {
        try {
            String location = "Sao Paulo"; // Localização para a qual você deseja obter a previsão do tempo
            
            // Monta a URL da API de previsão do tempo
            String apiUrl = "https://api.hgbrasil.com/weather?format=json&woeid=455827";
            
            // Faz a requisição HTTP para a API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Lê a resposta da API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Imprime a resposta (no caso, o JSON da previsão do tempo)
            System.out.println("Previsão do tempo para " + location + ":");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}