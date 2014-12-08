package map;

import org.junit.Test;
import util.Print;
import util.Size2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Алексей on 07.12.14.
 */
public class CMapTest {
    @Test
    public void testComputeOutput1Map() throws Exception {
		List<Forward> prevMaps = new ArrayList<Forward>();
		Size2D prevMapSize = new Size2D(10, 10);
		Forward prevMap1 = new ForwardTest(
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
			});
		prevMaps.add(prevMap1);
		float[] weights = new float[]{
		   1f, 1f, 1f,
		   1f, 1f, 1f,
		   1f, 1f, 1f
		};
		Size2D weights_size = new Size2D(3, 3);
		Size2D map_size = new Size2D(8, 8);
		float bias = 0.5f;
		FeatureMap map = new CMap(
			weights,
			bias,
			weights_size,
			map_size
		);
		map.computeOutput(prevMaps);
		Print.print2D(map.getOutput(), map.getSize());
    }

    @Test
    public void testComputeError() throws Exception {

    }

    @Test
    public void testUpdateWeights() throws Exception {

    }
}
