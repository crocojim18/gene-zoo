package BodyParts;
import Patterns.Color;

public class Eye extends BodyPart
{
    Color eyeColor;
    
    public Eye(Color c)
    {
        eyeColor = c;
    }
    public Eye()
    {
        this(new Color());
    }
    public String toString()
    {
        return "an eye that is #"+eyeColor;
    }
    public Color getColor()
    {
        return eyeColor;
    }
    public BodyPart deepClone()
    {
        return new Eye(eyeColor.clone());
    }
}