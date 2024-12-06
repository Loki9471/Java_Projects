package com.PracticeMode;

import java.util.Scanner;

public class Units {

	
	public static void main(String[] args) {
		   Scanner sc=new Scanner(System.in);
		   boolean isExit=false;
		   while(!isExit) {
			   System.out.println("1.meter to kilometers");
			   System.out.println("2.gram to kilograms");
			   System.out.println("3.celsius to fohrenheit");
			   System.out.println("4.Exit");
		   
		   
		   int op=sc.nextInt();
		   switch(op) {
		   case 1:System.out.println("enter your meters");
		       double meters=sc.nextDouble();
		       double kilometers=meters/1000;
		       System.out.println(meters+"meters="+kilometers+"kilometers");
			   break;
		   case 2:System.out.println("enter your grams");
		      double grams=sc.nextDouble();
		      double kilograms=grams/1000;
		      System.out.println(grams+"grams="+kilograms+"kilograms");
			   break;
		   case 3:System.out.println("enter you celsius");
		     double celsius=sc.nextDouble();
		     double fahrenheit = (celsius * 9/5) + 32;
             System.out.println(celsius + "°C = " + fahrenheit + "°F");
		     
			   break;
		   case 4: isExit=true;
		   break;
		   }
		   } 
		   

	}

}
