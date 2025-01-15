import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int addDigits(int num) {
        // base case - single digit
        if (num / 10 == 0) {
            return num;
        }

        // recursive case
        int newNum = 0;
        // add all digits
        while (num != 0) {
            newNum += num % 10;
            num = num / 10;
        }
        // call addDigits again
        return addDigits(newNum);
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();

        System.out.println(playground.addDigits(38));
    }

}
