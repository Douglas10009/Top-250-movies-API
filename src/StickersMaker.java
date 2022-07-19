import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
//Alt + Shift + O para apagar os import não usado

public class StickersMaker {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{ //Lançar a "bomba" para outra pessoa
        //leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")); // Mais generico para que seja mais rápido a criação em massa (Ele requer que o arquivo no local)
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMGEzN2VkMmUtMGM1Zi00Y2U1LTlkMDktMTlhMTdmYzZmZDlhXkEyXkFqcGdeQXVyODEyNjEwMDk@.jpg").openStream();
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        //criar uma nova imagem em memória com trasnparência e tamanho novo
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200; //Deixa um espaço em transparente para escrever um texto
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0,0, null);

        //Configurar a fonte
        Font fonte = new Font(Font.SERIF, Font.BOLD, 100);
        graphics.setColor(Color.CYAN);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 500, novaAltura - 100); //Centralizar (Desafio)

        //escrever a nova imagem em um arquivo
        // ImageIO.write(novaImagem, "png", new File("saída/figurinha.png")); //Criar o diretório por código (Desafio)
        ImageIO.write(novaImagem, "png", new File(nomeArquivo)); //Criar o diretório por código (Desafio)

    }
}
