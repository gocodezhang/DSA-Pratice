import java.util.*;

public class AnalyzeUserPatternWebs {
    public List<String> mostVisitedPatterns(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        // sort the events
        Integer[] events = new Integer[n];
        for (int i = 0; i < n; i++) {
            events[i] = i;
        }
        Arrays.sort(events, (a, b) -> (timestamp[a] - timestamp[b]));
        // process events and store website visit order for each user
        Map<String, List<String>> userWebMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int eventIndex = events[i];
            String user = username[eventIndex];
            String web = website[eventIndex];
            if (!userWebMap.containsKey(user)) {
                userWebMap.put(user, new ArrayList<>());
            }
            List<String> webs = userWebMap.get(user);
            webs.add(web);
        }
        // go through each user and analyze pattern
        Map<String, Integer> patterns = new HashMap<>();
        for (String user : userWebMap.keySet()) {
            List<String> webs = userWebMap.get(user);
            countPattern(webs, patterns);
        }
        // return most
        String mostVisitedPattern = "";
        int max = 0;
        for (String pattern : patterns.keySet()) {
            int count = patterns.get(pattern);
            if (max < count || (max == count && mostVisitedPattern.compareTo(pattern) > 0)) {
                max = count;
                mostVisitedPattern = pattern;
            }
        }

        if (mostVisitedPattern.length() == 0) {
            return null;
        } else {
            return Arrays.asList(mostVisitedPattern.split(","));
        }

    }
    public void countPattern(List<String> webs, Map<String, Integer> patterns) {
        HashSet<String> visitedPatterns = new HashSet<>();
        for (int i = 0; i < webs.size(); i++) {
            for (int j = i + 1; j < webs.size(); j++) {
                for (int k = j + 1; k < webs.size(); k++) {
                    String pattern = webs.get(i) + "," + webs.get(j) + "," + webs.get(k);
                    if (!visitedPatterns.contains(pattern)) {
                        int count = patterns.getOrDefault(pattern, 0);
                        patterns.put(pattern, count + 1);
                        visitedPatterns.add(pattern);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] username = {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
        int[] timestamp = {436363475,710406388,386655081,797150921};
        String[] website = {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
        AnalyzeUserPatternWebs aw = new AnalyzeUserPatternWebs();
        System.out.println(aw.mostVisitedPatterns(username, timestamp, website));
    }
}
