import java.sql.Time;

public class TimeNeededToRearrangeBinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int firstZero = s.indexOf('0');
        int countOnes = 0;
        int waitTime = 0;

        if (firstZero == -1) {
            return 0;
        }

        for (int i = s.length() - 1; i > firstZero; i--) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }

            if (i > 0 && s.charAt(i) == '0' && s.charAt(i - 1) == '0' && countOnes > 0) {
                waitTime++;
            }

            if (i > 0 && s.charAt(i) == '1' && s.charAt(i - 1) == '1' && waitTime > 0) {
                waitTime--;
            }

        }
        return countOnes + waitTime;
    }
    public int secondsToRemoveOccurrencesBF(String s) {
        int seconds = 0;

        while (s.indexOf("01") != -1) {
            s = s.replace("01", "10");
            seconds++;
        }
        return seconds;
    }
    public int secondsToRemoveOccurrencesOptimal(String s) {
        int zeroCounts = 0;
        int seconds = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '0') {
                zeroCounts++;
            }
            if (currChar == '1' && zeroCounts > 0) {
                seconds = Math.max(seconds + 1, zeroCounts);
            }
        }
        return seconds;
    }
    public static void main(String[] args) {
        String s= "011001";
        TimeNeededToRearrangeBinaryString timeNeededToRearrangeBinaryString = new TimeNeededToRearrangeBinaryString();
        System.out.println(timeNeededToRearrangeBinaryString.secondsToRemoveOccurrences(s));
    }
}
