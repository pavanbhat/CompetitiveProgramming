import java.util.ArrayList;
import java.util.Scanner;

public class UVA151 {
	public static void main(String[] args) {
		UVA151 sol = new UVA151();
		Scanner input = new Scanner(System.in);
		int num  = 0, result = 0;
		while((num = input.nextInt()) !=  0){
			result = sol.solveCrisis(num);
			System.out.println(result);
		}
		input.close();		
	}
	
	public int solveCrisis(int num){
		int currentCity = 0, result = 0, removedValue = 0, offset = 0;
		boolean flag = false;
		ArrayList<Integer> cities = new ArrayList<>();		

		while(true) {
			offset++;
			currentCity = 1; result = -1; removedValue = -1; flag = false;
			cities.clear();
			for(int k = 1; k <= num; k++){
				cities.add(k);
			}
			while(cities.size() > 1){
				if(currentCity == 1){
					removedValue = cities.remove(0);		
					currentCity++;
					if(removedValue == 13 && cities.size() > 1){
						flag = true;
						break;
					}
				}
				else{
					for(int j = 0; j < offset - 1; j++){
						removedValue = cities.remove(0);
						cities.add(removedValue);						
					}
					currentCity = 1;
				}
			}
			if(flag){
				continue;
			}
			if(cities.get(0) == 13 && cities.size() == 1){
				result = offset;
				break;
			}
		}
		return result;
	}
}

/*
test cases:

17
0

*/