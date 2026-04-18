// User function Template for C++
//  Class Solution to contain the method for solving the problem.
class Solution{
    public:
    // Function to determine if array arr can be split into three equal sum sets.
    vector<int> findSplit(vector<int> &arr){
        int n=arr.size();
        
        int total=accumulate(arr.begin(), arr.end(), 0);
        if(total%3 != 0)
            return {-1, -1};
        
        int first=-1, second=-1;
        int t=total/3;
        int sum=0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == t && first == -1){
                first=i;
            }
            else if(sum == 2*t && first != -1 && i<n-1){
                second=i;
                break;
            }
        }
        
        if(first == -1 || second == -1){
            return {-1, -1};
        }
        
        return {first, second};
        
    }
};