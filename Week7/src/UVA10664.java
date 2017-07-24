import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVA10664 {
	public static void main(String[] args) {
		UVA10664 sol = new UVA10664();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		int sum = 0;
		String[] temp;
		input.nextLine();
		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; i < cases; i++) {
			temp = input.nextLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				num.add(Integer.parseInt(temp[j]));
				sum += Integer.parseInt(temp[j]);
			}
			Collections.sort(num);
			if (sum % 2 != 0) {
				System.out.println("NO");
			} else {
				if (sol.findingSubsetSum(num, 0, num.size() - 1, sum / 2)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			sum = 0;
			num.clear();
		}
		System.out.println();
	}

		boolean findingSubsetSum(ArrayList<Integer> nums, int pos, int end, int sum) {
			if (sum == 0) {
				return true;
			} else if (sum < 0 || pos == end) {
				return false;
			} else if (findingSubsetSum(nums, pos + 1, end, sum - nums.get(pos))) {
				return true;
			}
			if (findingSubsetSum(nums, pos + 1, end, sum)) {
				return true;
			}
			return false;
	}

}

/*
 * 
 * 3 1 2 1 2 1 2 3 4 1 2 5 10 50 3 50 3 5 2 7 1 7 5 2 8 9 1 25 15 8 3 1 38 45 8
 * 1
 * 
 */