package BodyParts;

public class Mouth extends BodyPart
{
    boolean isBig;
    
    public Mouth(boolean isBig1)
    {
        isBig = isBig1;
    }
    public Mouth()
    {
        this(true);
    }
    public String toString()
    {
        return "a "+getSize()+" mouth";
    }
    public String getSize()
    {
        String temp = "small";
        if(isBig) temp = "big";
        return temp;
    }
    public BodyPart deepClone()
    {
        return new Mouth(isBig);
    }
}