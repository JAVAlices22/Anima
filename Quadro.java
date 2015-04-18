import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

 public class Quadro extends JPanel implements KeyListener {
    // posiçao x,y do canto esquerdo superior da imagem
    private int x1, x2, x3, x4;
    private int y1, y2, y3;
    Random gerador = new Random();
    
    // tamanho do quadro
    private int maxHeight,maxWidth;
    // tamanho da imagem
    private int widthImage = 21;
    private int heightImage = 21;

    Image img;
    Image img1;
    Image img3;
    public Quadro() {
        x1 = 0;
        y1 = 0;
        x2 = 100;
        y2 = 100;
        x3 = gerador.nextInt(100);
        y3 = gerador.nextInt(100);
        x4 = -60;
        img = Toolkit.getDefaultToolkit().getImage("c:\\temp\\alvo.jpg"); 
        img1 = Toolkit.getDefaultToolkit().getImage("c:\\temp\\alvo.jpg");
        img3 = Toolkit.getDefaultToolkit().getImage("c:\\temp\\alvo.jpg");
        setFocusable(true);
        requestFocusInWindow();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, x1,y1,this);
        g.drawImage(img1, x2, y2, this);
        g.drawImage(img3, x3, y3, this);
        g.drawString("Marcel cabaço",x4, 350);
    }
    //Isto aqui a gente não vai usar. Isto aqui é para mexer o alvo...
    public void keyPressed(KeyEvent ke){
        //System.out.println(ke.getKeyCode()+"--"+ke.getKeyChar());
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:
                if (this.y1 > 0) {
                    this.y1 --;
                    repaint();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.y1 < this.maxHeight) {
                    this.y1 ++;
                    repaint();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (this.x1 > 0) {
                    this.x1 --;
                    repaint();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.x1 < this.maxWidth) {
                    this.x1 ++;
                    repaint();
                }
                break;
        }
    }
    //determina os movimentos do alvo
    public void move(){
        for( int i=0; i<=100; i++){
            this.x1++;
            this.x2++;
            this.x4++;
            repaint();  
            try {
                Thread.sleep(15);                 
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        x3 = gerador.nextInt(300);
        y3 = gerador.nextInt(300);
        for (int  i = 0; i <= 200; i++) {
            this.y1++;
            this.x2--;
            this.x4++;
            
            repaint();          
            try {
                Thread.sleep(15);                
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        x3 = gerador.nextInt(300);
        y3 = gerador.nextInt(300);
        for( int i=0; i<=50; i++){
            this.x1--;
            this.y2++;
            this.x4++;
            repaint();  
            try {
                Thread.sleep(15);                 
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        x3 = gerador.nextInt(300);
        y3 = gerador.nextInt(300);
         for (int  i = 0; i <= 100; i++) {
            this.y1--;
            this.y2--;
            this.x4++;
            repaint();          
            try {
                Thread.sleep(15);                
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        x3 = gerador.nextInt(300);
        y3 = gerador.nextInt(300);
    }
    public void keyReleased(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){}
    public void init() throws InterruptedException{
        addKeyListener(this);
        /** O tamanho do JPanel è inferior aquela do JFrame porque no setSize
        * comprende as bordas.
        */
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Dimension dimParentFrame = parent.getContentPane().getSize();
        /**
        * Precisa fixar um limitar o espaço se nao a imagem va sair da o  quadro
        *
        */
        maxHeight = (int) dimParentFrame.getHeight() - heightImage;
        maxWidth = (int) dimParentFrame.getWidth() - widthImage;

        }
}

    
 