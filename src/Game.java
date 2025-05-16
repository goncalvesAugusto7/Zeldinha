import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
    //Dimensões
    public static int width = 1280;
    public static int height = 720;
    public static int scale = 3;
    //Jogador
    public Player player;
    //Mundo
    public World world;

    //construtor
    public Game(){
        //criando key listenner
        this.addKeyListener(this);

        //setando dimensões da janela
        this.setPreferredSize(new Dimension(width, height));

        //setando spritesheet
        new Spritesheet();

        //criando jogador
        this.player = new Player(32,32);

        //criando mundo
        this.world = new World();


    }

    //metodo de logica do jogo
    public void tick(){
        //chamando logica do jogador
        this.player.tick();
    }

    //metodo de renderização
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();

        //setando fundo preto
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, width, height);

        //renderizando jogador
        this.player.render(graphics);
        //renderizando mundo
        this.world.render(graphics);


        bs.show();

    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game);
        frame.setTitle("Joguinho");
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread(game).start();

    }

    public void run(){
        while (true) {
            tick();
            render();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //metodos de teclado
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //movimentacao do jogador
            //direita e esquerda
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true; 
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true; 
        }
            //cima e baixo
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true; 
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true; 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //movimentacao do jogador
            //direita e esquerda
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.right = false; 
            }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.left = false; 
            }
                //cima e baixo
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                player.up = false; 
            }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.down = false; 
            }
    }


}
