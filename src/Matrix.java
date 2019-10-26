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
        gameboard = new JButton[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                gameboard[x][y] = new JButton("");
                gameboard[x][y].setBackground(Color.white);
                gameboard[x][y].addActionListener(this);
                panel.add(gameboard[x][y]);
            }
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
                            gameboard[y - 1][x].setBackground(Color.red);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            gameboard[y][x + 1].setBackground(Color.red);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            gameboard[y + 1][x].setBackground(Color.red);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                        try {
                            gameboard[y][x - 1].setBackground(Color.red);
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                    break;

                }


            }

        }

    }
}


