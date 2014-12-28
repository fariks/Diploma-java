package map;

import map.stub.BackwardStub;
import org.junit.Assert;
import org.junit.Test;
import util.Size2D;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: alsm0813
 * Date: 11.12.2014
 * Time: 11:32
 */
public class CPMapTest
{
	@Test
	public void testComputeError1Map() throws Exception
	{
		List<Backward> prevMaps = new ArrayList<Backward>();
		Backward nextMap1 = new BackwardStub(
			new Size2D(4, 4),
			new float[]
				{
					-0.1f, 0.2f, 0.3f, -0.4f,
                    0.2f, 0.3f, -0.4f, -0.1f,
                    0.3f, -0.4f, -0.1f, 0.2f,
                    -0.4f, -0.1f, 0.2f, 0.3f,
				},
			new Size2D(2, 2),
			new float[]
				{
					0.7f, 0.6f,
					0.4f, 0.3f
				}
		);
		prevMaps.add(nextMap1);
		float[] weights = new float[]{
			1f, 1f,
			1f, 1f,
		};
		Size2D weights_size = new Size2D(2, 2);
		Size2D map_size = new Size2D(10, 10);
		Size2D pool_size = new Size2D(2, 2);
		float bias = 0.5f;
        CPMap map = new CPMap(
			weights,
			bias,
			weights_size,
			map_size,
			pool_size
		);
        map.setPool_input_indexes(new int[]
                {
                        1, 12, 4, 17, 8,
                        21, 32, 24, 37, 28,
                        41, 52, 44, 57, 48,
                        61, 72, 64, 77, 68,
                        81, 92, 84, 97, 88,
                });
		map.computeError(prevMaps);
		float[] poolError = map.getPool_error();
		float[] error = map.getError();
        float[] expectedPoolError = new float[]{
            -0.07f, 0.08f, 0.33f, -0.10f, -0.24f,
            0.10f, 0.38f, 0.08f, -0.38f, -0.18f,
            0.29f, 0.08f, -0.38f, -0.08f, 0.09f,
            -0.16f, -0.38f, -0.08f, 0.38f, 0.24f,
            -0.16f, -0.16f, 0.05f, 0.18f, 0.09f,
        };
		float[] expectedError = new float[]{
            0.00f, -0.02f, 0.00f, 0.00f, 0.08f, 0.00f, 0.00f, 0.00f, -0.06f, 0.00f,
            0.00f, 0.00f, 0.02f, 0.00f, 0.00f, 0.00f, 0.00f, -0.02f, 0.00f, 0.00f,
            0.00f, 0.02f, 0.00f, 0.00f, 0.02f, 0.00f, 0.00f, 0.00f, -0.05f, 0.00f,
            0.00f, 0.00f, 0.10f, 0.00f, 0.00f, 0.00f, 0.00f, -0.09f, 0.00f, 0.00f,
            0.00f, 0.07f, 0.00f, 0.00f, -0.09f, 0.00f, 0.00f, 0.00f, 0.02f, 0.00f,
            0.00f, 0.00f, 0.02f, 0.00f, 0.00f, 0.00f, 0.00f, -0.02f, 0.00f, 0.00f,
            0.00f, -0.04f, 0.00f, 0.00f, -0.02f, 0.00f, 0.00f, 0.00f, 0.06f, 0.00f,
            0.00f, 0.00f, -0.09f, 0.00f, 0.00f, 0.00f, 0.00f, 0.10f, 0.00f, 0.00f,
            0.00f, -0.04f, 0.00f, 0.00f, 0.01f, 0.00f, 0.00f, 0.00f, 0.02f, 0.00f,
            0.00f, 0.00f, -0.04f, 0.00f, 0.00f, 0.00f, 0.00f, 0.05f, 0.00f, 0.00f,
		};
		Assert.assertArrayEquals(expectedPoolError, poolError, 0.01f);
		Assert.assertArrayEquals(expectedError, error, 0.01f);
	}
}
