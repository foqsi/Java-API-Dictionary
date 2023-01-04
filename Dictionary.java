import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Dictionary {
    public abstract String ask(String word);

    public String meaning(String word) {
        String prefix = "\"definition\":\"";
        String clip = "";
        String url = "https://api.dictionaryapi.dev/api/v2/entries/en/";
        url = url + word;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            clip = response.body();
            clip = clip.substring(clip.indexOf(prefix) + prefix.length());
            clip = clip.substring(0, clip.indexOf("\",\""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clip;
    }
}
