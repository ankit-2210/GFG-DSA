#define ll long long int

class Solution{
    public:
    ll gcd(ll a, ll b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    ll lcm(ll a, ll b){
        return (a/gcd(a,b))*b;
    }
    
    void solve(int idx, int low, int high, vector<int> &arr, vector<ll> &seg){
        if(low == high){
            seg[idx]=arr[low];
            return;
        }
        
        int mid=(low+high)/2;
        solve(2*idx+1, low, mid, arr, seg);
        solve(2*idx+2, mid+1, high, arr, seg);
        seg[idx]=lcm(seg[2*idx+1], seg[2*idx+2]);
    }
    
    void update(int idx, int low, int high, int pos, int val, vector<int> &arr, vector<ll> &seg){
        if(low == high){
            seg[idx]=val;
            return;
        }
        
        int mid=(low+high)/2;
        if(pos<=mid){
            update(2*idx+1, low, mid, pos, val, arr, seg);
        }
        else{
            update(2*idx+2, mid+1, high, pos, val, arr, seg);
        }
       
        seg[idx]=lcm(seg[2*idx+1], seg[2*idx+2]);
    }
    
    ll query(int idx, int low, int high, int l, int r, vector<ll> &seg){
        if(low>r || high<l){
            return 1;
        }
        if(l<=low && high<=r){
            return seg[idx];
        }
        
        int mid=(low+high)/2;
        ll left=query(2*idx+1, low, mid, l, r, seg);
        ll right=query(2*idx+2, mid+1, high, l, r, seg);
        return lcm(left, right);
    }
    
    vector<long long> RangeLCMQuery(vector<int> &arr, vector<vector<int>> &q){
        int n=arr.size();
        
        vector<ll> seg(n*4);
        solve(0, 0, n-1, arr, seg);
        
        vector<ll> res;
        for(auto it: q){
            if(it[0] == 1){
                update(0, 0, n-1, it[1], it[2], arr, seg);
            }
            else{
                ll t=query(0, 0, n-1, it[1], it[2], seg);
                res.push_back(t);
            }
        }
        
        return res;
            
        
    }
};