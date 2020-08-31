
import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
public class CellListUtilization
{
    public static void main(String[] args)
    {
        long serialNumber;
        CellList c1=new CellList();
        CellList c2=new CellList();
        Scanner kb= new Scanner (System.in);
        Scanner sc;
        PrintWriter pw;
        try
        {
            kb= new Scanner(System.in);
            sc = new Scanner(new FileInputStream("Cell_Info.txt"));
            while (sc.hasNext())
            {
                long sn= sc.nextLong();
                String brand= sc.next();
                double price=sc.nextDouble();
                int year =sc.nextInt();
                if (!c1.contains(sn))
                c1.addToStart(new CellPhone(sn,price,year,brand));
            }
            c1.showContents();
            System.out.println("Insert a serial number ");
            serialNumber=kb.nextLong();
            c1.find(serialNumber);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file either doesn't exist or is corrupted.");
        }

    }
}