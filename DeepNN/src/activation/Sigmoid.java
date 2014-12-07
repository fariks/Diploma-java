package activation;

/**
 * Created by Алексей on 07.12.14.
 */
public class Sigmoid implements Activation {

    @Override
    public float get(float x) {
        return (float) (1.f / (1.f + Math.exp(-x)));
    }

    @Override
    public float getDerivative(float x) {
        float tmp = get(x);
        return tmp * (1 - tmp);
    }
}
