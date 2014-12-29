package map;

import util.Size2D;

import java.util.Arrays;
import java.util.List;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:16
 */
public class Sink extends CPMap
{
    public Sink(float[] weights, float bias, Size2D weights_size, Size2D map_size, Size2D pool_window_size) {
        super(weights, bias, weights_size, map_size, pool_window_size);
    }

    public void computeError(float[] out_error, List<float[]> out_weights)
    {
        Arrays.fill(pool_error, 0);
        for (int i = 0; i < out_error.length; i++)
        {
            for (int iw = 0; iw < pool_size.x; iw++)
            {
                for (int jw = 0; jw < pool_size.y; jw++)
                {
                    pool_error[iw * pool_size.y + jw] += out_error[i] * out_weights.get(i)[iw * pool_size.y + jw];
                }
            }
        }

        //todo
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
}
