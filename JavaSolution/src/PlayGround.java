import javax.swing.*;
import java.util.*;

public class PlayGround {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // try every position as starting position
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i] && travel(i, gas, cost)) {
                return i;
            }

        }

        // return -1
        return -1;
    }
    private boolean travel(int i, int[] gas, int[] cost) {
        // dest, currPos, tank
        boolean completed = false;
        int currPos = i;
        int tank = 0;
        // while 1. haven't get to dest 2. tank is not empty
        while (!completed && (tank + gas[currPos] >= cost[currPos])) {
            // travel to next place
            tank += gas[currPos] - cost[currPos];
            currPos = (currPos + 1) % gas.length;
            if (i == currPos) {
                completed = true;
            }
        }

        // return currPos == dest
        return completed && i == currPos;
    }
    public int canCompleteCircuitSlidingWindow(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        int start = 0;
        int end = 0;
        int tank = 0;
        int size = 0;

        while (start < gas.length && size < gas.length + 1) {
            while (tank < 0 & start < gas.length) {
                tank -= diff[start];
                start++;
                size--;
            }
//            if (start > end && start < gas.length) {
//                end = start;
//                tank = 0;
//                size = 0;
//            }
            while (tank >= 0 && size < gas.length + 1) {
                tank += diff[end];
                size++;
                end = (end + 1) % gas.length;
            }
        }

        return size == gas.length + 1 ? start : -1;
    }
    public int canCompleteCircuitGreedy(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }

        int total = 0;
        int curr = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            total += diff[i];
            curr += diff[i];

            if (curr < 0) {
                answer = i + 1;
                curr = 0;
            }
        }

        return total >= 0 ? answer : -1;
    }



    public static void main(String[] args) {
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        PlayGround playGround = new PlayGround();
        System.out.println(playGround.canCompleteCircuitGreedy(gas, cost));
    }
}
