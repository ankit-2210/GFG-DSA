class Solution{
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr){
        int n=arr.length;
        
        int level=1;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        int i=0;
        while(i<n){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0; j<level && i<n; j++){
                temp.add(arr[i++]);
            }
            
            Collections.sort(temp);
            res.add(temp);
            
            level*=2;
        }
        
        return res;
        
    }
}