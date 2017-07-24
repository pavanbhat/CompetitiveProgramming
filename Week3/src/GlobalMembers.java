import java.io.IOException;

public class GlobalMembers
{
	//
	// Created by pavan on 5/17/2017.
	//

	   public static final int maxn = 2000;
	   public static final int[] coins = {0,1,2,4,10,20,40};
	   public static final double eps = 1E-9;

	   public static void maked()
	   {
		   for (int i = 0; i <= maxn; i++)
		   {
			   for (int j = 0; j <= 6; j++)
			   {
				   d[i][j] = 251;
			   }
		   }
		   for (int j = 0; j <= 6; j++)
		   {
			   d[0][j] = 0;
		   }
		   for (int i = 1; i <= maxn; i++)
		   {
			   for (int j = 1; j <= 6; j++)
			   {
				   if (coins[j] <= i)
				   {
					   d[i][j] = Math.min(d[i - coins[j]][j] + 1,d[i][j - 1]);
				   }
				   else
				   {
					   d[i][j] = d[i][j - 1];
				   }
			   }
		   }
	   }
	   public static void makef(int n)
	   {
		   for (int i = 0; i <= n * 5; i++)
		   {
			   for (int j = 0; j <= 6; j++)
			   {
				   for (int k = 0; k <= 251; k++)
				   {
					   f[i][j][k] = 251;
				   }
			   }
		   }
		   for (int j = 0; j <= 6; j++)
		   {
			   for (int k = 0; k <= 251; k++)
			   {
				   f[0][j][k] = 0;
			   }
		   }
		   for (int i = 1; i <= n * 5; i++)
		   {
			   for (int j = 1; j <= 6; j++)
			   {
				   f[i][j][0] = f[i][j - 1][a[j - 1]];
				   for (int k = 1; k <= a[j]; k++)
				   {
					   if (k == 1)
					   {
						   f[i][j][k] = f[i][j - 1][a[j - 1]];
					   }
					   else
					   {
						   f[i][j][k] = f[i][j][k - 1];
					   }
					  if (coins[j] <= i)
					  {
						  if (k > 1)
						  {
							  f[i][j][k] = Math.min(f[i][j][k],f[i - coins[j]][j][k - 1] + 1);
						  }
						  else
						  {
							  f[i][j][k] = Math.min(f[i][j][k],f[i - coins[j]][j - 1][a[j - 1]] + 1);
						  }
					  }
				   }
			   }
		   }
	   }

	   public static int[][] d = new int[maxn][10];
	   public static int[][][] f = new int[maxn][10][251];
	   public static int[] a = new int[7];
	   public static double n;

	   public static void main(String [] args) throws NumberFormatException, IOException
	   {
		   maked();
		   while (true)
		   {
			   int sum = 0;
			   for (int i = 1; i <= 6; i++)
			   {
				   a[i] = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
				   sum += a[i];
			   }
			   if (sum == 0)
			   {
				   break;
			   }
			   n = Double.parseDouble(ConsoleInput.readToWhiteSpace(true));
			   int tmp = (int) ((n + eps) * 20);
			   makef(tmp);
			   int result = f[tmp][6][a[6]];
			   for (int i = tmp + 1; i <= tmp * 5; i++)
			   {
				   result = Math.min(result,f[i][6][a[6]] + d[i - tmp][6]);
			   }
			   System.out.printf("%3d", result);
			   System.out.printf("%d", "\n");
		   }
	   }
}