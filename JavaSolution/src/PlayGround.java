import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int hIndex(int[] citations) {
        // create a map (array) and find #papers for the citation
        int[] papers = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            int index = Math.min(citations[i], citations.length);
            papers[index] = papers[index] + 1;
        }
        // find #paper has at least the citation
        int sum = 0;
        int[] cumPapers = new int[citations.length + 1];
        for (int i = citations.length; i >= 0; i--) {
            sum += papers[i];
            cumPapers[i] = sum;
        }

        // go through array from back
        for (int i = citations.length; i >= 0; i--) {
            if (i <= cumPapers[i]) {
                return i;
            }
        }

        return 0;

    }


    public static void main(String[] args) {
        int[] gas = {3,0,6,1,5};
        int[] cost = {1,2,2};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.hIndex(gas));
    }
}
