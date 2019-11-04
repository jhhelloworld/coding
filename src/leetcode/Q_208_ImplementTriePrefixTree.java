package leetcode;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

/**
 * jh
 * 2019年09月06日  11：02
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 总体设计思路
 *  每个节点包含 当前层出现的字母（数组） ，经过当前层的数量，以当前层结尾的数量
 *  path 表示经过当前字符的数量，end最后一层有new一个node，赋值end，注意和字符不在一层
 */
public class Q_208_ImplementTriePrefixTree {

    public class TrieNode{
        /* 经过当前节点的单词数量 */
        private int path;
        /* 以当前节点结尾的单词数量 */
        private int end;
        /* 哪些字母经过当节点 */
        private TrieNode[] map;  //26个 记录哪些字母经过当前层
        public TrieNode(){
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }

    }



    private TrieNode root;
    /** Initialize your data structure here. */
    public Q_208_ImplementTriePrefixTree() {

        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        int index = 0;

        for(char c:chars){
            index = c-'a';
            if(cur.map[index] == null){
                cur.map[index] = new TrieNode();
            }
            cur = cur.map[index];
            cur.path++;
        }
        cur.end++;



    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length()==0){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for(char c:chars){
            if(cur.map[c-'a']==null){
                return false;
            }
            cur = cur.map[c-'a'];
        }
        return cur.end!=0;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length()==0){
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for(char c:chars){
            if(cur.map[c-'a']==null){
                return false;
            }
            cur = cur.map[c-'a'];
        }
        //return cur.path!=0;  肯定不为0
        return true;

    }

}
















