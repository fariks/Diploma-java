package map.stub;

import map.Backward;
import util.Size2D;

/**
 * @author: alsm0813
 * Date: 11.12.2014
 * Time: 11:33
 */
public class BackwardStub implements Backward
{
	private float[] error;
	private float[] weights;
	private Size2D size;
	private Size2D weights_size;

	public BackwardStub(Size2D size, float[] error, Size2D weights_size, float[] weights)
	{
		this.error = error;
		this.weights = weights;
		this.size = size;
		this.weights_size = weights_size;
	}

	@Override
	public float[] getError()
	{
		return error;
	}

	@Override
	public float[] getWeights()
	{
		return weights;
	}

	@Override
	public Size2D getInputSize()
	{
		return size;
	}

	@Override
	public Size2D getWeightsSize()
	{
		return weights_size;
	}
}
