import java.util.Scanner;
import java.util.ArrayList;
import Patterns.*;
import BodyParts.*;
import Shapes.*;
public class Test
{
    public static void main(String[] args)
    {
        ArrayList<Creature> zoo = new ArrayList<Creature>();
        boolean kill = false;
        Scanner in = new Scanner(System.in);
        String command = "";
        System.out.println("Type \"help\" for handy instructions!");
        while(!kill)
        {
            command = in.nextLine();
            if(command.equalsIgnoreCase("help")) Directions.list();
            else if(command.equalsIgnoreCase("make")) zoo.add(make());
            else if(command.equalsIgnoreCase("breed"))breed(zoo);
            else if(command.equalsIgnoreCase("zoo")) printZoo(zoo);
            else if(command.equalsIgnoreCase("quit")) kill = true;
            else if(command.equalsIgnoreCase("rename")) rename(zoo);
        }
    }

    public static void rename(ArrayList<Creature> zoo)
    {
        System.out.println("For reference, here's your zoo:");
        Scanner in = new Scanner(System.in);
        printZoo(zoo);
        boolean kill1 = false;
        int num1 = -1;
        while(!kill1)
        {
            System.out.println("What is the number of the creature you want to rename?");
            num1 = in.nextInt();
            if(num1>=0&&num1<zoo.size()) kill1 = true;
        }
        in.nextLine();
        System.out.println("What should we rename this poor creature?");
        String onoma;
        onoma = in.nextLine();
        String old = zoo.get(num1).name;
        zoo.get(num1).setName(onoma);
        System.out.println(old+" has been renamed "+onoma+"!");
    }

    public static void printZoo(ArrayList<Creature> zoo)
    {
        for(int i = 0;i<zoo.size();i++)
        {
            System.out.println(i+": "+zoo.get(i));
        }
    }

    public static void breed(ArrayList<Creature> zoo)
    {
        System.out.println("For reference, here's your zoo:");
        Scanner in = new Scanner(System.in);
        printZoo(zoo);
        boolean kill1 = false;
        int num1 = -1;
        while(!kill1)
        {
            System.out.println("What is the number of the first creature you want to breed?");
            num1 = in.nextInt();
            if(num1>=0&&num1<zoo.size()) kill1 = true;
        }
        boolean kill2 = false;
        int num2 = -1;
        while(!kill2)
        {
            System.out.println("What is the number of the second creature you want to breed?");
            num2 = in.nextInt();
            if(num2>=0&&num2<zoo.size()) kill2 = true;
        }
        Creature spawn = zoo.get(num1).breed(zoo.get(num2));
        in.nextLine();
        System.out.println("What should we name this poor creature?");
        String onoma;
        onoma = in.nextLine();
        spawn.setName(onoma);
        zoo.add(spawn);
        System.out.println(spawn);
        System.out.println(onoma+" has been added to your zoo!");
    }

    public static Creature make()
    {
        Scanner in = new Scanner(System.in);
        boolean kill1 = false;
        String body;
        Shape bod = new Circle();
        while(!kill1)
        {
            System.out.println("What kind of body should this thing have?");
            System.out.println("(Please respond using a single letter)");
            System.out.println("A. Circle");
            System.out.println("B. Triangle");
            System.out.println("C. Square");
            body = in.nextLine();
            if(body.equalsIgnoreCase("A")){bod = new Circle(); kill1 = true;}
            else if(body.equalsIgnoreCase("B")){bod = new Triangle(); kill1 = true;}
            else if(body.equalsIgnoreCase("C")){bod = new Square(); kill1 = true;}
        }
        boolean kill2 = false;
        String pattern;
        Pattern pat = new PatternSolid();
        while(!kill2)
        {
            System.out.println("What kind of pattern should its coat be?");
            System.out.println("(Please respond using a single letter)");
            System.out.println("A. A solid color");
            System.out.println("B. Striped");
            System.out.println("C. Spotted");
            pattern = in.nextLine();
            if(pattern.equalsIgnoreCase("A")){pat = new PatternSolid(); kill2 = true;}
            else if(pattern.equalsIgnoreCase("B")){pat = new PatternStriped(); kill2 = true;}
            else if(pattern.equalsIgnoreCase("C")){pat = new PatternSpotted(); kill2 = true;}
        }
        boolean kill3 = false;
        String culur = "";
        Color cul = new Color();
        while(!kill3)
        {
            System.out.println("What color should its coat be?");
            System.out.println("(Please respond using an RGB color in the style of #xxxxxx)");
            culur = in.nextLine();
            if(validColor(culur)) kill3 = true;
        }
        cul.setRed(Integer.valueOf(culur.substring(1,3),16));
        cul.setGreen(Integer.valueOf(culur.substring(3,5),16));
        cul.setBlue(Integer.valueOf(culur.substring(5,7),16));
        Color[] arr = new Color[2];
        arr[0] = cul;
        if(pat instanceof PatternStriped || pat instanceof PatternSpotted)
        {
            boolean kill4 = false;
            String temp;
            Color cul2 = new Color();
            while(!kill4)
            {
                if(pat instanceof PatternStriped) System.out.println("What color should its stripes be?");
                if(pat instanceof PatternSpotted) System.out.println("What color should its spots be?");
                System.out.println("(Please respond using an RGB color in the style of #xxxxxx)");
                culur = in.nextLine();
                if(validColor(culur)) kill4 = true;
            }
            cul2.setRed(Integer.valueOf(culur.substring(1,3),16));
            cul2.setGreen(Integer.valueOf(culur.substring(3,5),16));
            cul2.setBlue(Integer.valueOf(culur.substring(5,7),16));
            arr[1] = cul2;
        }
        pat.setColors(arr);
        boolean kill5 = false;
        ArrayList<BodyPart> bodiepartts = new ArrayList<BodyPart>();
        String parts;
        while(!kill5)
        {
            System.out.println("What other body parts should it have?");
            System.out.println("(Please respond using a single letter)");
            System.out.println("A. An eye");
            System.out.println("B. A mouth");
            System.out.println("C. That's enough body parts for now!");
            parts = in.nextLine();
            if(parts.equalsIgnoreCase("A"))
            {
                boolean kill6 = false;
                String clr = "";
                Color cooler = new Color();
                while(!kill6)
                {
                    System.out.println("What color should this eye be?");
                    System.out.println("(Please respond using an RGB color in the style of #xxxxxx)");
                    clr = in.nextLine();
                    if(validColor(clr)) kill6 = true;
                }
                cooler.setRed(Integer.valueOf(clr.substring(1,3),16));
                cooler.setGreen(Integer.valueOf(clr.substring(3,5),16));
                cooler.setBlue(Integer.valueOf(clr.substring(5,7),16));
                Eye pEye = new Eye(cooler);
                bodiepartts.add(pEye);
            }
            else if(parts.equalsIgnoreCase("B"))
            {
                boolean kill6 = false;
                String sizere;
                Mouth pMouth = new Mouth();
                while(!kill6)
                {
                    System.out.println("What size mouth should it have?");
                    System.out.println("(Please respond using a single letter)");
                    System.out.println("A. Big");
                    System.out.println("B. Small");
                    pattern = in.nextLine();
                    if(pattern.equalsIgnoreCase("A")){pMouth = new Mouth(true);kill6=true;}
                    else if(pattern.equalsIgnoreCase("B")){pMouth = new Mouth(false);kill6=true;}
                }
                bodiepartts.add(pMouth);
            }
            else if(parts.equalsIgnoreCase("C")){kill5 = true;}
        }
        System.out.println("And, lastly, what should this poor creature be named?");
        String onoma = in.nextLine();
        Creature thisGuy = new Creature(new Body(bod, pat), onoma);
        for(int yyyyy = 0;yyyyy<bodiepartts.size();yyyyy++)
        {
            thisGuy.addBodyPart(bodiepartts.get(yyyyy));
        }
        return thisGuy;
    }

    public static boolean validColor(String c)
    {
        if(c.length()!=7) return false;
        if(c.charAt(0)!='#') return false;
        for(int i = 1;i<7;i++)
        {
            if(!(c.charAt(i)=='1'||c.charAt(i)=='2'||c.charAt(i)=='3'
                ||c.charAt(i)=='4'||c.charAt(i)=='5'||c.charAt(i)=='6'
                ||c.charAt(i)=='7'||c.charAt(i)=='8'||c.charAt(i)=='9'
                ||c.charAt(i)=='0'||c.substring(i,i+1).equalsIgnoreCase("a")||c.substring(i,i+1).equalsIgnoreCase("b")
                ||c.substring(i,i+1).equalsIgnoreCase("c")||c.substring(i,i+1).equalsIgnoreCase("d")
                ||c.substring(i,i+1).equalsIgnoreCase("e")||c.substring(i,i+1).equalsIgnoreCase("f"))) return false;
        }
        return true;
    }
}