import java.util.Scanner;

public class OJ435 {
	public static void main(String[] args) {
		OJ435 obj = new OJ435();
		Scanner input = new Scanner(System.in);
		int cases = Integer.parseInt(input.nextLine());
		for(int i = 0; i < cases; i++){
			String[] temp = input.nextLine().split(" ");
			int[] nums = new int[temp.length - 1];
			for(int j = 0; j < Integer.parseInt(temp[0]); j++){
				nums[j] = Integer.parseInt(temp[j+1]);
			}
			obj.solveBlockVoting(nums);
		}
		input.close();
	}

	private void solveBlockVoting(int[] nums) {
		int subArr[][] = new int[nums.length][nums.length];
		int total = 0, majority = 0;
		for(int num : nums){
			total += num;
		}
		
		majority = (int) Math.ceil(total / 2.0);
		
		for(int i = 0; i < subArr.length; i++){
			for(int j = i+1; j < subArr.length; j++){
				
			}
		}
		System.out.println(majority);
		
	}
}
