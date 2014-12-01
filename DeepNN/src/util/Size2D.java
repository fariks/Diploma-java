package util;

/**
 * @author: alsm0813
 * Date: 24.11.2014
 * Time: 5:37
 */
public class Size2D
{
    public int x;
    public int y;

    public Size2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int size()
    {
        return x * y;
    }
}
