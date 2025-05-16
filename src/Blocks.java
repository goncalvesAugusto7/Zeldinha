import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle{

    //construtor
    public Blocks(int x, int y){
        super(x,y,32,32);
    }

    //metodo de renderizar
    public void render(Graphics graphics){
        graphics.drawImage(Spritesheet.tile_wall, x, y,32,32, null);  

    }

}
