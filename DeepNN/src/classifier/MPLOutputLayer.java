package classifier;

/**
 * Created by Алексей on 28.12.14.
 */
public class MPLOutputLayer extends MPLLayer {

    private int[] labels;

    public void computeError(float[] out_error) {
        for (int i = 0; i < out_error.length; i++)
        {
            error[i] = (labels[i] - output[i]) * activation.getDerivative(input[i]);
        }
    }
}
