class LRUCache {

    HashMap<Integer, Node> map;
    int limit;

    Node head; // required when we need to delete node from first if map is full 
    Node tail;

    class Node{
        int key;
        int data;
        Node next;
        Node prev; //since its double linked list we need prev node also

        Node(int key, int val){
            this.key = key;
            this.data = val;
        }
    }


    public LRUCache(int capacity) {
        head = new Node(-1,0);
        tail = new Node(-1,0);

        head.next = tail;
        tail.prev = head;
       
        map = new HashMap<>();
        this.limit = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            //delete mode and insert at the end
            Node currNode = map.get(key);
            deleteNode(currNode);
            insertNodeAtLast(currNode);
            return currNode.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
        }else{
            //check if the map size is full , if it is full then delete first node
            if(map.size() == limit){
                deleteNode(head.next);
            }
        }

        Node node = new Node(key, value);
        insertNodeAtLast(node);
    }

    private void deleteNode(Node node){ //we always delete node from the front 
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeAtLast(Node node){ //we always insert node at the end of doubly linked list
        map.put(node.key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */