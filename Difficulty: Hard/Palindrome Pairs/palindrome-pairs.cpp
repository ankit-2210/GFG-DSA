class Solution{
    static const int ALPHABET_SIZE=26;
    struct TrieNode{
        TrieNode *children[ALPHABET_SIZE];
        vector<int> indices;
        int idx;
    };
    
    TrieNode *root;
    TrieNode *getNode(){
        TrieNode *pNode=new TrieNode();
        pNode->idx=-1;
        for(int i=0; i<ALPHABET_SIZE; i++){
            pNode->children[i]=NULL;
        }
        return pNode;
    }
    
    public:
    Solution(){
        root=getNode();
    }
    
    bool solve(string w, int i, int j){
        while(i<j){
            if(w[i] != w[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    void insert(string word, int id){
        TrieNode *pCrawl=root;
        for(int i=word.size()-1; i>=0; i--){
            if(solve(word, 0, i)){
                pCrawl->indices.push_back(id);
            }
            int c=word[i]-'a';
            if(!pCrawl->children[c]){
                pCrawl->children[c]=getNode();
            }
            pCrawl=pCrawl->children[c];
        }
        pCrawl->idx=id;
        pCrawl->indices.push_back(id);
    }
    
    bool search(string word, int id){
        TrieNode *pCrawl=root;
        for(int i=0; i<word.size(); i++){
            int c=word[i]-'a';
            if(pCrawl->idx>=0 && pCrawl->idx != id && solve(word, i, word.size()-1)){
                return true;
            }
            if(!pCrawl->children[c])
                return false;
            pCrawl=pCrawl->children[c];
        }
        if(pCrawl){
            for(int it: pCrawl->indices){
                if(id != it)
                    return true;
            }
        }
        
        return false;
    }
    
    
    
    bool palindromePair(vector<string> &arr){
        int n=arr.size();
        
        for(int i=0; i<n; i++){
            insert(arr[i], i);
        }
        
        for(int i=0; i<n; i++){
            if(search(arr[i], i))
                return true;
        }
            
        return false;
    }
};