

import java.util.Random;
import java.util.Scanner;

 class Password {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the desired password length:");
		int length=sc.nextInt();
		System.out.println("Include Number?(Yes/No)");
		boolean isIncludedNumber=sc.next().equals("yes");
		System.out.println("Include symbols or not?");
		boolean isIncludeSymbols=sc.next().equalsIgnoreCase("yes");
		System.out.println("Include Uppercase or Not");
		boolean isIncludeUppercase=sc.next().equalsIgnoreCase("yes");
		System.out.println("Generated password="+generatePassword(length,isIncludedNumber,isIncludeSymbols,isIncludeUppercase));
	}

	private static String generatePassword(int length, boolean isIncludedNumber, boolean isIncludeSymbols,
			boolean isIncludeUppercase) {
		String numbers=isIncludedNumber?"0123456789":"";
		String upperCase=isIncludeUppercase?"ABCDEFGHIJKLMNOPQRSTUVWXYZ":"";
		String lowerCase="abcdefghijklmnopqrstuvwxyz";
		String symbols=isIncludeSymbols?"@#$%^&*":"";
		String allChar=numbers+lowerCase+upperCase+symbols;
		Random r=new Random();
		StringBuffer sbr=new StringBuffer();
		for(int i=0;i<length;i++) {
			sbr.append(allChar.charAt(r.nextInt(allChar.length())));
		}
		return sbr.toString();
	}


}
