package map;

import map.stub.ForwardStub;
import org.junit.Assert;
import org.junit.Test;
import util.Print;
import util.Size2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 07.12.14.
 */
public class CMapTest
{
	@Test
	public void testComputeOutput1Map() throws Exception
	{
		List<Forward> prevMaps = new ArrayList<Forward>();
		Size2D prevMapSize = new Size2D(10, 10);
		Forward prevMap1 = new ForwardStub(
			prevMapSize,
			new float[]
				{
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1
				}
		);
		prevMaps.add(prevMap1);
		float[] weights = new float[]{
			1f, 1f,
			1f, 1f,
		};
		Size2D weights_size = new Size2D(2, 2);
		Size2D map_size = new Size2D(8, 8);
		float bias = 0.5f;
		FeatureMap map = new CMap(
			weights,
			bias,
			weights_size,
			map_size
		);
		map.computeOutput(prevMaps);
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
		Assert.assertArrayEquals(res, expected, 0.01f);
	}

	@Test
	public void testComputeOutput2Map() throws Exception
	{
		List<Forward> prevMaps = new ArrayList<Forward>();
		Size2D prevMapSize = new Size2D(10, 10);
		Forward prevMap1 = new ForwardStub(
			prevMapSize,
			new float[]
				{
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1
				}
		);
		Forward prevMap2 = new ForwardStub(
			prevMapSize,
			new float[]
				{
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
					0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
					1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
					-1, 0, 1, -1, 0, 1, -1, 0, 1, -1
				}
		);
		prevMaps.add(prevMap1);
		prevMaps.add(prevMap2);
		float[] weights = new float[]{
			1f, 1f,
			1f, 1f,
		};
		Size2D weights_size = new Size2D(2, 2);
		Size2D map_size = new Size2D(8, 8);
		float bias = 0.5f;
		FeatureMap map = new CMap(
			weights,
			bias,
			weights_size,
			map_size
		);
		map.computeOutput(prevMaps);
		float[] res = map.getOutput();
		float[] expected = new float[]{
			0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
			0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f,
			0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f,
			0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
			0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f,
			0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f,
			0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
			0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f
		};
		Assert.assertArrayEquals(res, expected, 0.01f);
	}

	@Test
	public void testComputeError() throws Exception
	{

	}

	@Test
	public void testUpdateWeights() throws Exception
	{
        List<Forward> prevMaps = new ArrayList<Forward>();
        Size2D prevMapSize = new Size2D(10, 10);
        Forward prevMap1 = new ForwardStub(
                prevMapSize,
                new float[]
                        {
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1
                        }
        );
        Forward prevMap2 = new ForwardStub(
                prevMapSize,
                new float[]
                        {
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1,
                                0, 1, -1, 0, 1, -1, 0, 1, -1, 0,
                                1, -1, 0, 1, -1, 0, 1, -1, 0, 1,
                                -1, 0, 1, -1, 0, 1, -1, 0, 1, -1
                        }
        );
        prevMaps.add(prevMap1);
        prevMaps.add(prevMap2);
        float[] weights = new float[]{
                1f, 1f,
                1f, 1f,
        };
        Size2D weights_size = new Size2D(2, 2);
        Size2D map_size = new Size2D(8, 8);
        float bias = 0.5f;
        CMap map = new CMap(
                weights,
                bias,
                weights_size,
                map_size
        );
        map.setError(new float[]
                {
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f,

                });
        map.updateWeights(prevMaps);
        float[] res = map.getOutput();
        float[] expected = new float[]{
                0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
                0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f,
                0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f,
                0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
                0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f,
                0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f,
                0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f,
                0.92f, 0.18f, 0.62f, 0.92f, 0.18f, 0.62f, 0.92f, 0.18f
        };
        Print.print2D(map.getWeights(), weights_size);
        System.out.println(map.getBias());
        //Assert.assertArrayEquals(res, expected, 0.01f);
	}
}
