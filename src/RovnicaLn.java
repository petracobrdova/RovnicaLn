import java.util.InputMismatchException;
import java.util.Scanner;

public class RovnicaLn {
    private double b;
    private double c;

    public RovnicaLn(double bc)
    {
        b = c = bc;
    }

    public RovnicaLn(double mojeb, double mojec) {
        c = mojec;
        b = mojeb;
    }

    static double vratCislo(String text) //staticka metoda, nemusi byt volana
    {
        double cislo;
        Scanner sc = new Scanner(System.in);
        while (true) //nekonecny cyklus
        {
            try
            {
                System.out.println(text);
                cislo =  sc.nextDouble();
                return cislo;
            }
            catch (InputMismatchException e)
            {
                System.out.print("Nebolo zadane cislo!");
                sc.nextLine(); //vyprazdni buffer klavesnice
            }
        }
    }

    public RovnicaLn()
    {
        b=vratCislo("zadaj koaficient b");
        c=vratCislo("zadaj koeficient c");
    }

    public void printKoren()
    {
        double vysledok=getKoren();
        if(Double.isInfinite(vysledok))
        {
            System.out.println("vela rieseni");
        }
        else if(Double.isNaN(vysledok))
        {
            System.out.println("nema riesenie");
        }
        else
        {
            System.out.println("koren je:"+-c/b);
        }
    }

    public double getKoren()
    {
        if(b==0 && c == 0)
        {
            //System.out.println("vela rieseni");
            return Double.POSITIVE_INFINITY;
        }
        else if(b==0 && c!=0)
        {
            //System.out.println("nema riesenie");
            return Double.NaN;
        }
        else
        {
            //System.out.println("koren je:"+-c/b);
            return -c/b;
        }
    }

    public double getKoren1()
    {
        if(b==0)
        {
            if(c==0)
            {
                return Double.NaN;
            }
            return Double.POSITIVE_INFINITY;
        }
        return -c/b;
    }

    public double getB()
    {
        return b;
    }
    public void setB(double b)
    {
        this.b=b;
    }

    public double getC()
    {
        return c;
    }
    public void setC(double mojec)
    {
        c=mojec;
    }

    public String toString()
    {
        return String.format("%.2fx%+.2f = 0", b, c);
    }
}
