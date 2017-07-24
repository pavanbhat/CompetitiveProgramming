import java.util.Scanner;

public class DoubleSquares {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfinputs = input.nextInt();
		for (int i = 0; i < numOfinputs; i++) {
			int num = input.nextInt();
			int count = 0;
			for(int j = 0; j*j <= num; j++){
				for (int k = 0; k*k <= num-j*j; k++) {
					if(num == j*j + k*k){
						count++;
						break;
					}
				}
			}
			if(count % 2 != 0){
				System.out.println(count);
			}
			else{
				System.out.println(count / 2);
			}
		}
		input.close();
	}
}
