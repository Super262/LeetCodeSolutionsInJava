package DataStructure.Trie;

import java.util.LinkedList;
import java.util.List;

public class Problem0212 {
    public List<String> findWords(char[][] board,String[] words) {
        Trie root = buildTrie(words);
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        List<String> results = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                Trie currentNode = root.children[board[y][x] - 'a'];
                if (currentNode != null) {
                    visited[y][x] = true;
                    dfsToSearchAndPrune(currentNode,board,visited,y,x,directions,results);
                    visited[y][x] = false;
                }
            }
        }
        return results;
    }

    private Trie buildTrie(String[] words) {
        if (words == null || words.length == 0) {
            return new Trie();
        }
        Trie root = new Trie();
        for (String w : words) {
            addWord(root,w);
        }
        return root;
    }

    private void addWord(Trie root,String word) {
        if (root == null || word == null || word.isEmpty()) {
            return;
        }
        Trie currentNode = root;
        for (int i = 0; i < word.length(); ++i) {
            int chOrder = word.charAt(i) - 'a';
            if (currentNode.children[chOrder] == null) {
                currentNode.children[chOrder] = new Trie();
            }
            currentNode = currentNode.children[chOrder];
        }
        currentNode.isWord = true;
        currentNode.wordValue = word;
    }

    private boolean dfsToSearchAndPrune(Trie root,char[][] board,boolean[][] visited,int startY,int startX,int[][] directions,List<String> results) {
        if (root.isWord) {
            results.add(root.wordValue);
            root.isWord = false;  // 避免产生重复的搜索结果
            if (countNull(root.children) == root.children.length) {
                return true;
            }
        }
        for (int[] d : directions) {
            int nextY = startY + d[0];
            int nextX = startX + d[1];
            if (nextY < 0 || nextY >= board.length || nextX < 0 || nextX >= board[0].length || visited[nextY][nextX]) {
                continue;
            }
            int chOrder = board[nextY][nextX] - 'a';
            if (root.children[chOrder] == null) {
                continue;
            }
            visited[nextY][nextX] = true;
            if (dfsToSearchAndPrune(root.children[chOrder],board,visited,nextY,nextX,directions,results)) {
                root.children[chOrder] = null;
            }
            visited[nextY][nextX] = false;
        }
        return countNull(root.children) == root.children.length;
    }

    private int countNull(Trie[] children) {
        int nullCount = 0;
        for (Trie child : children) {
            if (child != null) {
                continue;
            }
            ++nullCount;
        }
        return nullCount;
    }

    private static class Trie {
        public boolean isWord;
        public Trie[] children;
        public String wordValue;

        public Trie() {
            this.isWord = false;
            this.children = new Trie[26];
            wordValue = null;
        }
    }
}
