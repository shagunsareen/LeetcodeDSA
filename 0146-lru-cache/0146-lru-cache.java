class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    Node head; 
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node(-1, 0);
        tail = new Node(-1, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            //since this node is accessed now its position should be changed 
            deleteNode(currNode);
            insertNodeAtLast(currNode);
            return currNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            deleteNode(map.get(key)); //existing node deleted
        }else if(map.size() == capacity){
            deleteNode(head.next); //first node deleted to make space 
        }

        Node insertNode = new Node(key, value);
        insertNodeAtLast(insertNode);
    }

    public void deleteNode(Node currNode){
        map.remove(currNode.key);
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;
    }

    public void insertNodeAtLast(Node currNode){
        map.put(currNode.key, currNode);
        tail.prev.next = currNode;
        currNode.prev = tail.prev;
        currNode.next = tail;
        tail.prev = currNode;
    }  

    //Cache is combo of hashmap and linkedlist. map is used to see which nodes are in linkedinlist in o(1)
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */