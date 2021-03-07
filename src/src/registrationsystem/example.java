package src.registrationsystem;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class example {

	public static void main(String[] args) {
		

        //Test 2		
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 was born on 1974-04-12 and is "+
                Period.between(LocalDate.of(1974, Month.APRIL, 12), LocalDate.now()).getYears()+"" +
        " years old"); //run program to see expected output
		
        //Test 3
        System.out.printf("%nExpected output: Student: Gail Storm, student number: 10001 is "
                +Period.between(LocalDate.of(1999, Month.DECEMBER, 31), LocalDate.now()).getYears()
                +" years old");//run program to see expected output
        
        
        

	}

}
