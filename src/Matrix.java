import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Matrix extends JFrame implements ActionListener {

        JPanel panel = new JPanel();
        JButton button;
        private static JButton[][] gameboard = new JButton[4][4];
        private int sign = 0;


        Matrix() {
            add(panel);
            addButtons(panel);
            setVisible(true);
            setSize(800, 600);
            setLocationRelativeTo(null);
            panel.setLayout(new GridLayout(4, 4));
            int buttonCount = 0;
            String buttonID;
            buttonID = Integer.toString(++buttonCount);


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

            Adventure test = new Adventure();

            gameboard[3][3].setBackground(Color.black);

            int r = 3;
            int c = 2;


        /*try {
            System.out.println(gameboard[r - 1][c]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("utanför norr");
        }

        try {
            System.out.println(gameboard[r][c + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("utanför öst");
        }

        try {
            System.out.println(gameboard[r + 1][c]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("utanför söder");
        }

        try {
            System.out.println(gameboard[r][c - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("utanför väst");
        }
    }*/

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

}
