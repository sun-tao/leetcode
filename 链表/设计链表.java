class ListNode{
    public ListNode(){
        val = 0;
        next = null;
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;
    }

    public int val;
    public ListNode next;
}

class MyLinkedList {

    public MyLinkedList() {
        head = null;
    }
    
    private int getLength(){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public int get(int index) {
        ListNode temp = head;
        int len = getLength();
        if (index < 0 || index >= len){
            return -1;
        }
        while(index > 0){
            temp = temp.next;
            index--;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode newhead = new ListNode(val);
        newhead.next = head;
        head = newhead;
        return;
    }
    
    public void addAtTail(int val) {
        ListNode newtail = new ListNode(val);
        int len = getLength();
        ListNode temp = head;  //有可能是null
        while(len > 1){
            len--; 
            temp = temp.next;
        }
        if (temp != null){
            temp.next = newtail;
        }
        else{
            head = newtail;
        }
    }
    
    public void addAtIndex(int index, int val) {
        int len = getLength();
        if (index <= 0){
            addAtHead(val);
        }
        else if (index == len){
            addAtTail(val);
        }
        else if (index > len){
            return;
        }
        else{
            ListNode newnode = new ListNode(val);
            ListNode temp = head;
            while(index > 1){
                index--;
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
        return;
    }
    
    public void deleteAtIndex(int index) {
        int len = getLength();
        System.out.println(len);
        if (len == 0){
            return;
        }
        if (index < 0 || index >= len){
            return;
        }
        if (len == 1 && index == 0){
            head = null;
            return;
        }
        if (index == 0){ //删除头结点
            head = head.next;
            return;
        }
        ListNode temp = head;
        while(index > 1){
            index--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return;
    }   

    private ListNode head;
}