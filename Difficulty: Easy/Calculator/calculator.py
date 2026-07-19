class Solution:
    def utility(self, a, b, opr):
        
        if opr == 1:
            c = a+b
            print(str(c))
        elif opr == 2 :
            c = a-b
            print(str(c))
        elif opr == 3:
            c =a*b
            print(str(c))
        else:
            print("Invalid Input")
        
        
        