package classifier;

import activation.Activation;

import java.util.List;

/**
 * Created by Алексей on 28.12.14.
 */
public class MPLLayer {

    protected float[] output;

    protected float[] input;

    protected float[] error;

    protected List<float[]> weights;

    protected float[] bias;

    protected int layerSize;

    protected float LEARNING_RATE = 0.05f;

    protected Activation activation;

    public void computeOutput(List<float[]> prevMaps)
    {
        for (int i = 0; i < layerSize; i++)
        {
            float sum = 0.f;
            for (int k = 0; k < prevMaps.size(); k++)
            {
                for (int j = 0; j < prevMaps.get(k).length; j++)
                {
                    sum += prevMaps.get(k)[j] * weights.get(k)[i * prevMaps.get(k).length + j];
                }
            }
            sum += bias[i];
            input[i] = sum;
            output[i] = activation.get(sum);
        }
    }

    public void computeError(float[] out_error, float out_weights[])
    {
        for (int i = 0; i < layerSize; i++)
        {
            float sum = 0.f;
            for (int j = 0; j < out_error.length; j++)
            {
                sum += out_error[j] * out_weights[j * layerSize + i];
            }
            error[i] = sum * activation.getDerivative(input[i]);
        }
    }

    public void updateWeights(List<float[]> prevMaps)
    {
        for (int i = 0; i < layerSize; i++)
        {
            bias[i] += LEARNING_RATE * error[i];
        }
        for (int i = 0; i < layerSize; i++)
        {
            for (int k = 0; k < prevMaps.size(); k++)
            {
                for (int j = 0; j < prevMaps.get(k).length; j++)
                {
                    weights.get(k)[i * prevMaps.get(k).length + j] += LEARNING_RATE * error[i] * prevMaps.get(k)[j];
                }
            }
        }
    }
}
