import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    //Facilitar o processo para colorir terminal
    public static final String ANSI_RESET = "\u001B[0m"; //Delimitar o ansi
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    
    public static void main(String[] args) throws Exception {
        //fazer uma conexão HTTP (Protocolo para se comunicar na Web) e buscar os top 25o filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies"; //Um tipo genérico de URL
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();  //Poderia ser HttpClient ao invez de var
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //Poderia ser substituido por var, mas não o fez para deixar o tipo claro
        String body = response.body();
        // System.out.println(body);
        
        //extrair somente os dados que interessam (título, poster, classificação) [Parciar os dados]
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size()); //Tamanho da lista
        // System.out.println(listaDeFilmes.get(0));
        

        //exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.print(ANSI_GREEN + ANSI_BOLD + "TÍTULO: " + ANSI_RESET);
            System.out.println(filme.get("title"));
            System.out.print(ANSI_GREEN + "IMAGEM: " + ANSI_RESET);
            System.out.println(filme.get("image"));

            Float class_num = Float.parseFloat(filme.get("imDbRating"));
            if (class_num >= 8) {
                System.out.print(ANSI_BLACK + ANSI_YELLOW_BACKGROUND + "CLASSIFICAÇÃO: ");
                System.out.println(filme.get("imDbRating")  + ANSI_RESET);
            }

            System.out.println();
        }

    }
}
