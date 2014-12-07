package map;

import util.Size2D;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:23
 */
public interface Backward
{
	float[] getError();

	float[] getWeights();

	Size2D getSize();

	Size2D getWeightsSize();
}
