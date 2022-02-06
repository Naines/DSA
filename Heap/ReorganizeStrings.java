import java.util.PriorityQueue;

public class ReorganizeStrings {

    // heap
    static void solve(String s, int n) {
        char ch[] = s.toCharArray();
        int map[] = new int[26];
        for (char c : ch)
            map[c - 'a']++;

        PriorityQueue<Key> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0)
                continue;
            pq.add(new Key((char) (i + 'a'), map[i]));
        }
        Key prev = new Key('$', -1);
        StringBuffer sb = new StringBuffer();
        while (pq.size() != 0) {
            Key temp = pq.poll(); /// remove
            sb.append(temp.ch);
            temp.freq--;
            if (prev.freq > 0)
                pq.add(prev); // add prev
            prev = temp;
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        String str = "aaabc";
        solve(str, str.length());
    }

    static class Key implements Comparable<Key> {
        char ch;
        int freq;

        Key(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Key o) {
            return o.freq - this.freq;
        }

        public String toString() {
            return this.ch + " " + this.freq;
        }
    }
}
