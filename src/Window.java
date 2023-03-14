import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //Attributes
    private boolean cross=true;
    Bakgrund last;
    int size = 3;
    //Constructor
    public Window(){
        this.setTitle("A clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a layout
        JPanel multiPanel = new JPanel();
        GridLayout layout = new GridLayout(size,size);
        multiPanel.setLayout(layout);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.green, 5));

        for(int i = 0; i<size*size; i++){
            multiPanel.add(new Bakgrund(this));
        }


        this.getContentPane().add(multiPanel);

        this.pack();
        this.setVisible(true);
    }
    //Methods

    //Getters & setters

    public boolean isCross() {
        return cross;
    }

    public void setCross() {
        this.cross = !this.cross;
    }
}
