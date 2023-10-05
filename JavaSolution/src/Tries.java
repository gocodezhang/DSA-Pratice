import java.util.ArrayList;
import java.util.List;

public class Tries {
    TriesNode root;
    class TriesNode {
        TriesNode[] children;
        boolean isWord;

        public TriesNode() {
            this.children = new TriesNode[26];
            this.isWord = false;
        }
    }
    public Tries() {
        this.root = new TriesNode();
    }
    public void addWord(String word) {
        TriesNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            int index = currLetter - 'a';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TriesNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isWord = true;
    }
    public List<String> searchPrefix(String prefix) {
        List<String> resultList = new ArrayList<>();
        TriesNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                return resultList;
            }
            currNode = currNode.children[index];
        }
        dfsWithPrefix(currNode, prefix, resultList);

        return resultList;
    }
    private void dfsWithPrefix(TriesNode currNode, String currWord, List<String> resultList) {
        if (resultList.size() == 3) {
            return;
        }
        if (currNode.isWord) {
            resultList.add(currWord);
        }
        for (int i = 0; i < 26; i++) {
            if (currNode.children[i] != null) {
                String updateWord = currWord + (char) (i + 'a');
                dfsWithPrefix(currNode.children[i], updateWord, resultList);
            }
        }
    }
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        Tries tries = new Tries();
        for (String word : products) {
            tries.addWord(word);
        }
        String searchWord = "mouse";
        String prefix = "";
        for (int i = 0; i < searchWord.length(); i++) {
            prefix += searchWord.charAt(i);
            System.out.println(tries.searchPrefix(prefix));
        }
    }
}
