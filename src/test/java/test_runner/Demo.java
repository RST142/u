package test_runner;

import org.testng.annotations.Test;

public class Demo {

    abstract class Bank{    
    abstract int getRateOfInterest();    
    }    
    class SBI extends Bank{    
    int getRateOfInterest(){return 7;}    
    }    
    class PNB extends Bank{    
    int getRateOfInterest(){return 8;}    
    }    
       
    @Test
    class TestBank{    {
    Bank b;  
    b=new SBI();  
    System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
    b=new PNB();  
    System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
    }
}
}