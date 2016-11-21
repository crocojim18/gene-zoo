package Patterns;

public class PatternSpotted extends Pattern
{
    Color color;
    Color spotColor;

    public PatternSpotted()
    {
        color = new Color();
        spotColor = new Color();
    }

    public PatternSpotted(Color c, Color c2)
    {
        color = c;
        spotColor = c2;
    }

    public void setMainColor(Color c)
    {
        color = c;
    }

    public void setSpotColor(Color c)
    {
        spotColor = c;
    }

    public Color getColor()
    {
        return color;
    }

    public Color getSpotColor()
    {
        return spotColor;
    }

    public String toString()
    {
        return "#"+color+" with #"+spotColor+" spots";
    }

    public Pattern clone()
    {
        return new PatternSpotted(color.clone(), spotColor.clone());
    }
    
    public void setColors(Color[] j)
    {
        setMainColor(j[0]);
        setSpotColor(j[1]);
    }
    
    public Color[] getColors()
    {
        Color[] to = new Color[2];
        to[0] = color;
        to[1] = spotColor;
        return to;
    }
}