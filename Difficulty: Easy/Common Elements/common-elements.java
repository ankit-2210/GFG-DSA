class Solution{
    public static ArrayList<Integer> commonElements(int a[], int b[]){
        int n=a.length;
        int m=b.length;
        
        
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int num: a){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int num: b){
            if(mp.containsKey(num) && mp.get(num)>0){
                res.add(num);
                mp.put(num, mp.get(num)-1);
            }
        }
        
        Collections.sort(res);
        return res;
        
    }
}