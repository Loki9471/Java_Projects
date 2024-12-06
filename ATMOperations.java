import java.util.Scanner;
class ATMOperations {
   double balance;
   String password="loki143";
   boolean checkPassword(String password) {
   	boolean checkPass=false;
   	if(this.password.equals(password)) {
   		checkPass=true;
   	}
   	return checkPass;
   }
   double checkBalance() {
   	return balance;
   }
   boolean withDrawAmount(double amount) {
   	boolean success=false;
   	if(balance>=amount) {
   		balance-=amount;
   		success=true;
   	}
     return success;
   }
   boolean depositeAmount(double amount) {
   	boolean success=false;
   	if(amount>0) {
   		balance+=amount;
   		success=true;
   	}
   	return success;
   }
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   ATMOperations ob1=new ATMOperations();
	   System.out.println("Enter the your Password:");
	   String pass=sc.nextLine();
	   if(ob1.checkPassword(pass)==false) {
		   System.out.println("Invalid Password... Access Denied");
		   return;
	   }
	   boolean exit=false;
	   while(!exit) {
		   System.out.println("1.Check Balance");
		   System.out.println("2.Deposite Amount");
		   System.out.println("3.Withdraw Amount");
		   System.out.println("4.Exit");
		   int op=sc.nextInt();
		   switch(op) {
		     case 1:System.out.println("Your Current Balance="+ob1.checkBalance());break;
		     case 2:System.out.println("Enter Amount to Deposite:");
		            double am1=sc.nextDouble();
		            if(ob1.depositeAmount(am1)) {
		            	System.out.println(am1+" is succussfully Deposited..");
		            }else {
		            	System.out.println(am1+" is Invalid Amount");
		            }
		            break;
		     case 3:System.out.println("Enter Amount to Withdraw:");
	                double am2=sc.nextDouble();
	                if(ob1.withDrawAmount(am2)) {
	            	  System.out.println(am2+" is succussfully Withdrawn..");
	                }else {
	            	  System.out.println("Insuffient Balance");
	                }
	                break;
		     case 4:exit=true;
		            System.out.println("Thank you for Using Our Services");  
		            break;
		   }
	   }
	}
}



