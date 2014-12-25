package map;

import activation.Activation;
import util.Size2D;

import java.util.List;

/**
 * @author: alsm0813
 * Date: 24.11.2014
 * Time: 5:31
 */
public class CPMap extends CMap
{

	private final Size2D pool_size;

	private float[] pool_output;

	private float[] pool_error;

	private int[] pool_input_indexes;

	public CPMap(
		float[] weights,
		float bias,
		Size2D weights_size,
		Size2D map_size,
		Size2D pool_window_size
	)
	{
		super(weights, bias, weights_size, map_size);
		this.pool_size = new Size2D(map_size.x / pool_window_size.x, map_size.y / pool_window_size.y);
		this.pool_output = new float[pool_size.size()];
		this.pool_error = new float[pool_size.size()];
		this.pool_input_indexes = new int[pool_size.size()];
	}

	@Override
	public void computeOutput(List<Forward> prevMaps)
	{
		super.computeOutput(prevMaps);

		for (int ix = 0, kx = 0; ix < map_size.x; ix += pool_size.x, kx++)
		{
			for (int iy = 0, ky = 0; iy < map_size.y; iy += pool_size.y, ky++)
			{
				int index = ix * map_size.y + iy;
				float max = map_output[index];
				for (int jx = ix; jx < map_size.x && jx < ix + pool_size.x; jx++)
				{
					for (int jy = iy; jy < map_size.y && jy < iy + pool_size.y; jy++)
					{
						if (map_output[jx * map_size.y + jy] > max)
						{
							index = jx * map_size.y + jy;
							max = map_output[index];
						}
					}
				}
				pool_output[kx * pool_size.y + ky] = max;
				pool_input_indexes[kx * pool_size.y + ky] = index;
			}
		}
	}

	@Override
	public void computeError(List<Backward> nextMaps)
	{
		for (Backward nextMap : nextMaps)
		{
			Size2D out_size = nextMap.getInputSize();
			Size2D out_weights_size = nextMap.getWeightsSize();
			float[] out_error = nextMap.getError();
			float[] out_weights = nextMap.getWeights();
			for (int xout = 0; xout < out_size.x; xout++)
			{
				for (int yout = 0; yout < out_size.y; yout++)
				{
					for (int xk = 0; xk < out_weights_size.x; xk++)
					{
						for (int yk = 0; yk < out_weights_size.y; yk++)
						{
							pool_error[(xk + xout) * pool_size.y + (yk + yout)] +=
								out_error[xout * out_size.y + yout] * out_weights[xk * out_weights_size.y + yk];
						}
					}
				}
			}
		}

		for (int xout = 0; xout < pool_size.x; xout++)
		{
			for (int yout = 0; yout < pool_size.y; yout++)
			{
				map_error[pool_input_indexes[xout * pool_size.y + yout]] =
					pool_error[xout * pool_size.y + yout] *
						activation.getDerivative(map_input[pool_input_indexes[xout * pool_size.y + yout]]);
			}
		}
	}

	@Override
	public float[] getOutput()
	{
		return pool_output;
	}

	@Override
	public Size2D getOutputSize()
	{
		return pool_size;
	}

	@Override
	public Size2D getInputSize()
	{
		return map_size;
	}
}
