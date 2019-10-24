import javax.swing.*;
import java.awt.*;

public class WinnerWinnerChickenDinner extends JFrame {

    private final JPanel p = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private final JLabel titelLabel = new JLabel("15game");
    private final JLabel infoLabel = new JLabel("Välkommen till 15game"+"\n"+"Produced by FreWil"+"\u00A9");
    private final JButton startButton = new JButton("Starta");
    private final JButton exitbutton = new JButton("Avsluta");

    WinnerWinnerChickenDinner() {

        p.setLayout(new BorderLayout());
        p.add(infoLabel, BorderLayout.CENTER);
        p.add(titelLabel, BorderLayout.NORTH);
        buttonpanel.add(startButton);
        buttonpanel.add(exitbutton);
        p.add(buttonpanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        add(p);
        p.setVisible(true);

    }

    public static void main(String[] args) {
        WinnerWinnerChickenDinner wwcd = new WinnerWinnerChickenDinner();

    }
}
