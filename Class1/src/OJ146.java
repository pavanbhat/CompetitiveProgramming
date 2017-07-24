import java.util.Scanner;

class OJ146 {
	public static void main(String[] args) {
		OJ146 obj = new OJ146();
		Scanner input = new Scanner(System.in);
		String finalInput = "";
		while (!finalInput.equals("#")) {
			finalInput = input.next();
			if (!finalInput.equals("#")) {
				System.out.println(obj.solveIdCodes(finalInput));
			}
		}
		System.out.println();
		input.close();
	}

	private String solveIdCodes(String temp) {
		char[] arr = temp.toCharArray();
		String result = "";
		char swapChar = '\0';

		if (arr.length < 2 || arr == null) {
			return "No Successor";
		}
		
		int tempPos = 0, refPos = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if ((int) arr[i] < (int) arr[i + 1]) {
				refPos = i;
				break;
			}
		}

		for (int i = arr.length - 1; i > refPos; i--) {
			if ((int) arr[i] > (int) arr[refPos]) {
				tempPos = i;
				break;
			}
		}
		
		if(refPos == 0 && tempPos == 0){
			return "No Successor";
		}
		
		swapChar = arr[refPos];
		arr[refPos] = arr[tempPos];
		arr[tempPos] = swapChar;

		int count1 = refPos + 1, count2 = arr.length - 1;
		if (refPos < arr.length - 1) {
			while (count1 < count2) {
				swapChar = arr[count1];
				arr[count1] = arr[count2];
				arr[count2] = swapChar;
				count1++;
				count2--;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			result += arr[j];
		}

		if (result.equals("")) {
			result = "No Successor";
		}
		return result;
	}
}
