class Solution{
    public int arraySum(List<Integer> arr){
        
        return arr.stream()
                .mapToInt(Integer::intValue)
                .sum();
                
            
        
        
    }
};