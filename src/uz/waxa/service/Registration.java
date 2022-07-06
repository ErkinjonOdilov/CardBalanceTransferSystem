package uz.waxa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Registration {
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String password;
    private double balance = 0;

    public String userCardNumber;
    public String userCardPassword;
    public static List<Registration> list = new ArrayList<>();

    public Registration() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Registration(String firstName, String lastName, String cardNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.password = password;
    }

    Scanner scanner = new Scanner(System.in);

    public void reg() {
        System.out.print("First Name: ");
        firstName = scanner.next();
        System.out.print("Last Name: ");
        lastName = scanner.next();
        System.out.print("Card Number: ");
        cardNumber = scanner.next();
        System.out.print("Create Password: ");
        password = scanner.next();
        Registration r1 = new Registration(firstName, lastName, cardNumber, password);
        list.add(r1);
    }

    public void signIn() {
        boolean isEnter = true;
        System.out.print("Card Number: ");
        String CardNumber = scanner.next();
        System.out.print("Password: ");
        String CardPassword = scanner.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cardNumber.equals(CardNumber) && list.get(i).password.equals(CardPassword)) {
                userCardNumber = CardNumber;
                userCardPassword = CardPassword;
                System.out.println("----------------------Card Balance Transfer System---------------------------");
                boolean run = true;
                isEnter = false;
                while (run) {
                    System.out.println("Choose Options: ");
                    System.out.println("1->Balance");
                    System.out.println("2->Transfer Balance");
                    System.out.println("3->Fill Card Balance");
                    System.out.println("0->Exit");
                    int n = scanner.nextInt();
                    switch (n) {
                        case 0 -> {
                            run = false;
                        }
                        case 1 -> {
                            System.out.print("Card Password: ");
                            String cardPassword = scanner.next();
                            System.out.print("Card Number:");
                            String Cardnumber = scanner.next();
                            getBalance(cardPassword, Cardnumber);
                        }
                        case 2 -> {
                            System.out.println("------------------Transfer Balance To Other Card------------------");
                            System.out.print("Enter The Card Number: ");
                            String otherCard = scanner.next();
                            System.out.print("Password: ");
                            String Password = scanner.next();
                            System.out.print("Transfer Balance: ");
                            double transferBalance = scanner.nextDouble();
                            transferTo(otherCard, Password, transferBalance);
                        }
                        case 3 -> {
                            System.out.print("Card Password: ");
                            String Password = scanner.next();
                            System.out.print("Card Number: ");
                            String cardNumber = scanner.next();
                            System.out.print("How much money Filled:");
                            double fillMoney = scanner.nextDouble();
                            fillBalance(Password, fillMoney, cardNumber);
                        }
                        default -> {
                            System.out.println("There is not choose option!");
                        }
                    }

                }
            }
        }
        if (isEnter) {
            System.out.println("There is not card");
        }
    }

    public void getBalance(String CardPassword, String Cardnumber) {
        boolean isTrue = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cardNumber.equals(userCardNumber) && list.get(i).password.equals(userCardPassword)) {
                if (userCardNumber.equals(Cardnumber)) {
                    if (userCardPassword.equals(CardPassword)) {
                        isTrue = false;
                        balance = list.get(i).balance;
                        System.out.print("Balance=");
                        System.out.println(balance);
                    } else {
                        System.out.println("Card Password Incorrect!!");
                    }
                } else {
                    System.out.println("Card Number is Incorrect!!");
                }
            }
        }
        if (isTrue) {
            System.out.println("There is not card in base");
        }
    }

    public void fillBalance(String CardPassword, double amount, String Cardnumber) {
        boolean isTrue = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cardNumber.equals(userCardNumber) && list.get(i).password.equals(userCardPassword)){
                if(userCardNumber.equals(Cardnumber)){
                    if (userCardPassword.equals(CardPassword)){
                        isTrue = false;
                        list.get(i).balance = list.get(i).balance + amount;
                        System.out.print("Filled Balance=");
                        System.out.println(list.get(i).balance);
                    }else {
                        System.out.println("Card password incorrect");
                    }
                }else {
                    System.out.println("Card number incorrect");
                }
            }
        }
        if (isTrue) {
            System.out.println("Incorrect!!");
            System.out.println("You must filled yourself card number and card password");
        }


    }

    public void transferTo(String otherCardNumber, String Password, double transferBalance) {
        boolean isTrue = true;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).cardNumber.equals(userCardNumber) && list.get(i).password.equals(userCardPassword)){
                if(list.get(i).balance>0 && list.get(i).balance>transferBalance){
                    for (int j = 0; j <list.size() ; j++) {
                        if(list.get(j).cardNumber.equals(otherCardNumber)&&list.get(j).password!=list.get(i).password){
                            list.get(j).balance+=transferBalance;
                            list.get(i).balance-=transferBalance;
                            isTrue = false;
                            System.out.println("Succesfully Transferred!!!");
                            break;
                        }
                    }
                }else {
                    System.out.println("You have not enough money to Transferred!!!");
                    break;
                }
            }
        }
        if (isTrue) {
            System.out.println("Error!!!");
        }

    }

}
