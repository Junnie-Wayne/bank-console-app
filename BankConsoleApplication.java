import java.util.Scanner;
import java.math.BigDecimal;

public class BankConsoleApplication {
    public static BigDecimal account = new BigDecimal("0.00");
    public static int selection;
 
    public static String checkBalance() {
         String formattedAccount = String.format("%.2f", account);
         return formattedAccount;
    }
    public static void mainMenu() {
         System.out.println();

         // An opening to the bank console application
         System.out.println("Welcome to the Bank Console Application.\n");
         System.out.println("What do you want to do today?:\n ");
         
         // Available features of the banking system and selection of option
         System.out.print("1. Make Deposit.\n2. Make Withdrawal.\n3. Check Balance.\n4. Exit\n\n");
         System.out.print("Enter the option: ");

         // The Scanner class to help with the input of the particular option
         Scanner option = new Scanner(System.in);
         selection = option.nextInt();
    }

    public static void main(String[] args) {
        // A call out to the main menu method to commence with the program displaying the features
         mainMenu();

        // A while loop the handle the repetitive nature of the main menu
        while(selection != 4) {
             System.out.println();
 
             // Conditional statements to handle option selection
         if(selection == 1) {
             System.out.print("Enter the amount to deposit: ");

             // The Scanner class to help with the input of the amount
             Scanner amount = new Scanner(System.in);
             BigDecimal deposit = new BigDecimal(amount.nextDouble());
                
             // This is to add the deposit to the current account
             account = account.add(deposit);

             System.out.println();

             // To declare and initialize a formatted deposit String variable to work around the two decimal place of the currency
             String formattedDeposit = String.format("%.2f", deposit);

             // A printout statement as a message for the deposit and the current balance
             System.out.print("You have deposited GHS " + formattedDeposit + "\nYour current account balance is GHS " + checkBalance());

             System.out.println();

             // A call out to the main menu method to take the user back to the main menu
             mainMenu();
         }
        else if(selection == 2) {
             System.out.print("Enter the amount to withdraw: ");

             // The Scanner class to help with the input of the amount to withdraw from the account
             Scanner input = new Scanner(System.in);
             BigDecimal withDrawal = new BigDecimal(input.nextDouble());

             System.out.println();

            // A conditional statement to check if there is an available amount as such for withdrawal
             if(withDrawal.compareTo(account) <= 0) {
                   account = account.subtract(withDrawal);

                   // To declare and initialize a formatted withdrawal String variable to work around the two decimal place of the currency
                   String formattedWithDrawal = String.format("%.2f", withDrawal);              
  
                   System.out.println("You have withdrawn GHS " + formattedWithDrawal + ". Your account balance is GHS " + checkBalance());
             }
             else {
                   // A print out statement indicating that the user does not have enough balance
                   System.out.println("Sorry. You do not have enough balance to complete this withdrawal process.");
             }

            System.out.println();

            // A call out to the main menu method to take the user back to the main menu
            mainMenu();
        }
       else if(selection == 3) {  
            // A printout statement showing the account balance
            System.out.println("Your current account balance is GHS " + checkBalance());

            System.out.println();
 
            // A call out to the main menu method to take the user back to the main menu
            mainMenu();            
       }
       else {
            // A print out statement indicating the user entered a wrong option
            System.out.println("Wrong option! Try again.");
            
            System.out.println();  
      
            // A call out to the main menu to allow the user to enter a correct option
            mainMenu();
       }
    }
            // A printout statement displaying the end of the program and a farewell message.
            System.out.println("Thank you for using our Bank Console Application. Have a great day!");
   }
   
}