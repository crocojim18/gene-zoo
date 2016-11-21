package BodyParts;
import Patterns.*;
import Shapes.*;

public class Body
{
    Shape bodyShape;
    Pattern coat;
    
    public Body(Shape s, Pattern p)
    {
        bodyShape = s;
        coat = p;
    }
    public Body()
    {
        this(new Square(),new PatternSolid());
    }
    public String toString()
    {
        return "a "+bodyShape+" body that is "+coat;
    }
    public Shape getShape()
    {
        return bodyShape;
    }
    public Pattern getPatternType()
    {
        return coat.clone();
    }
}