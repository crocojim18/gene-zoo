package Exceptions;


public class NonValidColorException extends Exception
{
    public NonValidColorException()
    {
        super();
    }
    
    public NonValidColorException(String s)
    {
        super(s);
    }
}