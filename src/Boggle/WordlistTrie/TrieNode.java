package Boggle.WordlistTrie;

import java.util.HashMap;

/**
 * Created by arch on 3/20/17.
 */
public class TrieNode {
    final HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
    }
}
