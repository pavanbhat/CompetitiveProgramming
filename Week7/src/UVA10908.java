import java.util.Scanner;

public class UVA10908 {
	public static void main(String[] args) {
		UVA10908 sol = new UVA10908();
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		String [] temp; int M = 0, N = 0, Q = 0;
		String row = "", test = "";
		char [][] matrix; int r = 0, c = 0, result = 0;
		for(int i = 0; i < cases; i++){
			test = input.nextLine();
			if(test.equals("")){
				test = input.nextLine();
			}
			else{
				if(!Character.isDigit(test.charAt(0))){
					break;
				}
			}	
			temp = test.split(" ");
			M = Integer.parseInt(temp[0]);
			N = Integer.parseInt(temp[1]);
			Q = Integer.parseInt(temp[2]);
			matrix = new char[M][N];
			for(int j = 0; j < M; j++){
				row = input.nextLine();
				for(int k = 0; k < N; k++){
					matrix[j][k] = row.charAt(k);
				}
			}
			System.out.println(M + " " + N + " " + Q);
			for(int j = 0; j < Q; j++){
				r = input.nextInt();
				c = input.nextInt();
				result = sol.findSquare(matrix, r, c, matrix[r][c]);
				System.out.println(result);
			}
		}
		input.close();
	}

	private int findSquare(char[][] matrix, int r, int c, char type) {
		int count = 1; boolean flag = false;
		while(true){
			if(r - count >= 0 && r + count <= matrix.length - 1 && c - count >= 0 && c + count <= matrix[0].length - 1){
				for(int i = r - count; i <= r + count; i++){
					for (int j = c - count; j <= c + count; j++) {
						if(matrix[i][j] != type){
							flag = true;
							break;
						}
					}
					if(flag){
						break;
					}
				}
			}
			else{
				break;
			}
			if(flag){
				break;
			}
			count++;	
		}
		return 2*(count-1)+1;
	}
}


/*
1
7 10 4
abbbaaaaaa
abbbaaaaaa
abbbaaaaaa
aaaaaaaaaa
aaaaaaaaaa
aaccaaaaaa
aaccaaaaaa
1 2
2 4
4 6
5 2

7
7 10 5
abbbabaaaa
abbbaaaaaa
abbbbaaaaa
baabbaaaaa
aaaaaaaaaa
aaccaaaaaa
aaccaaaaaa
1 2
2 4
4 6
6 3
4 7
1 1 1
a
0 0
0 0 0
5 5 3
AAAAA
ABABA
ABABA
ABABA
AAAAA
2 2
0 0
1 1
20 30 5
111111111222222222333333311111
111111111112222233333311111444
111222111111122222222222111133
222222222222222222222222222222
333333312222222221111111111111
333333333332222222222222211111
333333311112222224444411111111
333333333332222244444411111111
333333311112222244444444444444
333333333322222224444444444443
333333333332222244444411111111
333333311112222244444444444444
333333333322222224444444444443
111111111111111111111111111111
111111111111111111111111111122
111111333311111111111111111122
111111333311111333333333333333
111111333311111111111111111111
111111333311111111111111111111
111111333311111111111111111111
1 1
8 3
17 8
7 20
5 13
9 10 1
qqqqqqqqqW
UUUUqqqqqK
JJJJJZZZZZ
JJJNNNNNNN
JqqNNNNNNN
JqqNNNNNNN
JJJJJJJJJe
qejjjjQQQQ
OOOOOOOQQQ
1 0
2 17 1
JJJJJJJJJJUUUBvsM
JJJJJJJJJJCCCggmx
1 3



*/