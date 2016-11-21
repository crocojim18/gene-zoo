import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class Directions
{
    public static void list()
    {
        try
        {
            Class p = Class.forName("Directions");
            Scanner input = new Scanner(p.getResourceAsStream("help.txt"));
            String s;
            while(input.hasNext())
            {
                s = input.nextLine();
                System.out.println(s);
            }
        }
        catch(NullPointerException a)
        {
            System.out.println("\"help.txt\" not found!");
        }
        catch(ClassNotFoundException b)
        {
            System.out.println("If you see this message, I don't know what's happening.");
        }
    }
}