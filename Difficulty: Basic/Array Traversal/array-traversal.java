import java.util.stream.*;

class Solution{
    public static void arrayTraversal(int[] arr){
        
        String res = Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        
        System.out.print(res);
        
    }
}
