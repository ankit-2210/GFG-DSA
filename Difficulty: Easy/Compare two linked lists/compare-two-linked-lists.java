/*  Structure of Node
class Node
 {
    char data;
    Node next;

    // Constructor to create a new node
    Node(char d)
    {
       data = d;
       next = null;
    }
 }*/

class Solution{
    int compare(Node head1, Node head2){
        
        Node a=head1;
        Node b=head2;
        
        while(a != null && b != null){
            if(a.data > b.data)
                return 1;
            else if(a.data < b.data)
                return -1;
                
            a=a.next;
            b=b.next;
        }
        
        if(a == null && b == null)
            return 0;
            
        if(a == null)
            return -1;
            
        return 1;
        
        
    }
}




























