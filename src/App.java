import java.io.InputStream;
import java.net.URL;
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

        // String url = "https://alura-imdb-api.herokuapp.com/movies"; //Um tipo genérico de URL

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; //Um tipo genérico de URL
        var http = new ClientHttp();
        String json = http.buscaDados(url);
        
        //exibir e manipular os dados
        ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // for (Map<String,String> filme : listaDeFilmes) {

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = "saída/" + conteudo.getTitulo() + ".png";
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            StickersMaker geradora = new StickersMaker();

            geradora.cria(inputStream, nomeArquivo);

            System.out.print(ANSI_GREEN + ANSI_BOLD + "TOP " + "#" + (i+1) + ANSI_RESET );
            System.out.println();
            System.out.print(ANSI_GREEN + ANSI_BOLD + "TÍTULO: " + ANSI_RESET);
            System.out.println(conteudo.getTitulo());

            // Float class_num = Float.parseFloat(filme.get("imDbRating"));
            // if (class_num >= 8) {//Para formatar as cores da classificação
            //     System.out.print(ANSI_BLACK + ANSI_YELLOW_BACKGROUND + "CLASSIFICAÇÃO: ");
            //     System.out.println(filme.get("imDbRating")  + ANSI_RESET);
            // }

            System.out.println();
        }

    }
}

//Erros conhecidos: Algumas imagens não rodam