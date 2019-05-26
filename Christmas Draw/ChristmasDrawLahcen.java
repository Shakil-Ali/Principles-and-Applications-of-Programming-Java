import java.util.Random;

public class ChristmasDrawLahcen {
	public static void main(String[] args) {

		String [] buyFor = {"x1","x2","x3","y1","y2","y3","x4","y4","x5","y5"};
		String [] buyTo = {"x1","x2","x3","y1","y2","y3","x4","y4","x5","y5"};
		String  [] [] couples = {{"x1","y2"},{"x2","y2"},{"x3","y3"},{"x4","y4"},{"x5","y5"}};
		String [] [] lastYear = {{"y4","y2"},{"x3","x5"},{"y5","x1"},{"x2","x3"},{"y3","y1"},
								{"y2","x4"},{"x4","y3"},{"x5","x2"},{"y1","x5"},
								{"x1","y4"}};

		int n = 10;
		Random r = new Random();
		int x = 0;

		while(x < n) {
			int i = r.nextInt(n);
			int i = r.nextInt(n);
			if (!notAllowed(couples, buyFor[i], buyTo[j]) && 
				  !notAllowed(couples, buyFor[j], buyTo[i]) &&
				  !notAllowed(lastYear, buyFor[i], buyTo[j]) )
				{
						System.out.println(buyFor[i] + "will buy for" + buyTo[i]);
					String temp = buyFor[i];
					buyFor[i] = buyFor[n-1];
					buyFor[n-1] = temp;
					temp = buyTo[j];
					buyTo[j] = buyTo[n-1];
					buyTo[n-1] = temp;
					n = n-1;

				}
		}

	}


	public static boolean notAllowed(String [] [] a, String x, String y)
	{

			for (int i = 0; i < n.length; i++)
				if (a[i][0].equals(x) && a[i][1].equals(y) ||
						x.equals(y)) return true;
			return false;
			
	}

 } 


