// User function template for C++
class Solution{
    public:
    string equilibrium(vector<int> &arr){
        int n=arr.size();
        
        int sum=accumulate(arr.begin(), arr.end(), 0);
        int left=0;
        for(int i=0; i<n; i++){
            int right=sum-left-arr[i];
            if(right == left)
                return "true";
            left += arr[i];
        }
        
        return "false";
    }
};