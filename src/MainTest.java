import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class MainTest {
    
    public static void main(String[] args) {


        int rut[][] = new int[4][4];


        int counter = 1;
        for(int i = 0; i < rut.length; i++){
            for(int j = 0; j < rut.length; j++){
                rut[i][j]=counter;
                counter++;
            }
        }


        System.out.print("   " + rut[0][0]);
        System.out.print("   " + rut[0][1]);
        System.out.print("   " + rut[0][2]);
        System.out.print("   " + rut[0][3]);


        System.out.println("\n");

        System.out.print("   " + rut[1][0]);
        System.out.print("   " + rut[1][1]);
        System.out.print("   " + rut[1][2]);
        System.out.print("   " + rut[1][3]);


        System.out.println("\n");
        System.out.print("   " + rut[2][0]);
        System.out.print("   " + rut[2][1]);
        System.out.print("   " + rut[2][2]);
        System.out.print("   " + rut[2][3]);


        System.out.println("\n");

        System.out.print("   " + rut[0][0]);
        System.out.print("   " + rut[0][1]);
        System.out.print("   " + rut[0][2]);
        System.out.print("   " + rut[0][3]);


        System.out.println("\n---------- Testar array print----------");


        Collections.shuffle(Arrays.asList(rut));

        System.out.println(Arrays.deepToString(rut));



    }


    public void animate(JComponent component, Point newPoint, int frames, int interval) {
        Rectangle compBounds = component.getBounds();

        Point oldPoint = new Point(compBounds.x, compBounds.y),
                animFrame = new Point((newPoint.x - oldPoint.x) / frames,
                        (newPoint.y - oldPoint.y) / frames);

        new Timer(interval, new ActionListener() {
            int currentFrame = 0;
            public void actionPerformed(ActionEvent e) {
                component.setBounds(oldPoint.x + (animFrame.x * currentFrame),
                        oldPoint.y + (animFrame.y * currentFrame),
                        compBounds.width,
                        compBounds.height);

                if (currentFrame != frames)
                    currentFrame++;
                else
                    ((Timer)e.getSource()).stop();
            }
        }).start();
    }

}
