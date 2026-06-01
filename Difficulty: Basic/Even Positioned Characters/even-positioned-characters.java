class Solution{
    public static void utility(String s){
        int n=s.length();
        
        StringBuilder str=new StringBuilder();
        int i=0;
        while(i<n){
            str.append(s.charAt(i));
            i+=2;
        }
        
        System.out.print(str.toString());
        
        
    }
}