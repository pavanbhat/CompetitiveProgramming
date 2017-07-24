import java.util.Scanner;

public class UVA756 {
	public static void main(String[] args) {
		UVA756 sol = new UVA756();
		Scanner input = new Scanner(System.in);
		int p = 0, e = 0, i = 0, d = 0, result = 0, count = 0, pdays = 23, edays = 28, idays = 33;
		while ((p = input.nextInt()) != -1 && (e = input.nextInt()) != -1 && (i = input.nextInt()) != -1
				&& (d = input.nextInt()) != -1) {
			count++;
			result = sol.findArithmeticProgression(pdays, edays, idays, p, e, i);
			result = (result - d + (pdays * edays * idays)) % (pdays * edays * idays);
			if(result == 0 || result > (pdays * edays * idays)){
				result = pdays * edays * idays;
			}
			System.out.println("Case " + count + ": the next triple peak occurs in " + result + " days.");
		}
		input.close();
	}

	public int findArithmeticProgression(int pdays, int edays, int idays, int p, int e, int i) {
		int resultantPDays = edays * idays, resultantEDays = pdays * idays, resultantIDays = pdays * edays;
		while(true){
			if(resultantPDays % pdays == 1){
				break;
			}
			else{
				resultantPDays += edays * idays;
			}
		}
		while(true){
			if(resultantEDays % edays == 1){
				break;
			}
			else{
				resultantEDays += pdays * idays;
			}
		}
		while(true){
			if(resultantIDays % idays == 1){
				break;
			}
			else{
				resultantIDays += pdays * edays;
			}
		}
		int result = resultantPDays * p + resultantEDays * e + resultantIDays * i;
		return result;
	}

}

