import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Panel extends JFrame implements ActionListener {
    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JPanel headPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private final JPanel DPanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Välkommen till 15game");
    private final JLabel theme = new JLabel("                Tema:");
    private final JLabel headLabel = new JLabel();
    private String title = "Fifteen Puzzle ::: Produced by FreWil\u00A9";
    private final JLabel inc = new JLabel("\u00A9");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");
    private final JButton shuffleButton = new JButton("Blanda om");
    private final ButtonGroup dGroup = new ButtonGroup();
    private final JRadioButton difficultyEasy = new JRadioButton("3x3");
    private final JRadioButton difficultyMedium = new JRadioButton("4x4");
    private final JRadioButton difficultyHard = new JRadioButton("5x5");
    private String[] themeChoices = {"Default", "Joker", "Dark", "Basic", "BlåOrange", "Soviet", "Rålit"};
    private final JComboBox<String> dropDown = new JComboBox<>(themeChoices);
    private static int xyCord = 4;
    private static JButton[][] gameboard = new JButton[xyCord][xyCord];
    private int[] zeroToFifteen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};
    private final int[] zeroToNine = {1, 2, 3, 4, 5, 6, 7, 0 , 8};
    private final int[] zeroToTwentyFour =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 24};
    private int randomColorNumber1 = (int) (Math.random() * 999999999);
    private int randomColorNumber2 = (int) (Math.random() * 999999999);
    private Color randomColor1 = new Color(randomColorNumber1);
    private Color randomColor2 = new Color(randomColorNumber2);
    private Color buttonColor;
    private Color numberColor;


    Panel() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(p);
        p.setBackground(Color.white);
        p.setLayout(new BorderLayout());
        p.add(infoLabel, BorderLayout.NORTH);
        p.add(DPanel, BorderLayout.WEST);
        DPanel.setLayout(new GridBagLayout());
        difficultyEasy.setBackground(Color.white);
        difficultyMedium.setBackground(Color.white);
        difficultyHard.setBackground(Color.white);
        dGroup.add(difficultyEasy);
        dGroup.add(difficultyMedium);
        dGroup.add(difficultyHard);
        DPanel.add(difficultyEasy);
        DPanel.add(difficultyMedium);
        DPanel.add(difficultyHard);
        p.add(buttonpanel, BorderLayout.SOUTH);
        buttonpanel.setLayout(new GridLayout());
        buttonpanel.add(startButton);
        buttonpanel.add(exitbutton);
        buttonpanel.add(theme);
        buttonpanel.add(dropDown);
        buttonpanel.setOpaque(true);
        dropDown.setBackground(Color.white);
        buttonpanel.setBackground(Color.white);
        buttonpanel.updateUI();
        startButton.addActionListener(this);
        exitbutton.addActionListener(this);
        shuffleButton.addActionListener(this);
        setVisible(true);
        pack();
        difficultyEasy.addActionListener(e -> {
            xyCord = 3;
            zeroToFifteen = zeroToNine;
            headLabel.setText("8GAME");
            infoLabel.setText("Välkommen till 8game");
            setTitle("Eight Puzzle ::: Produced by FreWil\u00A9");

        });
        difficultyMedium.addActionListener(e -> {
            xyCord = 4;
            headLabel.setText("15GAME");
            infoLabel.setText("Välkommen till 15game");
            setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
        });
        difficultyHard.addActionListener(e -> {
            xyCord = 5;
            zeroToFifteen = zeroToTwentyFour;
            headLabel.setText("24GAME");
            infoLabel.setText("Välkommen till 24game");
            setTitle("Twentyfour Puzzle ::: Produced by FreWil\u00A9");
        });
        dropDown.addActionListener(e -> {
            String selectedItem = (String) dropDown.getSelectedItem();
            assert selectedItem != null;
            switch (selectedItem) {
                case "Default":
                    startButton.setBackground(new JButton().getBackground());
                    startButton.setForeground(new JButton().getForeground());
                    exitbutton.setBackground(new JButton().getBackground());
                    exitbutton.setForeground(new JButton().getForeground());
                    shuffleButton.setBackground(new JButton().getBackground());
                    shuffleButton.setForeground(new JButton().getForeground());
                    bottomPanel.setBackground(new JButton().getBackground());
                    headPanel.setBackground(new JButton().getForeground());
                    break;

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
            backroundMusic(true);
            gamePanal();
        } else if (e.getSource() == exitbutton) {
            System.exit(0);
        } else if (e.getSource() == shuffleButton) {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
            gamePanal();

        } else {
            for (int y = 0; y < xyCord; y++) {
                for (int x = 0; x < xyCord; x++) {
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
                                if (g.length() == 8 || g.length() == 21|| g.length() == 39)  {
                                    winConditionCounter++;
                                }
                                if (g.length() == 8 && winConditionCounter == 1||
                                        g.length() == 21 && winConditionCounter == 1||
                                        g.length() == 39 && winConditionCounter == 3) {
                                    if (didWeWin(g)) {
                                        dispose();
                                        backroundMusic(false);
                                        victory();
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
        inc.setForeground(numberColor);
        headLabel.setForeground(numberColor);
        headPanel.add(headLabel);
        headPanel.add(inc);
        bottomPanel.add(shuffleButton);
        bottomPanel.add(exitbutton);
        f.add(headPanel, BorderLayout.NORTH);
        f.add(bottomPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle(title);
        f.setResizable(false);
        f.add(addButtons(), BorderLayout.CENTER);
        f.setSize(800, 800);
        pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel addButtons() {
        JPanel grid = new JPanel();
        int counter = 0;
        randomNumbersInGame(zeroToFifteen);
        gameboard = new JButton[xyCord][xyCord];
        for (int y = 0; y < xyCord; y++) {
            for (int x = 0; x < xyCord; x++) {
                counter++;
                gameboard[x][y] = new JButton(String.valueOf(zeroToFifteen[counter - 1]));
                gameboard[x][y].setFont(new Font("Arial", Font.PLAIN, 50));
                gameboard[x][y].setBackground(buttonColor);
                gameboard[x][y].setForeground(numberColor);
                gameboard[x][y].setBorder(new LineBorder(Color.black, Font.BOLD));
                gameboard[x][y].addActionListener(this);
                grid.add(gameboard[x][y]);
                grid.setLayout(new GridLayout(xyCord, xyCord));
                if (gameboard[x][y].getText().equalsIgnoreCase("0")) {
                    gameboard[x][y].setText("");
                }
            }
        }
        return grid;
    }

    public int[] randomNumbersInGame(int[] zeroToFifteen) {
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
        String easySolved = "14725836";
        String mediumSolved = "159132610143711154812";
        String hardSolved = "161116212712172238131823491419245101520";
        if (checkIfSolved.equalsIgnoreCase(easySolved)||
                checkIfSolved.equalsIgnoreCase(mediumSolved)||
                checkIfSolved.equalsIgnoreCase(hardSolved)) {
            return true;
        } else {
            return false;
        }
    }

    public void backroundMusic(boolean play){
        File musicPath1 = new File("C:/Users/wilhe/Desktop/Memefest/TSFH.wav");
        File musicPath2 = new File("C:/Users/wilhe/Desktop/Memefest/MegaMan2.wav");
        File musicPath3 = new File("C:/Users/wilhe/Desktop/Memefest/victorywav.wav");
        try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath2);
        Clip clip = AudioSystem.getClip();
        if (play) {
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }else {
            clip.drain();
            clip.close();
        }
        }catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void victory() {
        File gifpath = new File("C:/Users/wilhe/Desktop/Memefest/victorygif.gif");
        Icon icon = new ImageIcon(String.valueOf(gifpath));
        JLabel label = new JLabel(icon);
        JFrame f = new JFrame();
        f.getContentPane().add(label);
        f.setTitle("Congratulations, Now Quit Slacking And Go Back To Work!");
        f.setResizable(false);
        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) throws LineUnavailableException {
        Panel sp = new Panel();
    }
}