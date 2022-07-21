import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMDb implements ExtratorConteudo {
    public List<Conteudo> extraiConteudos(String json){
        //extrair somente os dados que interessam (título, poster, classificação) [Parciar os dados]
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title"); //Pega a string do nome do filme
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            // String classificacao = atributos.get("key")
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo); //singular e plural para tratar a lista e os objetos
        }
        return conteudos; 

    }
}
