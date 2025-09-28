import java.util.ArrayList;
import java.util.HashMap;

public class Trees {

    static class TrieNode {
        boolean occurred;
        HashMap<Character, TrieNode> map = new HashMap<>();

    }

    public static void main(String[] args) {
        String[] inputs = {"TIE", "TRAP", "PLATE", "CAT", "PART", "PLACE"};
        TrieNode root = new TrieNode();
        for (int i = 0; i < inputs.length; i++) {
            TrieNode temp = root;
            for (int j = 0; j < inputs[i].length(); j++) {
                if (temp.map.containsKey(inputs[i].charAt(j))) {
                    temp.map.get(inputs[i].charAt(j)).occurred = true;
                } else {
                    temp.map.put(inputs[i].charAt(j), new TrieNode());
                }
                temp = temp.map.get(inputs[i].charAt(j));
            }
        }


        ArrayList<String> list = new ArrayList<>();

        System.out.println(root.map.size());


        for (int i = 0; i < inputs.length; i++) {
            StringBuilder sb = new StringBuilder();
            TrieNode temp = root;
            System.out.println(temp.map.size());
            for (int j = 0; j < inputs[i].length(); j++) {
                temp = temp.map.get(inputs[i].charAt(j));
                sb.append(inputs[i].charAt(j));
                if (!temp.occurred) {
                    break;
                }
            }
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}


