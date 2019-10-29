import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Panel extends JFrame implements ActionListener {


    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Välkommen till 15game");
    private final JLabel theme = new JLabel("Tema:");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");
    private final JPanel headPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private final JLabel headLabel = new JLabel("15GAME");
    private final JLabel inc = new JLabel("\u00A9");
    private final JButton shuffleButton = new JButton("Blanda om");
    private String[] themeChoices = {"Default", "Joker", "Dark", "Basic", "BlåOrange", "Soviet", "Rålit"};
    private final JComboBox<String> dropDown = new JComboBox<>(themeChoices);
    private static JButton[][] gameboard = new JButton[4][4];
    private final String solved = "159132610143711154812";
    private final int[] zeroToFifteen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private final int[] almostsolved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};
    private int randomColorNumber1 = (int) (Math.random() * 999999999);
    private int randomColorNumber2 = (int) (Math.random() * 999999999);
    private Color randomColor1 = new Color(randomColorNumber1);
    private Color randomColor2 = new Color(randomColorNumber2);
    private Color buttonColor;
    private Color numberColor;

    Panel() {
        p.setLayout(new BorderLayout());
        p.add(infoLabel, BorderLayout.NORTH);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonpanel.setLayout(new GridLayout());
        buttonpanel.add(startButton);
        buttonpanel.add(exitbutton);
        buttonpanel.add(theme);
        buttonpanel.add(dropDown);
        p.add(buttonpanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        add(p);
        setVisible(true);
        buttonpanel.setBackground(Color.white);
        p.setBackground(Color.white);
        startButton.setBackground(new Color(155258963));
        startButton.setForeground(Color.green);
        exitbutton.setBackground(new Color(155258963));
        exitbutton.setForeground(Color.green);
        shuffleButton.setBackground(new Color(155258963));
        shuffleButton.setForeground(Color.green);
        startButton.addActionListener(this);
        exitbutton.addActionListener(this);
        shuffleButton.addActionListener(this);
        pack();

        dropDown.addActionListener(e -> {
            String selectedItem = (String) dropDown.getSelectedItem();
            assert selectedItem != null;
            switch (selectedItem) {
                case "Joker":
                    startButton.setBackground(new Color(155258963));
                    startButton.setForeground(Color.green);
                    exitbutton.setBackground(new Color(155258963));
                    exitbutton.setForeground(Color.green);
                    shuffleButton.setBackground(new Color(155258963));
                    shuffleButton.setForeground(Color.green);
                    bottomPanel.setBackground(new Color(155258963));
                    headPanel.setBackground(new Color(155258963));
                    buttonColor = new Color(155258963);
                    numberColor = Color.green;
                    break;
                case "Dark":
                    startButton.setBackground(Color.darkGray);
                    startButton.setForeground(Color.black);
                    exitbutton.setBackground(Color.darkGray);
                    exitbutton.setForeground(Color.black);
                    shuffleButton.setBackground(Color.darkGray);
                    shuffleButton.setForeground(Color.black);
                    bottomPanel.setBackground(Color.darkGray);
                    headPanel.setBackground(Color.darkGray);
                    buttonColor = Color.darkGray;
                    numberColor = Color.black;
                    break;
                case "Basic":
                    startButton.setBackground(Color.white);
                    startButton.setForeground(Color.black);
                    exitbutton.setBackground(Color.white);
                    exitbutton.setForeground(Color.black);
                    shuffleButton.setBackground(Color.white);
                    shuffleButton.setForeground(Color.black);
                    bottomPanel.setBackground(Color.white);
                    headPanel.setBackground(Color.white);
                    buttonColor = Color.white;
                    numberColor = Color.black;
                    break;
                case "BlåOrange":
                    startButton.setBackground(Color.orange);
                    startButton.setForeground(Color.blue);
                    exitbutton.setBackground(Color.orange);
                    exitbutton.setForeground(Color.blue);
                    shuffleButton.setBackground(Color.orange);
                    shuffleButton.setForeground(Color.blue);
                    bottomPanel.setBackground(Color.orange);
                    headPanel.setBackground(Color.orange);
                    buttonColor = Color.orange;
                    numberColor = Color.blue;
                    break;
                case "Soviet":
                    startButton.setBackground(Color.red);
                    startButton.setForeground(Color.yellow);
                    exitbutton.setBackground(Color.red);
                    exitbutton.setForeground(Color.yellow);
                    shuffleButton.setBackground(Color.red);
                    shuffleButton.setForeground(Color.yellow);
                    bottomPanel.setBackground(Color.red);
                    headPanel.setBackground(Color.red);
                    buttonColor = Color.red;
                    numberColor = Color.yellow;
                    break;
                case "Rålit":
                    startButton.setBackground(randomColor1);
                    startButton.setForeground(randomColor2);
                    exitbutton.setBackground(randomColor1);
                    exitbutton.setForeground(randomColor2);
                    shuffleButton.setBackground(randomColor1);
                    shuffleButton.setForeground(randomColor2);
                    bottomPanel.setBackground(randomColor2);
                    bottomPanel.setForeground(randomColor2);
                    headPanel.setBackground(randomColor2);
                    buttonColor = randomColor1;
                    numberColor = randomColor2;
                    break;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            dispose();
            music();
            gamePanal();
        } else if (e.getSource() == exitbutton) {
            System.exit(0);
        } else if (e.getSource() == shuffleButton) {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
            gamePanal();

        } else {
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (gameboard[y][x] == e.getSource()) {
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
                        String g = "";
                        int winConditionCounter = 0;
                        for (int i = 0; i < gameboard.length; i++) {
                            for (int j = 0; j < gameboard[i].length; j++) {
                                g += gameboard[i][j].getText();
                                if(g.length() == 21){
                                    winConditionCounter++;
                                }
                                if (g.length() == 21 && winConditionCounter == 1) {
                                    if (didWeWin(g)) {
                                        dispose();
                                        JOptionPane.showMessageDialog(null, "WINNER WINNER " +
                                                "CHICKEN DINNER!\nCongratulations, You Did Your Job. Do You Want a " +
                                                "Cookie?\nNow Back To Your Real Job!");
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
        f.setUndecorated(true);
        //f.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG); //välja egen borderfärgtema
        headLabel.setFont(new Font("Arial", Font.BOLD, 60));
        inc.setFont(new Font("Arial", Font.BOLD, 20));
        inc.setForeground(Color.black);
        headPanel.add(headLabel);
        headPanel.add(inc);
        bottomPanel.add(shuffleButton);
        bottomPanel.add(exitbutton);
        f.add(headPanel, BorderLayout.NORTH);
        f.add(bottomPanel, BorderLayout.SOUTH);
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
                gameboard[x][y] = new JButton(String.valueOf(almostsolved[counter - 1]));
                gameboard[x][y].setFont(new Font("Arial", Font.PLAIN, 40));
                gameboard[x][y].setBackground(buttonColor);
                gameboard[x][y].setForeground(numberColor);
                gameboard[x][y].addActionListener(this);
                grid.add(gameboard[x][y]);
                grid.setLayout(new GridLayout(4, 4));
                if (gameboard[x][y].getText().equalsIgnoreCase("0")) {
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
        if (checkIfSolved.equalsIgnoreCase(solved)) {
            return true;
        } else {
            return false;
        }
    }

    public void music() {
        File musicPath1 = new File("C:/Users/wilhe/Desktop/Memefest/TSFH.wav");
        File musicPath2 = new File("C:/Users/wilhe/Desktop/Memefest/MegaMan2.wav");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath2);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws LineUnavailableException {
        Panel sp = new Panel();
    }
}