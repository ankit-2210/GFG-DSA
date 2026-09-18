class Solution{
    public List<String> extractInt(String s){
        int n=s.length();
        
        List<String> res=new ArrayList<>();
        
        StringBuilder str=new StringBuilder();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            
            if(Character.isDigit(ch)){
                str.append(ch);
            }
            else{
                if(str.length()>0){
                    res.add(str.toString());
                    str.setLength(0);
                }
            }
        }
        
        if(str.length()>0){
            res.add(str.toString());
        }
        
        return res;
        
        
    }
}