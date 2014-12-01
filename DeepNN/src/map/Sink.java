package map;

import util.Size2D;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:16
 */
public class Sink implements FeatureMap
{
	@Override
	public float[] getError()
	{
		return new float[0];
	}

	@Override
	public float[] getWeights()
	{
		return new float[0];
	}

	@Override
	public float[] getOutput()
	{
		return new float[0];
	}

	@Override
	public Size2D getSize()
	{
		return null;
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
}
