package javaCodsoft;

import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        this.name = sc.nextLine();
        System.out.println("Enter Your UserName:");
        this.userName = sc.nextLine();
        System.out.println("Enter Your Password:");
        this.password = sc.nextLine();
        System.out.println("Enter Your Account no:");
        this.accountNo = sc.nextLine();
        System.out.println("Registration Successful. Please log in your Bank Acccount");
    }

    //// Login Section
    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("Enter Your username");
            String username = sc.nextLine();
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.println("Enter Your Password");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("Login Successfully");
                        isLogin = true;
                    } else {
                        System.out.println("Incorrect Password");
                    }
                }
            } else {
                System.out.println("username not found");
            }
        }
        return isLogin;

    }

    /// withdraw Section
    public void withdraw() {
        System.out.println("Enter Amount too Withdraw");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("Withdrawl Successfully");
                String str = amount + "Rs withdrawn";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e) {

        }
    }

    /// Deposit section
    public void deposit() {
        System.out.println("Enter Amount to Deposit");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 1000f) {
                transactions++;
                balance += amount;
                System.out.println("Deposit Successfully");
                String str = amount + "Rs Deposited";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Sorry..The limit is 1000");
            }
        } catch (Exception e) {

        }
    }

    // transfer section
    public void transfer() {
        System.out.println("Enter Receipent's Name");
        Scanner sc = new Scanner(System.in);
        String reciepent = sc.nextLine();
        System.out.println("\nEnter Amount to Transfer");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 25000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("Transfer Successfully");
                    String str = amount + "Rs Deposited";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("Sorry..The limit is 1000");
                }
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e) {
        }
    }

    /// check Balance
    public void checkBalance() {
        System.out.println("\n" + balance + "");
    }

    ///// transactionHistory
    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No transaction Happend");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class task3Atm {
    public static int takenInteger(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to" + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;

            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Interface");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Choose one option");
        int choose = takenInteger(2);
        if (choose == 1) {
            BankAccount ob = new BankAccount();
            ob.register();
            while (true) {
                System.out.println(("1.Login \n2.Exit"));
                int ch = takenInteger(2);
                if (ch == 1) {
                    if (ob.login()) {
                        System.out.println("Welcome Back");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.withdraw \n2.Deposit \n3.Transfer \n4.check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your Choice");
                            int c = takenInteger(6);
                            switch (c) {
                                case 1:
                                    ob.withdraw();
                                    break;
                                case 2:
                                    ob.deposit();
                                    break;
                                case 3:
                                    ob.transfer();
                                    break;
                                case 4:
                                    ob.checkBalance();
                                    break;
                                case 5:
                                    ob.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Exit");
        }
       
    }
}
