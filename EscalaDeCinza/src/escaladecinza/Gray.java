
package escaladecinza;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author willi
 */
public class Gray {

    BufferedImage imagem;
    BufferedImage imagemFinal;
    int altura = 0;
    int largura = 0;

    public Gray() throws IOException {
        imagem = ImageIO.read(new File("image.jpg"));
        largura = imagem.getWidth();
        altura = imagem.getHeight();
        this.imagemFinal = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
    }

    public double Gray(Color c) {
        int R = c.getRed();
        int G = c.getGreen();
        int B = c.getBlue();

        return ((R + G + B) / 3);
    }

    public void toGray() throws IOException {
        for (int i = 0; i < largura - 1; i++) {
            for (int j = 0; j < altura - 1 ; j++) {
                Color temp = new Color(imagem.getRGB(i, j));
                Color aux = new Color((int)Gray(temp),(int)Gray(temp),(int)Gray(temp));
                imagemFinal.setRGB(i, j, aux.getRGB());
               

            }

        }
        

        ImageIO.write(imagemFinal, "jpg", new File("NovaImagem.jpg"));
        System.out.println("Imagem processada");
    }

}
