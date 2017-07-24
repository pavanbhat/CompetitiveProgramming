import java.util.Arrays;
import java.util.Scanner;

public class Hackerland {
	int [] arr;
	public static void main(String[] args) {
		Hackerland sol = new Hackerland();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = input.nextInt();
        }
        Arrays.sort(x);
        
        for(int a : x){
        	System.out.print(a + " ");
        }
        System.out.println();
        int r1 = 0, l1 = 0, l2 = 0, r2 = 0;
        sol.arr = new int[x[n-1] + 1];
        int count = 0;
        for(int j = 0; j < n - 1; j++){
        	if(j == 0){
        		sol.arr[x[j]] = 1;
        		l1 = x[j];
        		r1 = x[j] + k;
        		continue;
        	}
        	l2 = x[j] - k;
        	r2 = x[j] + k;
        	if(l1 >= l2 && r1 <= r2){
        		sol.arr[x[j]] = 1;
        		l1 = l2;
        		r1 = r2;
        		for (int i = x[j]-1; i >=  x[j] - k; i--) {
        			if(i >= 0){
        				sol.arr[i] = 0;        				
        			}
				}
//        		arr[x[j] - k] = 0;
        	}
        	else{
        		if(r1 < l2){
        			sol.arr[x[j]] = 1;
        			l1 = x[j] - k;
                	r1 = x[j] + k;
        		}
        	}
        }
        int index = 0;
        index = sol.func();
        for (int i = index + k + 1; i < sol.arr.length; i++) {
        	if(i < sol.arr.length){
        		sol.arr[i] = 1; 
        		index = sol.func();
			}
		}
        for(int a : sol.arr){
        	System.out.print(a + "\t");
        	if(a == 1){
            	count++;        		
        	}
        }
        System.out.println();
        System.out.println(count);
        input.close();
        
        /*int numOfTransmitters = 0;
        int i = 0;
         
         Key is to use greedy algorithm to always place the transmitter at the house furthest to the right possible 
        * to cover the range.
        
        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
             
            //go to right as far as we cover i_orig as well.
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k; // this is where we place the transmitter
            //now go to the right of x[i] by k because transmitter at x[i] covers houses to its right as well. 
            while (i < n && x[i] <= loc) i++;
        }
        System.out.println(numOfTransmitters);*/
    }
	
	public int func(){
		int index = 0;
		for (int i = arr.length - 1; i >=  0; i--) {
        	if(arr[i] == 1){
    			index = i;   
    			break;
			}
		}
		return index;
	}
}

/*
5 1
1 2 3 4 5

8 2
7 2 4 6 5 9 12 11

8 2
9 5 4 2 6 15 11 12*/