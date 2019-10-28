import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JFrame implements ActionListener {

    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Välkommen till 15game");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");
    private static JButton[][] gameboard = new JButton[4][4];
    private int sign = 0;
    private final String solved = "159132610143711154812";
    private final int[] zeroToFifteen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private final int[] almostsolved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};

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
            dispose();
            gamePanal();

        } else if (e.getSource() == exitbutton) {
            System.exit(0);
        }else {
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (gameboard[y][x] == e.getSource()) {
                        if (sign % 2 == 0) {
                            try {
                                if (gameboard[y - 1][x].getText().equals("")) {
                                    gameboard[y - 1][x].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("");
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y][x + 1].getText().equals("")) {
                                    gameboard[y][x + 1].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("");
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y + 1][x].getText().equals("")) {
                                    gameboard[y + 1][x].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("");

                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            try {
                                if (gameboard[y][x - 1].getText().equals("")) {
                                    gameboard[y][x - 1].setText(gameboard[y][x].getText());
                                    gameboard[y][x].setText("");
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                        String g = "";
                        for (int i = 0; i < gameboard.length; i++) {
                            for (int j =0; j< gameboard[i].length; j++) {
                                g += gameboard[i][j].getText();
                                if(g.length()==21) {
                                    if (didWeWin(g)){
                                        dispose();
                                        JOptionPane.showMessageDialog(null, "WINNER WINNER CHICKEN DINNER!");
                                        //todo write all winconditions, example mp4 player and so on
                                    }
                                }
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
        //f.setUndecorated(true); //måste ha egna exitknappar för att funkar
        //f.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG); //välja egen borderfärgtema
        JPanel headPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JLabel headLabel = new JLabel("15GAME");
        JLabel inc = new JLabel("\u00A9");
        headLabel.setFont(new Font("Arial", Font.BOLD, 60));
        inc.setFont(new Font("Arial", Font.BOLD, 20));
        headPanel.setBackground(Color.gray);
        headLabel.setForeground(Color.black);
        inc.setForeground(Color.black);
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        f.add(headPanel,BorderLayout.NORTH);
        f.add(bottomPanel,BorderLayout.SOUTH);
        headPanel.add(headLabel);
        headPanel.add(inc);
        bottomPanel.add(b1);
        bottomPanel.add(b2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        f.setResizable(false);
        f.add(addButtons(), BorderLayout.CENTER);
        f.setSize(800, 600);
        pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel addButtons() {
        JPanel grid = new JPanel();
        int counter = 0;
        //int[] randomNumbersInGame = randomNumbersInGame();
        gameboard = new JButton[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                counter++;
                //gameboard[x][y] = new JButton(String.valueOf(randomNumbersInGame[counter - 1]));
                gameboard[x][y] = new JButton(String.valueOf(almostsolved[counter-1]));
                gameboard[x][y].setFont(new Font("Arial", Font.PLAIN, 40));
                gameboard[x][y].setBackground(new Color(155258963));
                gameboard[x][y].setForeground(Color.green);
                gameboard[x][y].addActionListener(this);
                grid.add(gameboard[x][y]);
                grid.setLayout(new GridLayout(4, 4));
                if(gameboard[x][y].getText().equalsIgnoreCase("0")){
                    gameboard[x][y].setText("");
                }
            }
        }
        return grid;
    }

    public int[] randomNumbersInGame() {
        Random random = new Random();
        for (int i = zeroToFifteen.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = zeroToFifteen[index];
            zeroToFifteen[index] = zeroToFifteen[i];
            zeroToFifteen[i] = temp;
        }
        return zeroToFifteen;
    }


    public boolean didWeWin(String checkIfSolved) {
        if(checkIfSolved.equalsIgnoreCase(solved)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Panel sp = new Panel();
    }
}