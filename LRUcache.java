import java.util.HashMap;

public class LRUcache {

    public static void main(String[] args){
        lrucache cache = new lrucache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}

class lrucache{
    lruNode head;
    lruNode tail;
    HashMap<Integer, lruNode> map = null;
    int capacity;
    public lrucache(int cap){
        this.capacity = cap;
        this.map = new HashMap<>();
    }
    public int get(int key){
        if(map.get(key) == null) {
            System.out.println(-1);
            return -1;
        }
        lruNode n = map.get(key);
        removeNode(n);
        updateNode(n);
        System.out.println(n.value);
        return n.value;
    }
    private void removeNode(lruNode n){
        if(n.prev != null){
            n.prev.next = n.next;
        }else {
             head = n.next;
        }
        if(n.next != null)
            n.next.prev = n.prev;
        else
            tail = n.prev;
    }
    private void updateNode(lruNode n){
        if(tail != null)
            tail.next = n;
        n.prev = tail;
        n.next = null;
        tail = n;
        if(head == null)
            head = tail;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            lruNode n = map.get(key);
            n.value = value;
            removeNode(n);
            updateNode(n);
        }else {
            if(map.size() >= capacity){
                map.remove(head.key);
                removeNode(head);
            }
            lruNode n = new lruNode(key, value);
            updateNode(n);
            map.put(key, n);
        }
    }
}

class lruNode{
    int key;
    int value;
    lruNode prev;
    lruNode next;
    public lruNode(int k, int v){
        this.key = k;
        this.value = v;
    }
}