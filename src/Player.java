import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
    //Atributos
        //dimensoes do jogador
    public int altura;
    public int largura;
        //direcoes
    public boolean up, down, left, right;
        //velocidade
    public int speed = 3;
        //animacao do personagem
    public int currentAnimation = 0;
    public int curretFrames = 0;
    public int targetFrames = 15;

    //construtor
    public Player(int x, int y){
        super(x,y,32,32);
    }

    //metodo de logica
    public void tick(){
        //logica de movimentacao que verific colisoes
        boolean moving = false;
        if(right && World.isFree(x+speed, y)){
            x+=speed;
            moving = true;
        }else if (left && World.isFree(x-speed, y)) {
            x-=speed;
            moving = true;
        }
        if (up&& World.isFree(x, y-speed)) {
            y-=speed;
            moving = true;
        }else if (down && World.isFree(x, y+speed)) {
            y+=speed;
            moving = true;
        }

        
        //animacao de movimentacao
        if (moving) {
            curretFrames++;
            if(curretFrames == targetFrames){
                curretFrames = 0;
                currentAnimation++;
                if(currentAnimation == Spritesheet.player_front.length){
                    currentAnimation = 0;
                }
            }
        }
    }

    //metodo de renderizar
    public void render(Graphics graphics){
        //graphics.setColor(Color.green);
        //graphics.fillRect(x, y, width, height);
        graphics.drawImage(Spritesheet.player_front[currentAnimation], x, y,32,32, null);
    }

}
