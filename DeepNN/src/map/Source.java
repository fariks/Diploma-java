package map;

import util.Size2D;

/**
 * @author: alsm0813
 * Date: 01.12.2014
 * Time: 11:16
 */
public class Source implements Forward
{
    private float[] output;

    private Size2D size;

    public Source(float[] output, Size2D size) {
        this.output = output;
        this.size = size;
    }

    @Override
	public float[] getOutput()
	{
		return output;
	}

	@Override
	public Size2D getOutputSize()
	{
		return size;
	}
}
