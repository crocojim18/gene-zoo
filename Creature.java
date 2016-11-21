import BodyParts.*;
import Patterns.*;
import Shapes.*;
import java.util.ArrayList;
public class Creature
{
    Body b;
    String name;
    ArrayList<BodyPart> parts;
    
    public Creature(String n)
    {
        this(new Body(), n);
    }
    public Creature(Body bo, String n)
    {
        b = bo;
        name = n;
        parts = new ArrayList<BodyPart>();
    }
    public void setName(String s)
    {
        name = s;
    }
    public void addBodyPart(BodyPart bp)
    {
        parts.add(bp);
    }
    public String toString()
    {
        String toRet = ""+name+" has "+b;
        for(int i = 0;i<parts.size();i++)
        {
            if(i==parts.size()-1) toRet += ", and ";
            else toRet += ", ";
            toRet += parts.get(i);
        }
        toRet += ".";
        return toRet;
    }
    public Creature breed(Creature other)
    {
        Shape a;
        if(((int)(Math.random()*2))==0) a = b.getShape();
        else a = other.getShape();
        Pattern p;
        if(((int)(Math.random()*2))==0) p = b.getPatternType();
        else p = other.b.getPatternType();
        Color[] toPass = new Color[p.getColors().length];
        int it1 = 0;
        int it2 = 0;
        Color[] one = b.getPatternType().getColors();
        Color[] two = other.b.getPatternType().getColors();
        for(int i = 0;i<p.getColors().length;i++)
        {
            toPass[i] = Color.average(one[it1], two[it2]);
            if(it1==one.length-1) it1 = 0;
            else it1++;
            if(it2==two.length-1) it2 = 0;
            else it2++;
        }
        p.setColors(toPass);
        Creature toRet = new Creature(new Body(a, p), "Unnamed");
        boolean pixt;
        for(int i = 0;i<parts.size();i++)
        {
            pixt = ((int)(Math.random()*2))==0;
            if(pixt) toRet.addBodyPart(parts.get(i).deepClone());
        }
        for(int i = 0;i<other.parts.size();i++)
        {
            pixt = ((int)(Math.random()*2))==0;
            if(pixt) toRet.addBodyPart(other.parts.get(i).deepClone());
        }
        return toRet;
    }
    public Shape getShape()
    {
        return b.getShape();
    }
}