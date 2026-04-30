class Solution{
    public:
    bool isMaxHeap(vector<int> &arr){
        int n=arr.size();
        
        int res=0;
        int i=0; 
        while(i<n/2){
            int left=2*i+1;
            int right=2*i+2;
            if(left<n && arr[i]<arr[left])
                return false;
            if(right<n && arr[i]<arr[right])
                return false;
                
            i++;
        }
        
        return true;
    
        
    }
};
