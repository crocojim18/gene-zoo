package Patterns;

public class PatternStriped extends Pattern
{
    Color color;
    Color stripeColor;

    public PatternStriped()
    {
        color = new Color();
        stripeColor = new Color();
    }

    public PatternStriped(Color c, Color c2)
    {
        color = c;
        stripeColor = c2;
    }

    public void setMainColor(Color c)
    {
        color = c;
    }

    public void setStripeColor(Color c)
    {
        stripeColor = c;
    }

    public Color getColor()
    {
        return color;
    }

    public Color getStripeColor()
    {
        return stripeColor;
    }

    public String toString()
    {
        return "#"+color+" with #"+stripeColor+" stripes";
    }

    public Pattern clone()
    {
        return new PatternStriped(color.clone(), stripeColor.clone());
    }

    public void setColors(Color[] j)
    {
        setMainColor(j[0]);
        setStripeColor(j[1]);
    }

    public Color[] getColors()
    {
        Color[] to = new Color[2];
        to[0] = color;
        to[1] = stripeColor;
        return to;
    }
}