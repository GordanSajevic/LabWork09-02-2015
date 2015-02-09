
public class Task implements Runnable
{
	private int numOps = 100;
	
	@Override
	public void run() {
		Long start = System.nanoTime();
		for (int j=0; j<numOps; j++)
		{
			Long start1 = System.nanoTime();
			int num = 1;
			for (int i=0; i<1000000; i++)
			{
				num *= (int)(Math.random()*(100-1));
				if (num == 0)
				{
					num = (int)(Math.random()*(100-1));
				}
			}
			System.out.println("Result: " + num);
			Long end1 = System.nanoTime();
			System.out.println("Time: " + (end1-start1));
			Long start2 = System.nanoTime();
			int num2 = 1;
			for (int i=0; i<1000000; i++)
			{
				num2 += (int)(Math.random()*(100-1));
			}
			System.out.println("Result: " + num2);
			Long end2 = System.nanoTime();
			System.out.println("Time: " + (end2-start2));
		}
		Long end = System.nanoTime();
		System.out.println(end-start);
	}
}
