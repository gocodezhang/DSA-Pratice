import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build a graph based on equations and values
        HashMap<String, List<Pair<String, Double>>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            List<Pair<String, Double>> adjList = graph.getOrDefault(equation.get(0), new ArrayList<>());
            adjList.add(new Pair(equation.get(1), value));
            graph.put(equation.get(0), adjList);
            List<Pair<String, Double>> adjList2 = graph.getOrDefault(equation.get(1), new ArrayList<>());
            adjList2.add(new Pair(equation.get(0), 1 / value));
            graph.put(equation.get(1), adjList2);
        }
        double[] results = new double[queries.size()];
        // go through each query
        for (int i = 0; i < queries.size(); i++) {
            // calculate the value for query
            List<String> currQuery = queries.get(i);
            Set<String> visited = new HashSet<>();
            // add value
            results[i] = computeQuery(currQuery, graph, visited);
        }
        // return result
        return results;
    };
    public double computeQuery(List<String> query, HashMap<String, List<Pair<String, Double>>> graph, Set<String> visited) {
        String origin = query.get(0);
        String target = query.get(1);
        if (!graph.containsKey(origin) || !graph.containsKey(target)) {
            return -1;
        }
        if (origin.equals(target)) {
            return 1;
        }
        double result = -1;
        List<Pair<String, Double>> options = graph.get(origin);
        for (Pair<String, Double> option: options) {
            if (visited.contains(option.getKey())) {
                continue;
            }
            visited.add(option.getKey());
            double temp = option.getValue() * computeQuery(List.of(option.getKey(), target), graph, visited);
            if (temp > 0) {
                result = temp;
            }
            visited.remove(option.getKey());
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> equation1 = List.of("a", "b");
        List<String> equation2 = List.of("b", "c");
        List<List<String>> equations = new ArrayList<>();
        equations.add(equation1);
        equations.add(equation2);
        double[] values = {2, 3};
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = List.of("a", "b");
        List<String> query2 = List.of("b", "a");
        List<String> query3 = List.of("a", "c");
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);

        EvaluateDivision evaluateDivision = new EvaluateDivision();
        System.out.println(evaluateDivision.calcEquation(equations, values, queries));

    }

}
