
public class MultiplicationTableRecursion {
	void mult_table_y(int x, int y)
	{
	   if ( y != 1 )
	   {
	      mult_table_y(x, y-1);
	   }
	   System.out.print(x*y);
	}

	void mult_table(int x, int y)
	{
	   if ( x != 1 )
	   {
	      mult_table(x-1, y);
	   }
	   System.out.print(x + " * " + y + " = " + x*y);
//	   mult_table_y(x, y);
	   System.out.println();
	}

	public static void main(String[] args) {
		MultiplicationTableRecursion obj = new MultiplicationTableRecursion();
		obj.mult_table(10, 5);
	}
}
