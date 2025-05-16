import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class World {

    //lista de blocos que estarao no mundo
    public static ArrayList<Blocks> blocos = new ArrayList<Blocks>();

    //construtor
    public World(){
        //colocando blocos nas laterais do mundo
            //linha de cima
        for(int xup = 0; xup < 1280/32; xup++){
            blocos.add(new Blocks(xup*32, 0));
        }
            //linha de baixo
        for(int xdw = 0; xdw < 1280/32; xdw++){
            blocos.add(new Blocks(xdw*32, 720-32));
        }
            //linha esquerda
        for(int ylf = 0; ylf < 720/32; ylf++){
            blocos.add(new Blocks(0, ylf*32));
        }
            //linha direita
        for(int yrg = 0; yrg < 720/32; yrg++){
            blocos.add(new Blocks(1280-32, yrg*32));
        }
    }

    //metodo de renderizar
    public void render(Graphics graphics){
        //renderizando os blocos
        for(int i = 0; i < blocos.size(); i++){
            blocos.get(i).render(graphics);
        }

    }

    //metodo para verificar colisoes
    public static boolean isFree(int x,int y){
        for(int i = 0; i < blocos.size(); i++){
            Blocks currentBlock = blocos.get(i);
            if(currentBlock.intersects(new Rectangle(x,y,32,32))){
                return false;
            }
        }
        return true;
    }
}
