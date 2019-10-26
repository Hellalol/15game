import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Matrix extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private static JButton[][] gameboard = new JButton[4][4];
    private int sign = 0;

    Matrix() {
        add(panel);
        addButtons(panel);
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        panel.setLayout(new GridLayout(4, 4));
    }


    private void addButtons(JPanel panel) {
        int counter = 0;
        StringBuilder isGameFinished = new StringBuilder();
        gameboard = new JButton[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                counter++;
                gameboard[x][y] = new JButton(String.valueOf(counter));
                gameboard[x][y].setFont(new Font("Arial", Font.PLAIN,40));
                gameboard[x][y].setBackground(new Color(155258963));
                gameboard[x][y].setForeground(Color.green);
                gameboard[x][y].addActionListener(this);
                isGameFinished.append(gameboard[x][y].getText());
                panel.add(gameboard[x][y]);
            }
        }
        gameboard[3][3].setText("0");
        randomNumbersInGame();

    }

    public void randomNumbersInGame(){
        Integer[] array = new Integer[]{1, 2, 3, 4};

        int[] zeroToFifteen = {0,1,3,4,5,6,7,8,9,10,11,12,13,14,15};

        for (int i = 0; i < zeroToFifteen.length ; i++) {
            zeroToFifteen[i] = i;
        }

        for (int value : zeroToFifteen) {
            System.out.print(value);
        }


    }

    public static void main(String[] args) {
        Matrix ne = new Matrix();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (gameboard[y][x] == e.getSource()) {
                    if (sign % 2 == 0) {
                        try {
                            if(gameboard[y - 1][x].getText().equals("0")){
                                gameboard[y - 1][x].setText(gameboard[y][x].getText());
                                gameboard[y][x].setText("0");
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            if(gameboard[y][x + 1].getText().equals("0")) {
                                gameboard[y][x + 1].setText(gameboard[y][x].getText());
                                gameboard[y][x].setText("0");
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            if(gameboard[y + 1][x].getText().equals("0")){
                                gameboard[y + 1][x].setText(gameboard[y][x].getText());
                                gameboard[y][x].setText("0");

                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            if(gameboard[y][x - 1].getText().equals("0")){
                                gameboard[y][x - 1].setText(gameboard[y][x].getText());
                                gameboard[y][x].setText("0");
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                    break;

                }


            }

        }

    }
}


