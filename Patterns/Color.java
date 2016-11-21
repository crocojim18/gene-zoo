package Patterns;

public class Color
{
    int red;
    int green;
    int blue;

    public Color(int r, int g, int b)
    {
        if(r>255) r = 255;
        if(r<0) r = 0;
        if(g>255)g = 255;
        if(g<0) g=0;
        if(b>255) b = 255;
        if(r<0) r = 0;
        red = r;
        green = g;
        blue = b;
    }

    public Color()
    {
        this(0,0,0);
    }

    public Color(int[] r)
    {
        this(r[0],r[1],r[2]);
    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    public void setRed(int r)
    {
        red = r;
    }

    public void setGreen(int g)
    {
        green = g;
    }

    public void setBlue(int b)
    {
        blue = b;
    }
    
    public String toString()
    {
        String c = Integer.toHexString(red);
        String v = Integer.toHexString(green);
        String s = Integer.toHexString(blue);
        if(c.length()==1) c = "0"+c;
        if(v.length()==1) v = "0"+v;
        if(s.length()==1) s = "0"+s;
        return c+v+s;
    }
    
    public static Color average(Color c1, Color c2)
    {
        int teR = (c1.red+c2.red)/2;
        int teG = (c1.green+c2.green)/2;
        int teB = (c1.blue+c2.blue)/2;
        return new Color(teR, teG, teB);
    }
    
    public Color clone()
    {
        return new Color(red, green, blue);
    }
}