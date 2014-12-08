package util;

/**
 * @author: alsm0813
 * Date: 08.12.2014
 * Time: 9:41
 */
public class Print
{
	public static void print2D(float[] x, Size2D size)
	{
		for (int i = 0; i < size.x; i++)
		{
			for (int j = 0; j < size.y; j++)
			{
				System.out.printf("%.2f ", x[i * size.y + j]);
			}
			System.out.println();
		}
	}
}
