package Leetcode.Trie;

public class LongestCommonSuffixQueries {
    class Solution {

        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            int idx = -1;
        }

        TrieNode root = new TrieNode();
        String[] words;

        private int better(int oldIdx, int newIdx) {

            if (oldIdx == -1) return newIdx;

            int oldLen = words[oldIdx].length();
            int newLen = words[newIdx].length();

            if (newLen < oldLen) return newIdx;

            if (newLen == oldLen && newIdx < oldIdx) return newIdx;

            return oldIdx;
        }

        private void insert(String word, int index) {

            TrieNode node = root;

            node.idx = better(node.idx, index);

            for (int i = word.length() - 1; i >= 0; i--) {

                char ch = word.charAt(i);
                int c = ch - 'a';

                if (node.child[c] == null) {
                    node.child[c] = new TrieNode();
                }

                node = node.child[c];

                node.idx = better(node.idx, index);
            }
        }

        private int search(String query) {

            TrieNode node = root;

            for (int i = query.length() - 1; i >= 0; i--) {

                char ch = query.charAt(i);
                int c = ch - 'a';

                if (node.child[c] == null) {
                    break;
                }

                node = node.child[c];
            }

            return node.idx;
        }

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

            words = wordsContainer;

            for (int i = 0; i < wordsContainer.length; i++) {
                insert(wordsContainer[i], i);
            }

            int[] ans = new int[wordsQuery.length];

            for (int i = 0; i < wordsQuery.length; i++) {
                ans[i] = search(wordsQuery[i]);
            }

            return ans;
        }
    }
}
