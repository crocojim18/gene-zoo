package Patterns;

public class PatternSolid extends Pattern
{
    Color color;

    public PatternSolid()
    {
        color = new Color();
    }

    public PatternSolid(Color c)
    {
        color = c;
    }

    public void setColor(Color c)
    {
        color = c;
    }

    public Color getColor()
    {
        return color;
    }

    public String toString()
    {
        return "solid #"+color;
    }

    public Pattern clone()
    {
        return new PatternSolid(color.clone());
    }

    public void setColors(Color[] j)
    {
        setColor(j[0]);
    }

    public Color[] getColors()
    {
        Color[] to = new Color[1];
        to[0] = color;
        return to;
    }
}