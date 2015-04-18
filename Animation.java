
import javax.swing.JFrame;

public class Animation extends JFrame{
    private int width = 400;
    private int height = 400;
    Quadro qd;

    public Animation(){
        setSize(width,height);
        qd = new Quadro();
        add(qd);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Animaçao");
    }

    public void init() throws InterruptedException{
       qd.init();
       qd.move();
    }

    public static void main(String[] args) throws InterruptedException {
       Animation a = new Animation();
       a.init();
    }
}