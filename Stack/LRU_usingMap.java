import java.util.LinkedHashMap;
import java.util.Map;

public class LRU_usingMap {
    static class LRUCache {

    LinkedHashMap<Integer, Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map=new LinkedHashMap<>();
        this.cap=capacity;
    }
    
    public int get(int key) {
        // System.out.println("get="+key);
        // System.out.println(map);
        if(map.containsKey(key)){
            int val=map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // System.out.println("put="+key+" "+value);
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
        }
        else if(map.size()==cap){
            int temkey=-1;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                // System.out.println("key ="+entry.getKey());
                temkey=entry.getKey();
                break;
            }
            map.remove(temkey);
        }
        // else if(map.size() == cap) map.remove(map.entrySet().iterator().next().getKey());
        map.put(key, value);
        // System.out.println(map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
