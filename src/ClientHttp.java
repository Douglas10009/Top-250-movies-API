import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
//Alt+Shift + O para importar todos os pacotes nescessários

public class ClientHttp {

    String buscaDados(String url){

        try { //Trata a bomba ao invés de jogar para outro

            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();  //Poderia ser HttpClient ao invez de var
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //Poderia ser substituido por var, mas não o fez para deixar o tipo claro
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }
}
