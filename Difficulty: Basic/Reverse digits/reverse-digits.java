// User function Template for Java

class Solution{
    public int reverseDigits(int n){
        
        int rev=0;
        while(n>0){
            int rem=n%10;
            n/=10;
            rev=(rev*10)+rem;
        }
        
        return rev;
        
    }
}