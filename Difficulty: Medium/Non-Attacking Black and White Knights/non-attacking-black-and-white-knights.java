class Solution{
    public int numOfWays(int n, int m){
        int total=(n*m)*(n*m-1);
        int attack=(4*(n-1)*(m-2))+(4*(n-2)*(m-1));
        
        return total-attack;
        
    }
}