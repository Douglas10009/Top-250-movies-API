import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

public class StickersMaker {

    public void cria() throws Exception{ //Lançar a "bomba" para outra pessoa
        //leitura da imagem
        BufferedImage imageOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //criar uma nova imagem em memória com trasnparência e tamanho novo
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200; //Deixa um espaço em transparente para escrever um texto
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0,0, null);


        //escrever uma frase na nova imagem

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saída/figurinha.png"));

    }

    public static void main(String[] args) throws Exception{
        StickersMaker geradora = new StickersMaker();
        geradora.cria();
    }
}
