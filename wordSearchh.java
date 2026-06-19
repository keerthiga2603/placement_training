import java.util.*;

public class wordSearchh {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();

        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, answer, r, c, root);
            }
        }

        return answer;
    }

    public void dfs(char[][] board, List<String> answer, int r, int c, TrieNode node) {

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) {
            answer.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#';

        if (r > 0)
            dfs(board, answer, r - 1, c, node);
        if (c > 0)
            dfs(board, answer, r, c - 1, node);
        if (r < board.length - 1)
            dfs(board, answer, r + 1, c, node);
        if (c < board[0].length - 1)
            dfs(board, answer, r, c + 1, node);

        board[r][c] = ch; // backtrack
    }

    public TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        return root;
    }

    public static void main(String[] args) {

        wordSearchh obj = new wordSearchh();

        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };

        String[] words = { "oath", "pea", "eat", "rain" };

        List<String> ans = obj.findWords(board, words);

        System.out.println("Words found: " + ans);
    }
}