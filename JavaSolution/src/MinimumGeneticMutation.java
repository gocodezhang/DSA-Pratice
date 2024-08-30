import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] possible = new char[]{'A','C','G','T'};
        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(startGene, 0));
        seen.add(startGene);

        while (!queue.isEmpty()) {
            Pair<String, Integer> currPair = queue.poll();
            String currMutation = currPair.getKey();
            int currNum = currPair.getValue();
            if (currMutation.equals(endGene)) {
                return currNum;
            }
            StringBuilder builder = new StringBuilder(currMutation);
            for (int i = 0; i < currMutation.length(); i++) {
                for (int j = 0; j < possible.length; j++) {
                    if (currMutation.charAt(i) == possible[j]) {
                        continue;
                    }
                    builder.setCharAt(i, possible[j]);
                    String possibleMutation = builder.toString();
                    if (!seen.contains(possibleMutation) && bankSet.contains(possibleMutation)) {
                        queue.add(new Pair<>(possibleMutation, currNum + 1));
                        seen.add(possibleMutation);
                    }

                }
                builder.setCharAt(i, currMutation.charAt(i));
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        System.out.println(minimumGeneticMutation.minMutation(startGene, endGene, bank));
    }

}
