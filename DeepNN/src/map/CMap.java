package map;

import activation.Activation;
import activation.Sigmoid;
import util.Size2D;

import java.util.List;

/**
 * @author: alsm0813
 * Date: 24.11.2014
 * Time: 5:30
 */
public class CMap implements FeatureMap
{
	protected float[] map_input;

    protected float[] map_output;

    protected float[] map_error;

    protected float[] weights;

    protected float bias;

    protected final Size2D map_size;

    protected final Size2D weights_size;

    protected final Activation activation;

    protected final float LEARNING_RATE = 0.05f;

    public CMap(float[] weights, float bias, Size2D weights_size, Size2D map_size) {
        this.weights = weights;
        this.bias = bias;
        this.map_size = map_size;
        this.weights_size = weights_size;
        this.activation = new Sigmoid();
        this.map_output = new float[map_size.size()];
        this.map_input = new float[map_size.size()];
        this.map_error = new float[map_size.size()];
    }

    @Override
    public Size2D getWeightsSize() {
        return weights_size;
    }

    @Override
	public void computeOutput(List<Forward> prevMaps)
	{
        for (int ix = 0; ix < map_size.x; ix++) {
            for (int iy = 0; iy < map_size.y; iy++) {
                float sum = 0.f;
                for (Forward prevMap : prevMaps) {
                    float[] source = prevMap.getOutput();
                    Size2D source_size = prevMap.getOutputSize();
                    for (int jx = 0; jx < weights_size.x; jx++) {
                        for (int jy = 0; jy < weights_size.y; jy++) {
                            sum += weights[jx * weights_size.y + jy] *
                                    source[ix * source_size.y + iy + jx * source_size.y + jy];
                        }
                    }
                }
                sum += bias;
                map_input[ix * map_size.y + iy] = sum;
                map_output[ix * map_size.y + iy] = activation.get(sum);
            }
        }
	}

	@Override
	public void computeError(List<Backward> nextMaps)
	{
	}

	@Override
	public void updateWeights(List<Forward> prevMaps)
	{
        for (int iw = 0; iw < weights_size.x; iw++)
        {
            for (int jw = 0; jw < weights_size.y; jw++)
            {
                for (int im = 0; im < map_size.x; im++)
                {
                    for (int jm = 0; jm < map_size.y; jm++)
                    {
                        float m_sum = 0.f;
                        for (Forward prevMap : prevMaps)
                        {
                           m_sum += prevMap.getOutput()[(im + iw) * prevMap.getOutputSize().y + (jm + jw)];
                        }
                        weights[iw * weights_size.y + jw] += LEARNING_RATE * map_error[im * map_size.y + jm] * m_sum;
                    }
                }
            }
        }

        for (int im = 0; im < map_size.x; im++)
        {
            for (int jm = 0; jm < map_size.y; jm++)
            {
                bias += LEARNING_RATE * map_error[im * map_size.y + jm];
            }
        }
	}

	@Override
	public float[] getOutput()
	{
		return map_output;
	}

    @Override
    public Size2D getOutputSize()
    {
        return map_size;
    }

    @Override
	public float[] getError()
	{
		return map_error;
	}

    public float getBias() {
        return bias;
    }

    public void setError(float[] map_error) {
        this.map_error = map_error;
    }

    @Override
	public float[] getWeights()
	{
		return weights;
	}

    @Override
    public Size2D getInputSize()
    {
        return map_size;
    }
}
