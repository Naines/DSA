import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class alienDict {
    public static void main(String[] args) {
        String words[] = { "baa", "abcd", "abca", "cab", "cad" };
        Set<Character> set = new HashSet<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
        }
        int v = set.size();
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Character>());
        }

        for (int i = 0; i < v; i++) {
            char ch[] = findLetter(words[i], words[i + 1]);
            if (ch[0] == ch[1])
                continue;
            addEdge(adj, ch[0], ch[1]);
        }
        // printlist(adj);
        char order[] = topSort(adj);
        for (char a : order)
            System.out.print(a + " ");
        System.out.println();
    }

    static void printlist(ArrayList<ArrayList<Character>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print((char) (i + 97) + " ->");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static void addEdge(ArrayList<ArrayList<Character>> adj, char a, char b) {
        adj.get(a - 'a').add(b);
    }

    static char[] topSort(ArrayList<ArrayList<Character>> adj) {
        int v = adj.size();
        int inorder[] = new int[v];

        char top[] = new char[v];
        int k = 0;
        // find inorder
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inorder[adj.get(i).get(j) - 'a']++;
            }
        }

        // bfs
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inorder[i] == 0) {
                q.add(i);
                top[k++] = (char) (i + 'a');
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (char next : adj.get(curr)) {
                inorder[next - 'a']--;
                if (inorder[next - 'a'] == 0) {
                    q.add(next - 'a');
                    top[k++] = next;
                }
            }
        }
        return top;
    }

    static char[] findLetter(String a, String b) {
        int min = Math.min(a.length(), b.length());
        for (int i = 0; i < min; i++) {
            if (a.charAt(i) == b.charAt(i))
                continue;
            return new char[] { a.charAt(i), b.charAt(i) };
        }
        return new char[] { '\0', '\0' };
    }

}
