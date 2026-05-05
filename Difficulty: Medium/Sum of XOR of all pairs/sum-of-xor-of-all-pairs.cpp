#define ll long long int

class Solution{
    public:
    long long sumXOR(vector<int> &arr){
        int n=arr.size();
        
        ll res=0;
        for(int b=0; b<32; b++){
            ll c1=0;
            for(int i=0; i<n; i++){
                if(arr[i]&(1<<b))
                    c1++;
            }
            ll c0=n-c1;
            // cout << c1 << " " << c0 << endl;
            res += (c1*c0*(1ll<<b));
        }
        
        return res;
        
    }
};