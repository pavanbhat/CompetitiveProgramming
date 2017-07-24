import java.util.ArrayList;
import java.util.Scanner;

public class UVA10015 {
	public static void main(String[] args) {
		UVA10015 sol = new UVA10015();
		Scanner input = new Scanner(System.in);
		int num, result = 0;
		ArrayList<Integer> primeNos = new ArrayList<>();
		while ((num = input.nextInt()) != 0) {
			for (int i = 2; i <= 35000; i++) {
				if (sol.findPrimes(i)) {
					primeNos.add(i);
				}
			}
			for (int j = 1; j <= num; j++) {
					result = (primeNos.get(num - j) + result) % j;
			}
			System.out.println(result + 1);
		}
		input.close();
	}

	public boolean findPrimes(int num) {
		for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/*
 * 
 * Test Cases: 6 0
 * 
 * 2 4 5 6 7 10 100 200 300 500 1000 2000 3000 3400 3501 0
 * 
 */