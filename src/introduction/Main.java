package introduction;

import java.util.Scanner;
import java.util.Random;
import java.lang.String;


public class Main {
    Random r = new Random();
    Random cNum = new Random();
    int Low = 10;
    int High = 100;
    int cnLow = 1000;
    int cnHigh = 9999;

    int atempts = 3;

    private double currentBal = r.nextInt(High - Low) + Low;
    Scanner input = new Scanner(System.in);
    int pass = r.nextInt(cnHigh - cnLow) + cnLow;

    int cnum1 = cNum.nextInt(cnHigh - cnLow) + cnLow;
    int cnum2 = cNum.nextInt(cnHigh - cnLow) + cnLow;
    int cnum3 = cNum.nextInt(cnHigh - cnLow) + cnLow;
    int cnum4 = cNum.nextInt(cnHigh - cnLow) + cnLow;

    private void addHeader() {
        System.out.println("|-------------------------------------|");
        System.out.println("|-JAVA-ATM----------------------------|");
        System.out.println("|-------------------------------------|");
        System.out.println("| Card number is: " + cnum1 + "-" + cnum2 + "-" + cnum3 + "-" + cnum4 + " |");
        System.out.println("| BANK ATM demo pin code: " + pass + "        |");
        System.out.println("|-------------------------------------|");

    }


    private void checkAccess() {


        addHeader();
        System.out.println("Pin attempts left " + atempts);
        System.out.println("Enter the pin code (4 digits):");

        if (atempts > 0) {
        }
        String pin = input.next();


        boolean isNumeric = pin.chars().allMatch(Character::isDigit);
        if (pin.isEmpty()) {
            System.out.println("Pin Can not be empty.");
            checkAccess();
        } else if (isNumeric) {
            if (pin.length() < 4) {
                System.out.println("Pin must contain 4 digits, not less.");
                checkAccess();
            } else if (pin.length() > 4) {
                System.out.println("Pin must contain 4 digits, not more.");
                checkAccess();
            }
            System.out.println(pin);

            int pinInt = Integer.parseInt(pin);

            if (pass == pinInt) {
                System.out.println("\t-- Correct pin:\n");
                atmMenu();
            } else {
                atempts--;
                System.out.println("\t-- Wrong Pin \n");
                System.out.println("\t--Pin attempts left\n" + atempts);
                checkAccess();
            }

        } else {
            System.out.println("Pin must contain 4 digits, not chars.");
            checkAccess();
        }
    }


    private void atmMenu() {

        int selection;
        addHeader();
        System.out.println("| Select required action              |");
        System.out.println("---------------------------------------");
        System.out.println("| (1)                  Actual Balance |");
        System.out.println("| (2)                 Withdrawal Cash |");
        System.out.println("| (3)                    Make Deposit |");
        System.out.println("| (4)                            Exit |");
        System.out.println("---------------------------------------");

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
                System.exit(0);
                break;
            default:
                System.out.println("Please don't try to destroy ATM. \nEnter value between 1 and 4. \n");
                checkAccess();
                break;
        }
    }

    private void viewBalance() {
        int selection1;
        System.out.println("\t-- Your Current Balance is: " + currentBal + " Credits");
        System.out.println("Press (1) to go to the Main Menu. \nPress another key to exit. \n");
        selection1 = input.nextInt();
        switch (selection1) {
            case 1:
                atmMenu();
                break;
        }
    }

    private void viewBalanceNoConfirm() {

        System.out.println("\t-- Your Current Balance is " + currentBal + " credits");

    }

    private void withdrawFunds() {
        int summToWithdraw;
        addHeader();
        System.out.println("| Select required action              |");
        System.out.println("---------------------------------------");
        System.out.println("| (1) - 5                    10 - (2) |");
        System.out.println("| (3) - 15            MAIN MENU - (4) |");
        System.out.println("| (5) - EXIT                          |");
        System.out.println("---------------------------------------");
        System.out.print("Select amount to withdraw: ");
        summToWithdraw = input.nextInt();
        if (summToWithdraw > currentBal) {
            System.out.print("\t-- not enought money");
            withdrawFunds();
        } else if (summToWithdraw < 0) {
            System.out.print("Some Have amount is less that 0 - contact support");
            withdrawFunds();
        } else {

            switch (summToWithdraw) {
                case 1:
                    accountWithdraw(5);
                    System.out.print("\t-- You successfully Withdrow 5 credits\n");
                    atmMenu();
                    break;
                case 2:
                    accountWithdraw(10);
                    System.out.print("\t-- You successfully Withdrow 10 credits\n");
                    atmMenu();
                    break;
                case 3:
                    accountWithdraw(15);
                    System.out.print("\t-- You successfully Withdrow 15 credits\n");
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

    private void accountWithdraw(int SummToWithdrow) {

        if (currentBal>SummToWithdrow) {
            currentBal = currentBal - SummToWithdrow;

            System.out.println("Please take your funds.");
            viewBalanceNoConfirm();
        }else{
            System.out.println("Not enough credits on account.");
            atmMenu();
        }
    }

    private void depositFunds() {
        int addSelection;
        addHeader();
        System.out.println("| Amount to deposit:                  |");
        System.out.println("--------------------------------------");
        System.out.println("| (1) - 5                    10 - (2) |");
        System.out.println("| (3) - 15          CUSTOM SUMM - (4) |");
        System.out.println("| (5) - MAIN MENU          EXIT - (6) |");
        System.out.println("--------------------------------------");
        System.out.print("Select amount to deposit: ");
        addSelection = input.nextInt();
        switch (addSelection) {
            case 1:
                accountAdd(5);
                System.out.print("\t-- You successfully deposited 5 credits\n");
                atmMenu();
                break;
            case 2:
                accountAdd(10);
                System.out.print("\t-- You successfully deposited 10 credits\n");
                atmMenu();
                break;
            case 3:
                accountAdd(15);
                System.out.print("\t-- You successfully deposited 15 credits\n");
                atmMenu();
                break;
            case 4:
                System.out.print("Specify amount to add:\n");
                int depositFunds = input.nextInt();
                if (depositFunds < 0) {
                    System.out.print("Some Have amount is less that 0 - try again\n");
                    viewBalanceNoConfirm();
                    depositFunds();
                } else {
                    accountAdd(depositFunds);
                    System.out.print("\t--  You successfully deposited " + depositFunds + " credits\n");
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

    private void accountAdd(int depositFunds) {
        currentBal = currentBal + depositFunds;
        viewBalanceNoConfirm();

    }

    public static void main(String[] args) {
        new Main().checkAccess();  //init
    }
}
