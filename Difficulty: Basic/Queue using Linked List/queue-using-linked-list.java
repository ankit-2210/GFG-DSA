// Node class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Queue class
class myQueue{
    private Node front;
    private Node rear;
    int size;

    public myQueue(){
        size=0;
        front=rear=null;
        
    }

    public boolean isEmpty(){
        if(front == null)
            return true;
        return false;
    }

    public void enqueue(int x){
        Node node=new Node(x);
        if(isEmpty()){
            front=rear=node;
        }
        else{
            rear.next=node;
            rear=node;
        }
        
        size++;
    }

    public void dequeue(){
        if(isEmpty())
            return;
            
        Node temp=front;
        int rem=temp.data;
        front=front.next;
        
        if(front == null){
            rear=null;
        }
        
        size--;
    }

    public int getFront(){
        if(isEmpty())
            return -1;
        
        return front.data;
    }

    public int size(){
        return size;
        
    }
}








