package map;

import util.Size2D;

/**
 * @author: alsm0813
 * Date: 08.12.2014
 * Time: 4:51
 */
public class ForwardTest implements Forward
{
	private float[] output;

	private Size2D size;

	public ForwardTest(Size2D size, float[] output)
	{
		this.output = output;
		this.size = size;
	}

	@Override
	public float[] getOutput()
	{
		return output;
	}

	@Override
	public Size2D getSize()
	{
		return size;
	}
}
