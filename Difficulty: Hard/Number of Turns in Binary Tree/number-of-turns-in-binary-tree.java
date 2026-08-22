/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution{
    int count(StringBuilder str){
        int c=0;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) != str.charAt(i-1))
                c++;
        }
        
        return c;
    }
    
    boolean findPath(Node root, int val, StringBuilder str){
        if(root == null)
            return false;
            
        if(root.data == val)
            return true;
            
        str.append('L');
        if(findPath(root.left, val, str))
            return true;
            
        str.deleteCharAt(str.length()-1);
        
        str.append('R');
        if(findPath(root.right, val, str))
            return true;
        
        str.deleteCharAt(str.length()-1);
        
        return false;
    }
    
    
    public int numberOfTurns(Node root, int p, int q){
        
        StringBuilder pathP=new StringBuilder();
        StringBuilder pathQ=new StringBuilder();
        
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        
        int i=0;
        while(i<pathP.length() && i<pathQ.length() && pathP.charAt(i) == pathQ.charAt(i)){
            i++;
        }
        
        StringBuilder pPath = new StringBuilder(pathP.substring(i));
        StringBuilder qPath = new StringBuilder(pathQ.substring(i));
        
        int res=count(pPath)+count(qPath);
        if(pPath.length()>0 && qPath.length()>0)
            res++;
            
        if(res == 0)
            return -1;
        
        return res;
    }
}




























