import java.util.*;

/**
 * A simulator for a Hanoi Tower that receives as a parameter how many pins the user wants,
 * and shows the process as well the result of the transfer.
 * 
 * @author Nícolas J. Pierina 
 * @version .1.0
 */
public class TorreHanoi
{
    //Pins variable
    int pinos;
    
    //Lists that simulate the towers A, B and C
    ArrayList A;
    ArrayList B;
    ArrayList C;

    /**
     * Constructor method, create the lists, and fill list A with the number of pins
     * 
     * @param   Quantity of pins
     * @return  ---
     */
    public TorreHanoi(int quantidadePinos)
    {
        pinos = quantidadePinos;
        
        A = new ArrayList();
        A.add("A");
        B = new ArrayList();
        B.add("B");
        C = new ArrayList();
        C.add("C");
        
        //Calls the fillA() method to add the pins to list A
        fillA();
    }

    /**
     * Main method of this class, calls the hanoi method to transfer the pins to the correct tower
     * 
     * @param      ---
     * @return     --- 
     */
    public void main()
    {
        //If there is more than 1 pin, calls the hanoi method
        if(pinos>1)
        {
            hanoi(pinos, A, C, B);
        }
        
        //Otherwise, just transfer 1 pin from tower A to C
        else
        {
            transferePinos(A, C);
        }
    }
    
    /**
     * Fill list A with the number of pins that where put by the user
     * 
     * @param      ---
     * @return     --- 
     */
    private void fillA()
    {
        int i;
        for(i=pinos; i>0; i--)
        {
            A.add(i);
        }
    }
    
    /**
     * A recursive method that use the transferePinos method to move the pins
     * 
     * @param      Quantity of pins, Firs list, Third list, Second list
     * @return     --- 
     */
    private void hanoi(int quantidadePinos, ArrayList first, ArrayList third, ArrayList second)
    {
        //Stop the method as soon as the quantity of pins is 0
        if(quantidadePinos > 0)
        {
            hanoi(quantidadePinos - 1, first, second, third);
            transferePinos(first, third);
            hanoi(quantidadePinos - 1, second, third, first);
        }
    }
    
    /**
     * Method to transfer a pin from a tower to another
     * 
     * @param       Origin list, Destiny list
     * @return      Also prints wich pin is going to wich list
     */
    private void transferePinos(ArrayList first, ArrayList third)
    {
        //Print the pin number, and where is it going
        System.out.println(first.get(first.size()-1) + "->" + third);
        
        //Add the last pin from the first list, to the second list
        third.add(first.get(first.size()-1));
        
        //Remove the last pin from the first list
        first.remove(first.size()-1);
    }
    
    /**
     * Method that shows how many pins are in tower A
     * 
     * @param       ---
     * @return      How many pins are in tower A
     */
    public void getA()
    {
        int i;
        
        //If there is at least one pin in the tower
        if(A.size()>1)
        {
            for(i=0; i<A.size(); i++)
            {
            System.out.println(A.get(i));
            }  
        }
        
        //If there is none
        else
        {
            System.out.println("Sem pinos da torre A");
        }
    }
    
    /**
     * Method that shows how many pins are in tower B
     * 
     * @param       ---
     * @return      How many pins are in tower B
     */
    public void getB()
    {
        int i;
        
        //If there is at least one pin in the tower
        if(B.size()>1)
        {
            for(i=0; i<B.size(); i++)
            {
            System.out.println(B.get(i));
            }  
        }
        
        //If there is none
        else
        {
            System.out.println("Sem pinos da torre B");
        }
    }
    
    /**
     * Method that shows how many pins are in tower C
     * 
     * @param       ---
     * @return      How many pins are in tower C
     */
    public void getC()
    {
        int i;
        
        //If there is at least one pin in the tower
        if(C.size()>1)
        {
            for(i=0; i<C.size(); i++)
            {
            System.out.println(C.get(i));
            }  
        }
        
        //If there is none
        else
        {
            System.out.println("Sem pinos da torre C");
        }
    }
}
