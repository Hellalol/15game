import javax.swing.*;
import java.awt.*;

public class TableTop extends JFrame {

    private Dimension sizeOfBoard = new Dimension(800,600);
    private Dimension sizeOfButton = new Dimension(50,50);
    private JPanel board = new JPanel();
    JButton button = new JButton();



   TableTop(){

       add(board);
       setSize(sizeOfBoard);
       setLocationRelativeTo(null);
       board.setLayout(new GridLayout(2,2));
       for (int i = 1; i < 16; i++) {
           board.add(button = new JButton());
       }


   }




    public static void main(String[] args) {

       TableTop spel = new TableTop();
       spel.setVisible(true);
    }

}
