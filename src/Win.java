import java.util.Arrays;
import java.util.Random;

public class Win {
    static int[] zeroToFifteen = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static String[][] gamebord = {{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"8", "9", "10", "11"}, {"12", "13", "14", "15"}}; //ignore test array to see if logic works

    public static void main(String[] args) {
        didWeWin();
    }

    public static boolean didWeWin() {
        String g = "";
        String gb = "";
            for (int i = 0; i < gamebord.length; i++) {
                for (int j =0; j< gamebord[i].length; j++) {
                    g += gamebord[i][j];
                    }
                }
            for (int i = 0; i < zeroToFifteen.length; i++){
                gb += zeroToFifteen[i];
            }if(g.equalsIgnoreCase(gb)){
                return true;
            }else{
                return false;
            }
    }

        // TODO: 2019-10-27 " if (didWeWin()) {
        //            JOptionPane.showMessageDialog(null, "Winner Winner Chicken Dinner");
        //        } " sätt in denna som en variabel i actionperformed och lek lite med det


    public void randomNumbersInGame() {
        System.out.println(Arrays.toString(zeroToFifteen));
        Random random = new Random();
        for (int i = zeroToFifteen.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int a = zeroToFifteen[index];
            zeroToFifteen[index] = zeroToFifteen[i];
            zeroToFifteen[i] = a;
        }
        System.out.println(Arrays.toString(zeroToFifteen));
    }
}
