package map;

import util.Size2D;

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

    public void computeError(float[] out_error, float[] out_weights)
    {
        for (int i = 0; i < pool_error.x; i++)
        {
            float sum = 0.f;
            for (int j = 0; j < out_sigma_size; j++)
            {
                sum += out_sigma[j] * w[j * in_sigma_size + i];
            }
            in_sigma[i] = sum;
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
