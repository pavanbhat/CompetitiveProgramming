import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OJ469 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		OJ469 obj = new OJ469();
		String area = "", coordinates = "";
		char[] row;
		int x, y;
		ArrayList<char[]> totalArea = new ArrayList<>();
		while (cases > 0) {
			input.nextLine();
			while (true) {
				row = input.next().toCharArray();
				if (Character.isDigit(row[0])) {
					for(char i : row){
						System.out.print(i + " ");
					}

					break;
				}
				totalArea.add(row);
			}
			/*for(int i  = 0; i < totalArea.size(); i++){
				for(char j : totalArea.get(i)){
					System.out.print(j + " ");
				}
				System.out.println();
			}*/
			System.out.println(row.length);
			for(char i : row){
				System.out.print(i + " ");
			}
			
			x = Integer.parseInt(""+row[0]);
			y = input.nextInt();
			while(input.hasNext()){
				System.out.println(input.nextInt());
			}
			
//			obj.solveWetlandsOfFlorida(totalArea);
		}
		input.close();
	}

	private void solveWetlandsOfFlorida(ArrayList<char[]> totalArea) {
		HashMap<String, Boolean> visited = new HashMap<>();
		Queue<String> water = new LinkedList<>();
		int row = 2, col = 1, count = 0;
		String[] arr;
		water.add(row + "," + col);
		while (true) {
			if (!water.isEmpty()) {
				arr = water.poll().split(",");
				row = Integer.parseInt(arr[0]);
				col = Integer.parseInt(arr[1]);
//				if (totalArea.get(row).charAt(col) == 'W' && count == 0) {
//					count++;
//				} else if (totalArea.get(row).charAt(col) == 'W') {

//				}
			}

		}

	}

}
