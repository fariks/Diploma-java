package map;

import activation.Activation;
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

    protected float[] error;

    protected float[] weights;

    protected float bias;

    protected final Size2D map_size;

    protected final Size2D weights_size;

    protected final Activation activation;

    public CMap(float[] weights, float bias, Size2D weights_size, Size2D map_size, Activation activation) {
        this.weights = weights;
        this.bias = bias;
        this.map_size = map_size;
        this.weights_size = weights_size;
        this.activation = activation;
        this.map_output = new float[map_size.size()];
        this.map_input = new float[map_size.size()];
        this.error = new float[map_size.size()];
    }

    @Override
	public Size2D getSize()
	{
		return map_size;
	}

	@Override
	public void computeOutput(List<Forward> prevMaps)
	{
        for (int ix = 0; ix < map_size.x; ix++) {
            for (int iy = 0; iy < map_size.y; iy++) {
                float sum = 0.f;
                for (Forward prevMap : prevMaps) {
                    float[] source = prevMap.getOutput();
                    Size2D source_size = prevMap.getSize();
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
	public void updateWeights()
	{

	}

	@Override
	public float[] getOutput()
	{
		return map_output;
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
