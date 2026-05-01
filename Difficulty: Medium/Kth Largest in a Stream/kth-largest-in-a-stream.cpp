class Solution{
    public:
    vector<int> kthLargest(vector<int> &arr, int k){
        int n=arr.size();
        
        vector<int> res(n);
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i=0; i<n; i++){
            pq.push(arr[i]);
            if(pq.size()>k){
                pq.pop();
            }
           
            res[i]=pq.size()==k?pq.top():-1;
        }
            
        return res;
    }
};