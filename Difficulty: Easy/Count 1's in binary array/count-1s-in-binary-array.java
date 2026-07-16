class Solution{
    public int countOnes(int[] arr){
        int n=arr.length;
        
        int count=(int)Arrays.stream(arr)
                        .filter(x->x == 1)
                        .count();
        
        return count;
        
    }
}