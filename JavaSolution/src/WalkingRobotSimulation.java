import java.util.HashSet;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashSet<String> obs = new HashSet<>();

        for (int i = 0; i < obstacles.length; i++) {
            obs.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }


        int direction = 0; // 0 - up, 1 - right, 2 - down, 3 - left
        int[] currPosition = new int[]{0,0};

        double max = 0;
        // go through commands
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            // execute the curr command
            if (command < 0) {
                // 1. change direction - update direction
                direction = changeDirection(direction, command);
            } else {
                // 2. move - move one by one
                // stop if there is obstacles
                move(currPosition, direction, command, obs);
                // try update the max
                max = Math.max(max, Math.pow(currPosition[0], 2) + Math.pow(currPosition[1], 2));
            }
        }

        // return max
        return (int) max;
    }
    public int changeDirection(int direction, int command) {
        if (command == -1) {
            return (direction + 1 + 4) % 4;
        } else {
            return (direction - 1 + 4) % 4;
        }
    }
    public void move(int[] currPosition, int direction, int command, HashSet<String> obstacles) {
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int[] currDirection = directions[direction];

        for (int i = 1; i <= command; i++) {
            int nextX = currPosition[0] + currDirection[0];
            int nextY = currPosition[1] + currDirection[1];
            if (!obstacles.contains(nextX + "-" + nextY)) {
                currPosition[0] = nextX;
                currPosition[1] = nextY;
            }
        }
//        if (direction == 0) {
//            for (int i = 1; i <= command; i++) {
//                if (!obstacles.contains(currPosition[0] +  "-" + (currPosition[1] + 1))) {
//                    currPosition[1] = currPosition[1] + 1;
//                }
//            }
//        } else if (direction == 1) {
//            for (int i = 1; i <= command; i++) {
//                if (!obstacles.contains((currPosition[0] + 1) +  "-" + currPosition[1])) {
//                    currPosition[0] = currPosition[0] + 1;
//                }
//            }
//        } else if (direction == 2) {
//            for (int i = 1; i <= command; i++) {
//                if (!obstacles.contains(currPosition[0] + "-" + (currPosition[1] - 1))) {
//                    currPosition[1] = currPosition[1] - 1;
//                }
//            }
//        } else {
//            for (int i = 1; i <= command; i++) {
//                if(!obstacles.contains((currPosition[0] - 1) + "-" + currPosition[1])) {
//                    currPosition[0] = currPosition[0] - 1;
//                }
//            }
//        }
    }
    public static void main(String[] args) {
        int[] commands = {-2,8,3,7,-1};
        int[][] obs = {{5,0}};

        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        System.out.println(walkingRobotSimulation.robotSim(commands, obs));
    }
}
