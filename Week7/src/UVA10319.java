import java.util.Scanner;

public class UVA10319 {
	public static void main(String[] args) {
		UVA10319 sol = new UVA10319();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		String temp= ""; String [] temp1;
		String [] street;
		int S = 0, A = 0, R = 0;
		int s1 = 0, a1 = 0, s2 = 0, a2 = 0;
		for(int i = 0; i < cases; i++){
			temp = input.nextLine();
			if(temp != ""){
				temp1 = temp.split(" ");
				S = Integer.parseInt(temp1[0]);
				A = Integer.parseInt(temp1[1]);
				R = Integer.parseInt(temp1[2]);
				for(int j = 0; j < R; j++){
					street = input.nextLine().split(" ");
					s1= Integer.parseInt(street[0]);
					a1= Integer.parseInt(street[1]);
					s2= Integer.parseInt(street[2]);
					a2= Integer.parseInt(street[3]);
				}
			}
		}
	}
}
