import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class TableTop extends JFrame {

    private Dimension sizeOfBoard = new Dimension(800,600);
    private Dimension sizeOfButton = new Dimension(50,50);
    private JPanel board = new JPanel();
    JButton button = new JButton();

   TableTop(){

       add(board);
       setSize(sizeOfBoard);
       setLocationRelativeTo(null);
       board.setBackground(Color.GRAY);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
       board.setLayout(new GridLayout(4,4));
       for (int i = 1; i < 16; i++) {
           board.add(button = new JButton());
           button.setBackground(new Color(155258963));

       }
   }

    public static void main(String[] args) {

       TableTop spel = new TableTop();
       spel.setVisible(true);
    }

    public static int[][] fillButtonsWithNumbers(){

        int[][] rut = new int[4][4];

        int counter = 1;
        for(int i = 0; i < rut.length; i++){
            for(int j = 0; j < rut.length; j++){
                rut[i][j]=counter;
                counter++;
            }
        }

        return rut;
    }
}
