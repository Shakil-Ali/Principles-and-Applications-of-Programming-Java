import java.util.Random;

public class ChristmasDrawEx {
	public static void main(String args[]) {

		int[] couples = new int[10];
		int[] boughtForLastYear = new int[10];

		for (int i = 0; i < couples.length; i++)
		{
			couples[i] = i + 1;
		}

		System.out.println("This years pairing");
		boughtForLastYear = GeneratePairs(couples, boughtForLastYear);
		System.out.println();
		System.out.println("Next years pairing");
		boughtForLastYear = GeneratePairs(couples, boughtForLastYear);

	}

		private static int[] GeneratePairs(int[] couples, int[] notAllowedArr)
		{
			int[] pairs = new int[10];
			Random r = new Random();
			int i = 0;
			while (i < couples.length)
			{
				int randomInt = r.nextInt(10) + 1;
				if (couples[i] == randomInt || notAllowedArr[i] == randomInt)
				{
					continue;
				}
				boolean cont = false;
				for (int j = 0; j < pairs.length; j++)
				{
					if(pairs[j] == randomInt) {
						cont = true;
						break;
					}
				}
				if (cont == true)
					continue;

				pairs[i] = randomInt;
				System.out.println("Couple L" + couples[i] + "is not allowed to buy for Couple R" + pairs[i]);
				i++;
			}

			return pairs;
		}





}
