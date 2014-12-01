package map;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:33
 */
public interface Trainable
{
	void computeOutput();

	void computeError();

	void updateWeights();
}
