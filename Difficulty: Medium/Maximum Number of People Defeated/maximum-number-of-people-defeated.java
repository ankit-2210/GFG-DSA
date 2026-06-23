class Solution{
    int maxPeopleDefeated(int p){
    
        long res=0;
        long low=0, high=10000;
        while(low<=high){
            long mid=low+(high-low)/2;
            long sum=mid*(mid+1)*(2*mid+1)/6;
                
            if(sum <= p){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return (int)res;
        
    }
};



// O(nlogn)

// 1^2 + 2^2 + 3^2 + .... n^2 <= p
// (n*(n+1)*(2n+1))/6 <= p


