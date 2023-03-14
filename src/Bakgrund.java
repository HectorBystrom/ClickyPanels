import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bakgrund extends JPanel implements MouseListener {
    //Attributes
    final int SIZE = 100;
    private boolean firstColor = false;
    private boolean start = false;
    private boolean click = false;
    Window myWindow;

    //Constructor
    public Bakgrund(Window window) {
        myWindow = window;
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.green, 2));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!start) {
            this.setBackground(Color.BLACK);
        } else {
            if (!myWindow.isCross()) {
                drawCircle(g);


            } else {
                drawCross(g);
            }
            myWindow.setCross();

        }
        if (!click) {
            repaint();
        }
        if(myWindow.last == this){
            this.setBackground(Color.CYAN);
        } else{
            this.setBackground(Color.black);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("YOU HAVE CLICKED");

        firstColor = !firstColor;
        if (e.getButton() == MouseEvent.BUTTON3) {

            firstColor = true;
            start = true;
            click = true;
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            firstColor = false;
            start = true;
            click = true;
        }

       if(myWindow.last != null){
           myWindow.last.repaint();
       }
        myWindow.last = this;
        repaint();
    }

    public void drawCircle(Graphics g) {
        g.setColor(Color.magenta);

        g.drawOval(2, 3, 95, 95);

        //myWindow.setBlue();

    }

    public void drawCross(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, 100, 100);
        g.drawLine(0, 100, 100, 0);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    //Methods

    //Getters & setters
}
