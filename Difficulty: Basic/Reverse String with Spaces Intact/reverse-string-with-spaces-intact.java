class Solution{
    String reverses(String s){
        int n=s.length();
        
        StringBuilder str=new StringBuilder(s);
        int left=0, right=n-1;
        
        while(left<right){
            if(s.charAt(left) == ' '){
                left++;
            }
            else if(s.charAt(right) == ' '){
                right--;
            }
            else{
                char ch=str.charAt(left);
                str.setCharAt(left, str.charAt(right));
                str.setCharAt(right, ch);
                
                left++;
                right--;
            }
        }
        
        return str.toString();
        
        
    }
}