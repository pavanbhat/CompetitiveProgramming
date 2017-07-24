import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int LISTSIZE = 1500;
	public static void main(String[] args) {
		Main sol = new Main();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		System.out.println(cases);
		int val = 0;
		ArrayList<Point> resultant = null;
		ArrayList<Point> points = null;
		while(cases > 0){
			points = new ArrayList<>();
			for(int i = 0; i < LISTSIZE; i++){
				points.add(new Point(0,0));
			}
			val = input.nextInt();
			input.nextLine();
			--val;
			int iter = 0;
			int firstIndex = 0;
			while( iter  < val){
				int x = input.nextInt();
				int y = input.nextInt();
				points.get(iter).x = x;
				points.get(iter).y = y;
				if(y < points.get(firstIndex).y || y == points.get(firstIndex).y && x == points.get(firstIndex).x){
					firstIndex = iter;
				}
//				input.nextLine();
				boolean [] arr = new boolean[LISTSIZE];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = true;
				}
				arr[firstIndex] = false;
				resultant = new ArrayList<>();
				resultant.add(points.get(firstIndex));
				int value = 0;
				
				for(boolean flag = true; flag != false;){
					flag = false;
					Point finalPoint = resultant.get(resultant.size() - 1);
					value = val;
					for(int temp = 0; temp < val; temp++){
						if(arr[temp]){
							value = temp;
							break;
						}
					}
					if(value < val){
						for(int i = 0; i < val; i++){
							if(arr[i]){
								double productValue = sol.product(finalPoint, points.get(value), points.get(i));
								if(productValue < 0 || productValue == 0 && sol.distanceFormula(finalPoint, points.get(value)) < sol.distanceFormula(finalPoint, points.get(i))){
									value = i;
									
								}
							}
						}
						if(sol.product(finalPoint, points.get(firstIndex), points.get(value)) < 0 || finalPoint.x == points.get(firstIndex).x && finalPoint.y == points.get(firstIndex).y){
							resultant.add(points.get(value));
							arr[value] = false;
							flag = true;
						}
					}
				}
					
				iter++;
			}
			
			if(resultant.size() > 0){
				System.out.println(resultant.size() + 1);
				for (Point point : resultant) {
					System.out.println(point.x + " " + point.y);
				}
				System.out.println(resultant.get(0).x + " " + resultant.get(0).y);
			}
			else{
				System.out.println(0);
			}
			if(cases > 1){
				System.out.println(-1);
				val = input.nextInt();
			}
			cases--;
		}
		input.close();
	}
	
	double distanceFormula(Point x, Point y) {
		double result = (x.x - y.x) * (x.x - y.x) + (x.y - y.y) * (x.y - y.y);
		return result;
	}
	
	double product(Point x, Point y, Point z){
		return ((y.x - x.x) * (z.y - x.y) - (z.x - x.x) * (y.y - x.y));
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}