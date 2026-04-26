class Solution{
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c){
        int n=a.length;
        int m=b.length;
        int l=c.length;
        
        ArrayList<Integer> res=new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<n && j<m && k<l){
            if(a[i] == b[j] && b[j] == c[k]){
                if(res.isEmpty() || (!res.isEmpty() && res.get(res.size()-1) != a[i])){
                    res.add(a[i]);
                }
                i++;
                j++;
                k++;
            }
            else if(a[i]<=b[j] && b[j]<=c[k]){
                i++;
            }
            else if(a[i]>=b[j] && b[j]<=c[k]){
                j++;
            }
            else{
                k++;
            }
        }
        
        return res;
        
    }
}