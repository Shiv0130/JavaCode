import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner input = new Scanner(System.in);
        int choice;
        double bal = 0;
        int dep = 0;
        double withdrawal = 0;

        do {
            System.out.println("Welcome to Cash bank");
            System.out.println("Choose an option frm menu");
            System.out.println("1. Check account balance");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. Exit");

            choice = input.nextInt();

            switch(choice){
                case 1: System.out.println("The balance of the account is" + ":" + bal);
                    break;
                case 2: System.out.println("Enter amount to deposit" + ":" + dep);
                    dep = input.nextInt();
                    bal += dep;
                    break;
                case 3: System.out.println("Enter amount you wish to withdraw" + ":" + withdrawal);
                    withdrawal = input.nextDouble();
                    if(bal<withdrawal){
                        System.out.println("Insufficient funds");
                    }
                    else{
                        bal = bal - withdrawal;
                        System.out.println("Account balance after withdrawal is:" + ":" + bal);
                    }
                    break;
            }



        } while (choice != 4);
        input.close();

    }
}
