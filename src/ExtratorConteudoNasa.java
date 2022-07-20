import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa {
    public List<Conteudo> extraiConteudos(String json){
        //extrair somente os dados que interessam (título, poster, classificação) [Parciar os dados]
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>(); 

    }
}
