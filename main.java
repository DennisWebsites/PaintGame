import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main extends JPanel implements ActionListener, KeyListener {

    Timer timer = new Timer(5, this);

    int x = 175, y = 300, velX = 0, velY = 0;

    public main() {
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setRequestFocusEnabled(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Move");
        frame.setSize(400, 400);
        main main = new main();
        frame.add(main);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {

        g.setColor(new Color(189, 32, 32));
        g.fillRect(x, y, 200, 200);

        g.setColor(new Color(57, 162, 198));
        g.drawRect(x, y, 200, 200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        x = x + velX;
        y = y + velY;

        if(x < 0) {
            velX = 0;
            x = 0;
        }

        if(x > getWidth() - 200) {
            velX = 0;
            x = getWidth() - 200;
        }

        if(y < 0) {
            velY = 0;
            y = 0;
        }

        if(y > getHeight() - 200) {
            velY = 0;
            y = getHeight() - 200;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            velY = -1;
            velX = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            velY = 1;
            velX = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            velX = -1;
            velY = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            velX = 1;
            velY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velX = 0;
        velY = 0;
    }
}