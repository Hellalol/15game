import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame implements ActionListener {
    private final JFrame f = new JFrame("15game :|:|: Produced by FreWil\u00A9");
    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Välkommen till 15game");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");

    Panel() {
        f.add(p);
        f.setTitle("15game :|:|: Produced by FreWil\u00A9");
        p.setLayout(new BorderLayout());
        p.add(infoLabel, BorderLayout.CENTER);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonpanel.add(startButton);
        buttonpanel.add(exitbutton);
        p.add(buttonpanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380,100);
        add(p);
        setVisible(true);
        buttonpanel.setBackground(Color.GRAY);
        f.setBackground(Color.GRAY);
        p.setBackground(Color.GRAY);
        startButton.setBackground(Color.GRAY);
        exitbutton.setBackground(Color.GRAY);

        startButton.addActionListener(this);
        exitbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            gamePanal();
            setVisible(false);

        } else if (e.getSource() == exitbutton) {
            System.exit(0);
        }
    }

    public void gamePanal(){
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Fifteen Puzzle ::: Produced by FreWil\u00A9");
            f.setResizable(false);
            f.add(new Matrix(), BorderLayout.CENTER); //tycka in spelets panel i denna frame
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }


    public static void main(String[] args) {
        Panel sp = new Panel();
    }
}
