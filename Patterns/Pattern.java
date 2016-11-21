package Patterns;

public abstract class Pattern
{
    public abstract String toString();
    public abstract Pattern clone();
    public abstract void setColors(Color[] j);
    public abstract Color[] getColors();
}
