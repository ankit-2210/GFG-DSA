#define ll long long int
#define mod 1000000007

class Solution{
    public:
    int findMaxProduct(vector<int> &arr){
        int n=arr.size();
        if(n == 1)
            return arr[0];
            
        int mnIdx=-1, mn=INT_MAX;
        int neg=0, zeros=0;
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                zeros++;
            }
            else if(arr[i]<0){
                neg++;
                if(mnIdx == -1 || arr[i]>mn){
                    mnIdx=i;
                    mn=arr[i];
                }
            }
        }
        
        if(zeros == n)
            return 0;
        if(neg == 1 && zeros == n-1)
            return 0;
        
        ll res=1;
        for(int i=0; i<n; i++){
            if(arr[i] == 0)
                continue;
            if(neg%2 == 1 && i == mnIdx)
                continue;
            res=(res*arr[i])%mod;
        }
        
        return res;
        
        
    }
};
