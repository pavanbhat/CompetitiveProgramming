// you can also use imports, for example:
//import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class codilitySol {
	public static void main(String[] args) {
		codilitySol cs = new codilitySol();
//		int [] A = {-1, 3, -4, 5, 1, -6, 2, 1};
		int [] A = {1, 2, 3, 4, 5, -4, -3, -2, -1, 0};
		System.out.println(cs.sol(A));
	}
    public int solution(int[] A) {
        // write your code in Java SE 8
        int totalSum = 0;
        String sArr[] = new String[A.length];
        String [] temp = new String[2];
        if(A.length == 0){
            return 0;
        }
        else{
            for(int i = 0; i < A.length; i++){
                   sArr[i] = "" + totalSum;
                   totalSum += A[i];
            }
            totalSum = 0;
            for(int j = A.length - 1; j >= 0; j--){
                   sArr[j] += "," + totalSum;
                   totalSum += A[j];
            }
            for(int k = 0; k < A.length; k++){
                    temp = sArr[k].split(",");
                    if(temp[0].equals(temp[1])){
                        System.out.print(k + " "); // return k;  
                    }
            }
        }
        return 0;
    }
    
    public int sol(int [] A){
    	int totalSum = 0;
        String sArr[] = new String[A.length];
        String [] temp = new String[2];
        if(A.length == 0){
            return 0;
        }
        else{
            for(int i = 0; i < A.length; i++){
                   sArr[i] = "" + totalSum;
                   totalSum += A[i];
            }
            totalSum = 0;
            for(int j = A.length - 1; j >= 0; j--){
                   /*sArr[j] += "," + totalSum;
                   totalSum += A[j];*/
            	System.out.println(sArr[j] + " " + totalSum);
                   if(sArr[j].equalsIgnoreCase(""+totalSum)){
                	   System.out.println(sArr[j]);
                        return j;   
                   }
                   totalSum += A[j];
            }
            /*for(int k = 0; k < A.length; k++){
                    temp = sArr[k].split(",");
                    if(temp[0].equals(temp[1])){
                       // System.out.print(k + " "); 
                       return k;  
                    }
            }*/
        }
        return 0;
    }
}