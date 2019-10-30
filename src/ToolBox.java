import java.util.Random;

public class ToolBox {

    public static int[] randomNumbersInGame(int[] zeroToFifteen) {
        Random random = new Random();
        for (int i = zeroToFifteen.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = zeroToFifteen[index];
            zeroToFifteen[index] = zeroToFifteen[i];
            zeroToFifteen[i] = temp;
        }
        return zeroToFifteen;
    }

}
