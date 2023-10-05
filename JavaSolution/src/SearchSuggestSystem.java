import java.util.*;

public class SearchSuggestSystem {
    public static List<List<String>> suggestedProductsOriginal(String[] products, String searchWord) {
        // create currList = copy of products and sort it
        List<String> currList = new LinkedList<>(Arrays.asList(products));
        currList.sort((a, b) -> a.compareTo(b));
        // create resultList
        List<List<String>> resultList = new ArrayList<>();
        // for ( i = 1; i <= searchword.length(); i++)
        for (int i = 1; i <= searchWord.length(); i++) {
            // currPrefix = searchword.substring(0, i)
            String currPrefix = searchWord.substring(0, i);
            // updateCurrList(currList, currPredix)
            updateCurrList(currList, currPrefix);
            // add currList into resultList
            if (currList.size() > 3) {
                resultList.add(new ArrayList<>(currList.subList(0, 3)));
            } else {
                resultList.add(new ArrayList<>(currList));
            }
        }
        // return resultList
        return resultList;
    }
    public static List<List<String>> suggestedProductsBinarySearch(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> resultList = new ArrayList<>();
        int startIndex = 0;

        for (int i = 1; i < searchWord.length() + 1; i++) {
            String currPrefix = searchWord.substring(0, i);
            startIndex = updateIndices(startIndex, currPrefix, products);
            int endIndex = Math.min(startIndex + 3, products.length);
            List<String> currList = new ArrayList<>();

            for (int j = startIndex; j < endIndex; j++) {
                if (products[j].length() >= i && products[j].substring(0, i).equals(currPrefix)) {
                    currList.add(products[j]);
                }
            }
            resultList.add(currList);
        }
        return resultList;
    }
    public static int updateIndices(int startIndex, String currPrefix, String[] products) {
        int left = startIndex, right = products.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (products[mid].compareTo(currPrefix) >=0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void updateCurrList(List<String> currList, String currPrefix) {
        int prefixLength = currPrefix.length();
        Iterator<String> iterator = currList.iterator();
        while (iterator.hasNext()) {
            String currStr = iterator.next();
            if (currStr.length() < prefixLength || !currStr.substring(0, prefixLength).equals(currPrefix)) {
                iterator.remove();
            }
        }
    }
    public static void main(String[] args) {
        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";
        System.out.println(suggestedProductsBinarySearch(products, searchWord));
    }
}
