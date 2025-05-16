import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

    //buffers de imagem
    public static BufferedImage spritesheet;
    public static BufferedImage[] player_front;
    public static BufferedImage tile_wall;

    //construtor
    public Spritesheet(){
        //carregando a imagem do spritesheet
        try {
            spritesheet = ImageIO.read(getClass().getResource("res/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sprites do jogador
        player_front = new BufferedImage[2];
        player_front[0] = getSprite(0, 11, 16, 16);
        player_front[1] = getSprite(16, 11, 16, 16);

        //sprites parede
        tile_wall = getSprite(280, 221, 16, 16);
    }

    //metodo para pegar sprites
    public static BufferedImage getSprite(int x,int y,int width,int height){
        return spritesheet.getSubimage(x, y, width, height);
    }
}
