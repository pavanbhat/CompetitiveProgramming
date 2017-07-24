import java.util.Scanner;

public class UVA562 {
	public static void main(String[] args) {
		UVA562 sol = new UVA562();
		int result = 0, coins = 0;
		int [] denominations;
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		input.nextLine();
		for(int i = 0; i  < cases; i++){
			coins = input.nextInt();
			denominations = new int[coins];
			for(int j = 0; j < coins; j++){
				denominations[j] = input.nextInt();
			}
		}
		
		result = sol.divideCoins();
		System.out.println(result);
		input.close();
	}

	private int divideCoins() {
		
		return 0;
	}
}
