package lec32_Trie;

public class TrieClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.addWord("be");
		trie.addWord("bee");
		trie.addWord("been");
		trie.addWord("see");
		trie.addWord("sea");
		
		trie.display();
		
		trie.removeWord("be");
		trie.removeWord("been");
		trie.removeWord("see");
		
		trie.display();

	}

}
