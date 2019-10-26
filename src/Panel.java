import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

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
        setSize(400,100);
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
        }else{
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

    public void gamePanal(){

            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
            f.setResizable(false);
            f.add(addButtons(), BorderLayout.CENTER); //tycka in spelets panel i denna frame
            f.setSize(800,600);
            pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
    }

    private JPanel addButtons() {
        final JPanel grid = new JPanel();
        gameboard = new JButton[4][4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                gameboard[x][y] = new JButton("");
                gameboard[x][y].setBackground(new Color(155258963));
                gameboard[x][y].addActionListener(this);
                grid.add(gameboard[x][y]);
                grid.setLayout(new GridLayout(4, 4));
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        Panel sp = new Panel();
    }
}