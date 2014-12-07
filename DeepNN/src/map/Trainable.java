package map;

import java.util.List;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:33
 */
public interface Trainable
{
	void computeOutput(List<Forward> prevMaps);

	void computeError(List<Backward> prevMaps);

	void updateWeights();
}
