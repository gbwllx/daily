package book.lru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description:
 * author: gubing.gb
 * date: 2017/3/22.
 */
public class LRUWithLinkedHashMap<K, V> {
    private static final float hashTableFactor = 0.75f;

    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRUWithLinkedHashMap(int cacheSize) {
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int) Math.ceil(cacheSize / hashTableFactor) + 1;
        map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableFactor, true) {
            private static final long serialVersionUID = 1;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUWithLinkedHashMap.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedEntries() {
        return map.size();
    }

    public synchronized Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(map.entrySet());
    }

    public static void main(String[] args) {
        LRUWithLinkedHashMap<String, String> c = new LRUWithLinkedHashMap<>(3);
        c.put("1", "one");                           // 1
        c.put("2", "two");                           // 2 1
        c.put("3", "three");                         // 3 2 1
        c.put("4", "four");                          // 4 3 2
        if (c.get("2") == null) throw new Error();    // 2 4 3
        c.put("5", "five");                          // 5 2 4
        c.put("4", "second four");                   // 4 5 2
        // Verify cache content.
        if (c.usedEntries() != 3) throw new Error();
        if (!c.get("4").equals("second four")) throw new Error();
        if (!c.get("5").equals("five")) throw new Error();
        if (!c.get("2").equals("two")) throw new Error();
        // List cache content.
        for (Map.Entry<String, String> e : c.getAll())
            System.out.println(e.getKey() + " : " + e.getValue());
    }
}

