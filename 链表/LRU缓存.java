import static java.lang.System.out;
class LRUCache {
    class ListNode{
        public int key;
        public int val;
        public ListNode prev;
        public ListNode next;
        ListNode(){
            prev = null;
            next = null;
        }
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    private int capacity =0;
    private int maxCapacity;
    private Map<Integer,ListNode> cache;
    private ListNode head;  // 虚拟头结点
    private ListNode tail;  // 虚拟尾结点
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        cache = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // 利用哈希表快速查出key对应的链表结点
        ListNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node); // 移动到双向链表头部
        return node.val;
    }
    
    public void put(int key, int value) {
       ListNode node = cache.get(key);
       if (node == null){
           // 哈希表中不存在这个键值对
           ListNode newNode = new ListNode(key,value);
           addToHead(newNode);
           //哈希表中新建一个键值对
           cache.put(key,newNode);
           this.capacity++;
           if (this.capacity > this.maxCapacity){
               cache.remove(tail.prev.key,tail.prev);
               removeTail();
           }
       }
       else{
           // 哈希表中存在此键值对
           // 更新哈希表，只需要将node移动到双向链表头部即可
           node.val = value;
           cache.put(key,node);
           moveToHead(node);
       }
       return;
    }

    private void moveToHead(ListNode node){
        // 先删掉，再移动到头
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private void addToHead(ListNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeTail(){
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */