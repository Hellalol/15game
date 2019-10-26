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
        }
    }

    public void gamePanal(){

            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
            f.setResizable(false);
            f.add(new Matrix(), BorderLayout.CENTER); //tycka in spelets panel i denna frame
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);

    }


    public static void main(String[] args) {
        Panel sp = new Panel();
    }
}
