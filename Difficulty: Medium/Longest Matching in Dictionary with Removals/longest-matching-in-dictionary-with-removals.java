class Solution{
    boolean solve(String word, List<List<Integer>> pos){
    
        int prevIdx=-1;
        for(char ch: word.toCharArray()){
            List<Integer> idxs=pos.get(ch-'a');    
            
            int it=-1;
            for(int i=0; i<idxs.size(); i++){
                if(idxs.get(i)>prevIdx){
                    it=idxs.get(i);
                    break;
                }
            }
            
            if(it == -1)
                return false;
                
            prevIdx=it;
        }
        
        return true;
    }
    
    public String findLongestWord(String s, List<String> d){
        int n=s.length();
        
        List<List<Integer>> pos=new ArrayList<>();
        for(int i=0; i<26; i++){
            pos.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            pos.get(s.charAt(i)-'a').add(i);
        }
        
        String res="";
        for(String str: d){
            if(str.length()<res.length())
                continue;
            
            if(solve(str, pos)){
                if(str.length()>res.length() || (str.length() == res.length() && str.compareTo(res)<0)){
                    res=str;
                }
            }
        }
        
        return res;
        
    }
}