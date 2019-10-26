import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame implements ActionListener {
    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Välkommen till 15game");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");
    private final JPanel Grid = new JPanel();
    private static JButton[][] gameboard = new JButton[4][4];
    private int sign = 0;

    Panel() {
        p.setLayout(new BorderLayout());
        p.add(infoLabel, BorderLayout.CENTER);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        buttonpanel.add(startButton);
        buttonpanel.add(exitbutton);
        p.add(buttonpanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 100);
        add(p);
        setVisible(true);
        buttonpanel.setBackground(Color.GRAY);
        p.setBackground(Color.gray);
        startButton.setBackground(new Color(155258963));
        startButton.setForeground(Color.green);
        exitbutton.setBackground(new Color(155258963));
        exitbutton.setForeground(Color.green);
        startButton.addActionListener(this);
        exitbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            setVisible(false);
            gamePanal();

        } else if (e.getSource() == exitbutton) {
            System.exit(0);
        } else {
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (gameboard[y][x] == e.getSource()) {
                        if (sign % 2 == 0) {
                            try {
                                if (gameboard[y - 1][x].getText().equals("0")) {
                                    gameboard[y - 1][x].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("0");
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y][x + 1].getText().equals("0")) {
                                    gameboard[y][x + 1].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("0");
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y + 1][x].getText().equals("0")) {
                                    gameboard[y + 1][x].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("0");

                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y][x - 1].getText().equals("0")) {
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

    public void gamePanal() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        f.setResizable(false);
        f.add(addButtons(), BorderLayout.CENTER); //tycka in spelets panel i denna frame
        f.setSize(800, 600);
        pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel addButtons() {
        int counter = 0;
        StringBuilder isGameFinished = new StringBuilder();
        final JPanel grid = new JPanel();
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
                grid.add(gameboard[x][y]);
                grid.setLayout(new GridLayout(4, 4));
            }
        }
        gameboard[3][3].setText("0");
        //randomNumbersInGame();
        return grid;
    }

    public static void main(String[] args) {
        Panel sp = new Panel();
    }
}