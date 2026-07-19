/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node deleteNode(Node head, int key){
        if(head == null)
            return null;
            
        if(head.next == head){
            if(head.data == key)
                return null;
            return head;
        }
        
        Node curr=head;
        Node prev=null;
        
        if(head.data == key){
            while(curr.next != head){
                curr=curr.next;
            }
            curr.next=head.next;
            return head.next;
        }
        
        prev=head;
        curr=head.next;
        while(curr != head){
            if(curr.data == key){
                prev.next=curr.next;
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        
        return head;
        
        
        
    }
}