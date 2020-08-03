package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作
 * @Author: YaYa
 * @Create: 2020-07-30 09:31
 */
public class 实现前缀树 {
    /**
     * 写起来方便，没别的意思。
     */
    public class Trie {
        //存放26个字母节点
        private final Trie list[] = new Trie[26];
        //标记是否到头
        private boolean isEnd = false;

        public Trie() {
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.list[ch - 'a'] == null) {
                    node.list[ch - 'a'] = new Trie();
                }
                node = node.list[ch - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                if (node.list[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                node = node.list[word.charAt(i) - 'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (node.list[ch - 'a'] == null) {
                    return false;
                }
                node = node.list[ch - 'a'];
            }
            return true;
        }
    }
}
