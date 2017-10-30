package introduction;

import java.util.Scanner;
import java.util.Random;

public class Main {
    Random r = new Random();
    int Low = 10;
    int High = 100;
    int atempts = 3;

    private double currentBal = r.nextInt(High - Low) + Low;
    Scanner input = new Scanner(System.in);

    public void checkAccess() {
        int pass = 1111;
        System.out.print("ST BANK ATM (demo pin code '1111')\n");
        System.out.println("Pin attempts left " + atempts + "\n");
        System.out.println("Enter the pin code:\n");

        if (atempts > 0) {
            int pin = input.nextInt();
            if (pass == pin) {
                System.out.println("\t-- Correct pin:\n");
                atmMenu();
            } else {
                atempts--;
                System.out.println("\t-- Wrong Pin \n");
                System.out.println("\t--Pin attempts left\n" + atempts);
                checkAccess();
            }
        } else {
            System.out.println("\t-- Your card is blocked. \n");
            System.exit(0);
        }
    }

    public void atmMenu() {

        int selection;
        System.out.print("ST BANK ATM (demo pin code '1111'");
        System.out.println("Select required action\n");
        System.out.println("---------------------------");
        System.out.println("| (1)      Actual Balance |");
        System.out.println("| (2)     Withdrawal Cash |");
        System.out.println("| (3)        Make Deposit |");
        System.out.println("| (4)                Exit |");
        System.out.println("---------------------------");

        selection = input.nextInt();
        switch (selection) {
            case 1:
                viewBalance();
                break;
            case 2:
                withdrawFunds();
                break;
            case 3:
                depositFunds();
                break;
            case 4:
                System.out.println("Thank you for using ATM! \n Goodbye! \n");
        }
    }

    public void viewBalance() {
        int selection1;
        System.out.println("\t-- Your Current Balance is:$ " + currentBal);
        System.out.println("Press (1) to go to the Main Menu \n Press another key to exit \n");
        selection1 = input.nextInt();
        switch (selection1) {
            case 1:
                atmMenu();
                break;
        }
    }

    public void viewBalanceNoConfirm() {

        System.out.println("\t-- Your Current Balance is:$ " + currentBal);

    }

    public void withdrawFunds() {
        int summToWithdraw;
        System.out.println("Amount to withdraw: ");
        System.out.println("-----------------------------");
        System.out.println("[1] - 5              10 - [2]");
        System.out.println("[3] - 15      MAIN MENU - [4]");
        System.out.println("[5] - EXIT                   ");
        System.out.println("-----------------------------");
        System.out.print("Select amount to withdraw: ");
        summToWithdraw = input.nextInt();
        if (summToWithdraw > currentBal) {
            System.out.print("not enought money");
            withdrawFunds();
        } else if (summToWithdraw < 0) {
            System.out.print("Some Have amount is less that 0 - contact support");
            viewBalanceNoConfirm();
            withdrawFunds();
        } else {

            switch (summToWithdraw) {
                case 1:
                    accountWithdraw(5);
                    viewBalanceNoConfirm();
                    atmMenu();
                    break;
                case 2:
                    accountWithdraw(10);
                    viewBalanceNoConfirm();
                    atmMenu();
                    break;
                case 3:
                    accountWithdraw(15);
                    viewBalanceNoConfirm();
                    atmMenu();
                    break;
                case 4:
                    atmMenu();
                    break;
                case 5:
                    System.out.println("Have a nice day! \n Goodbye! \n");
                    System.exit(0);
                    break;
            }
        }
    }

    public void accountWithdraw(int SummToWithdrow) {
        currentBal = currentBal - SummToWithdrow;
        System.out.println("Please take your funds.");
        viewBalanceNoConfirm();
    }

    public void depositFunds() {
        int addSelection;
        System.out.println("Amount to deposit: ");
        System.out.println("-----------------------------");
        System.out.println("[1] - 5              10 - [2]");
        System.out.println("[3] - 15    CUSTOM SUMM - [4]");
        System.out.println("[5] - MAIN MENU    EXIT - (6)");
        System.out.println("-----------------------------");
        System.out.print("Select amount to deposit: ");
        addSelection = input.nextInt();
        switch (addSelection) {
            case 1:
                accountAdd(5);
                atmMenu();
                break;
            case 2:
                accountAdd(10);
                atmMenu();
                break;
            case 3:
                accountAdd(15);
                atmMenu();
                break;
            case 4:
                System.out.print("Specify amount to add:");
                int depositFunds = input.nextInt();
                if (depositFunds < 0) {
                    System.out.print("Some Have amount is less that 0 - try again");
                    viewBalanceNoConfirm();
                    depositFunds();
                } else {
                    accountAdd(depositFunds);
                    atmMenu();
                }
                break;
            case 5:
                atmMenu();
                break;
            case 6:
                System.out.println("Have a nice day! \n Goodbye! \n");
                System.exit(0);
                break;
        }
    }

    public void accountAdd(int depositFunds) {
        currentBal = currentBal + depositFunds;
        viewBalanceNoConfirm();
        System.out.println("Thank you.");
    }

    public static void main(String[] args) {
        new Main().checkAccess();  //init
    }
}
