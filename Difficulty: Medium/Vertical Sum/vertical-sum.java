/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution{
    class Pair{
        Node node;
        int level;
        public Pair(Node node, int level){
            this.node=node;
            this.level=level;
        }
    }

    public ArrayList<Integer> verticalSum(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node t=p.node;
            int l=p.level;
            
            mp.put(l, mp.getOrDefault(l, 0)+t.data);
            if(t.left != null){
                q.offer(new Pair(t.left, l-1));
            }
            if(t.right != null){
                q.offer(new Pair(t.right, l+1));
            }
        }
        
        res.addAll(mp.values());
        return res;
    
        
    }
}














