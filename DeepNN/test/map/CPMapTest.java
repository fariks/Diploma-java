package map;

import map.stub.BackwardStub;
import map.stub.ForwardStub;
import org.junit.Assert;
import org.junit.Test;
import util.Print;
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
					-1, 0, 1, -1,
					0, 1, -1, 0,
					1, -1, 0, 1,
					-1, 0, 1, -1,
					0, 1, -1, 0,
				},
			new Size2D(2, 2),
			new float[]
				{
					1f, 1f,
					1f, 1f
				}
		);
		prevMaps.add(nextMap1);
		float[] weights = new float[]{
			1f, 1f,
			1f, 1f,
		};
		Size2D weights_size = new Size2D(2, 2);
		Size2D map_size = new Size2D(8, 8);
		Size2D pool_size = new Size2D(2, 2);
		float bias = 0.5f;
		FeatureMap map = new CPMap(
			weights,
			bias,
			weights_size,
			map_size,
			pool_size
		);
		map.computeError(prevMaps);
		float[] res = map.getOutput();
		float[] expected = new float[]{
			0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f,
			0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f,
			0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f,
			0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f,
			0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f,
			0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f,
			0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f,
			0.82f, 0.38f, 0.62f, 0.82f, 0.38f, 0.62f, 0.82f, 0.38f
		};
		Print.print2D(res, map.getOutputSize());
		Assert.assertArrayEquals(expected, res, 0.01f);
	}
}
