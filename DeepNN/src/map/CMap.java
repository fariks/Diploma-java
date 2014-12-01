package map;

import util.Size2D;

import java.util.List;

/**
 * @author: alsm0813
 * Date: 24.11.2014
 * Time: 5:30
 */
public class CMap implements FeatureMap
{
	private float[] output;

	private float[] error;

	private float[] weights;

	private float bias;

	private Size2D size;

	private List<Forward> prevMaps;

	private List<Backward> nextMaps;

	@Override
	public Size2D getSize()
	{
		return size;
	}

	@Override
	public void computeOutput()
	{

	}

	@Override
	public void computeError()
	{

	}

	@Override
	public void updateWeights()
	{

	}

	@Override
	public float[] getOutput()
	{
		return output;
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
}
