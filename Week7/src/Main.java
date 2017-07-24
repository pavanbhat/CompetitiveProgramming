import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main sol = new Main();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		input.nextLine();
		double x = 0, y = 0;
		// BigDecimal prec = new BigDecimal("6.2500000001",
		// MathContext.DECIMAL64);
		int count = 0, maxChips = 0;
		String temp = "";
		String[] p;
		ArrayList<Point> chips;
		for (int c = 0; c < cases; c++) {
			input.nextLine();
			count = 0;
			maxChips = 0;
			chips = new ArrayList<>();
			while (true) {
				temp = input.nextLine();
				if (!temp.equals("")) {
					p = temp.split(" ");
					x = Double.parseDouble(p[0]);
					y = Double.parseDouble(p[1]);
					chips.add(new Point(x, y));
					count++;
				} else {
					break;
				}
			}
//			if (count > 0) {
//				maxChips = 1;
//			} else {
//				maxChips = 0;
//			}
			maxChips = 1;
			for (int i = 0; i < count; i++) {
				for (int j = 0; j < count; j++) {
					if (i != j) {
						Point center = sol.checkCircle(chips.get(i), chips.get(j), 2.5);
						if (center != null) {
							Point center1 = sol.checkCircle(chips.get(j), chips.get(i), 2.5);
							int firstCount = 0, secondCount = 0;
							for (int k = 0; k < count; k++) {
								 System.out.println(sol.distanceFormula(center, chips.get(k)) +" " + (2.5 * 2.5 + 1e-10) + "=== " + (sol.distanceFormula(center, chips.get(k)) <= (2.5 * 2.5 + 1e-10)));
								if (sol.distanceFormula(center, chips.get(k)) <= (2.5 * 2.5 + 1e-10)) {
									firstCount++;
								}
								if (sol.distanceFormula(center1, chips.get(k)) <= (2.5 * 2.5 + 1e-10)) {
									secondCount++;
								}
							}
							maxChips = firstCount > maxChips ? firstCount : maxChips;
							maxChips = secondCount > maxChips ? secondCount : maxChips;
						}
						int thirdCount = 0;
						Point centralPoint = sol.direction(chips.get(i), chips.get(j), 2.5);
						for (int l = 0; l < count; l++) {
							if (sol.distanceFormula(centralPoint, chips.get(l)) <= (2.5 * 2.5 + 1e-10)) {
								thirdCount++;
							}
						}
						if (thirdCount > maxChips) {
							maxChips = thirdCount;
						}

					}
				}
			}
			System.out.println(maxChips);
			if (cases > 1) {
				System.out.println();
			}

			/*
			 * countOfChips = new int[chips.size()]; for(Point p1 : chips){ x1 =
			 * p1.x; y1 = p1.y; for(int j = 0; j < chips.size(); j++){ x2 =
			 * chips.get(j).x; y2 = chips.get(j).y; distance = Math.sqrt((x1 -
			 * x2)*(x1 - x2) + (y1 - y2) *(y1 - y2)); if(distance != 0 &&
			 * distance <= 5){ ++countOfChips[count]; } } count++; } for(int k :
			 * countOfChips){ if(maxChips < k){ maxChips = k; } }
			 * System.out.println(maxChips);
			 */
		}
		input.close();
	}

	double distanceFormula(Point x, Point y) {
		double result = (x.x - y.x) * (x.x - y.x) + (x.y - y.y) * (x.y - y.y);
		return result;
	}

	Point checkCircle(Point x, Point y, double radius) {
		double diameter = distanceFormula(x, y);
		if (((radius * radius / diameter) - 0.25) < 0) {
			return null;
		}
		Point center = new Point((x.x + y.x) * 0.5 + (x.y - y.y) * Math.sqrt((radius * radius / diameter) - 0.25),
				(x.y + y.y) * 0.5 + (y.x - x.x) * Math.sqrt((radius * radius / diameter) - 0.25));
		return center;
	}

	Point direction(Point x, Point y, double radius) {
		double val = radius / Math.sqrt(distanceFormula(x, y));
		Point dir = new Point(x.x + val * (y.x - x.x), x.y + val * (y.y - x.y));
		return dir;
	}

}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}

/*
 * 2
 * 
 * 4.0 4.0 4.0 5.0 5.0 6.0 1.0 20.0 1.0 21.0 1.0 22.0 1.0 25.0 1.0 26.0
 * 
 */