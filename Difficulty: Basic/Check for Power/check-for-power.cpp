class Solution{
    public:
    bool isPower(int x, int y){
          
        if(x == 1){
            if(y == 1)
                return true;
            return false;
        }
        
        if(x == 0){
            if(y == 0)
                return true;
            return false;
        }
        while(y%x == 0){
            y /= x;
        }
        
        if(y == 1)
            return true;
        
        return false;
    }
};