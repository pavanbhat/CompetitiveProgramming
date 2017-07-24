import java.util.Scanner;

public class OJ638 {
	 public static void main(String[] args) {
		OJ638 obj = new OJ638();
		Scanner input = new Scanner(System.in);
		char point = '\0'; int x1 = 0, y1 = 0, result = 0;
		while((point = input.next().charAt(0)) != '0'){
			point = input.next().charAt(0);
			x1 = input.nextInt();
			y1 = input.nextInt();
			result = obj.findRectangles();	
		}
		System.out.println(result);
		input.close();
	}

	private int findRectangles() {
		
		
		return 0;
	}
}
class Points{
	double x1;
	double y1;
	double x2;
	double y2;
	double distance;
}
