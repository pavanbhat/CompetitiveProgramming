import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVA735 {
	public static void main(String[] args) {
		UVA735 obj = new UVA735();
		Scanner input = new Scanner(System.in).useDelimiter("\n");
		int num = -1;
		String temp ="", result = "";
		while (input.hasNext()) {
			temp = input.nextLine();
			if(temp.isEmpty()){
//				System.out.println("END OF OUTPUT");
				result += "END OF OUTPUT";
				break;
			}
			num = Integer.parseInt(temp);
			if(num != 0){
				int[] c_result = obj.findCombinations(num);
				if (c_result[0] == 0) {
//					System.out.println("THE SCORE OF " + num + " CANNOT BE MADE WITH THREE DARTS.");
					result += "THE SCORE OF " + num + " CANNOT BE MADE WITH THREE DARTS." + "\n";
				} else {
//					int p_result = obj.findPermutations(num);
//					System.out.println("NUMBER OF COMBINATIONS THAT SCORES " + num + " IS " + c_result + ".");
//					System.out.println("NUMBER OF PERMUTATIONS THAT SCORES " + num + " IS " + p_result + ".");
					result += "NUMBER OF COMBINATIONS THAT SCORES " + num + " IS " + c_result[0] + "." +"\n" + "NUMBER OF PERMUTATIONS THAT SCORES " + num + " IS " + c_result[1] + "." + "\n";
				}
				result += ("**********************************************************************" + "\n");
			}
			/*else{
				result += "END OF OUTPUT";
				break;
			}*/
			
		}
		System.out.println(result);
		input.close();

	}

	private int[] findCombinations(int num) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 26, 27, 28,
				30, 32, 33, 34, 36, 38, 39, 40, 42, 45, 48, 50, 51, 54, 57, 60 };
		HashMap<String, Boolean> consideredList = new HashMap<>();
		ArrayList<Integer> sortedList = new ArrayList<>();
		HashMap<Integer, Boolean> possibleNum = new HashMap<>();
		for(Integer a: arr){
			possibleNum.put(a, false);
		}
		int count = 0, perm_count = 0;
		String key = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
					if (possibleNum.containsKey(num - (arr[i] + arr[j]))) {
						sortedList.add(arr[i]);
						sortedList.add(arr[j]);
						sortedList.add(num - (arr[i] + arr[j]));
						Collections.sort(sortedList);
						perm_count++;
						for (Integer a : sortedList) {
							key += a;
						}
						if (!consideredList.containsKey(key)) {
							count++;
							consideredList.put(key, true);
						}
						key = "";
						sortedList.clear();
					}
					if (arr[i] + arr[j] > num) {
						break;
					}
			}
		}
		
		int result[] = {count, perm_count};
		return result;
	}

	private int findPermutations(int num) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 26, 27, 28,
				30, 32, 33, 34, 36, 38, 39, 40, 42, 45, 48, 50, 51, 54, 57, 60 };
		int count = 0;
		HashMap<Integer, Boolean> possibleNum = new HashMap<>();
		for(Integer a: arr){
			possibleNum.put(a, false);
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
					if (possibleNum.containsKey(num - (arr[i] + arr[j]))) {
						count++;
					}
					if (arr[i] + arr[j] > num) {
						break;
					}
			}
		}

		return count;
	}
}
