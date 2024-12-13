import java.util.*;

public class RankTeamByVotes {
    public String rankTeams(String[] votes) {
        // find out votes for every team
        HashMap<Character, int[]> map = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char currTeam = vote.charAt(i);
                if (!map.containsKey(currTeam)) {
                    map.put(currTeam, new int[vote.length()]);
                }
                int[] voteByPosition = map.get(currTeam);
                voteByPosition[i] = voteByPosition[i] + 1;
            }
        }
        List<Character> teams = new ArrayList<>();
        for (char team : map.keySet()) {
            teams.add(team);
        }
        // sort based on vote
        Collections.sort(teams, (a, b) -> compareVote(a, b, map.get(a), map.get(b)));

        StringBuilder builder = new StringBuilder();
        for (char team : teams) {
            builder.append(team);
        }

        return builder.toString();
    }
    public int compareVote(char TeamA, char TeamB,  int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return -1;
            }
            if (a[i] < b[i]) {
                return 1;
            }
        }
        if (TeamA < TeamB) {
            return -1;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        String[] votes = {"ABC", "CBA", "ACB"};
        RankTeamByVotes rankTeamByVotes = new RankTeamByVotes();
        System.out.println(rankTeamByVotes.rankTeams(votes));
    }
}
