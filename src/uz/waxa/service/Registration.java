package uz.waxa.service;

import uz.waxa.data.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Registration extends DataBase {
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String password;
    private double balance=0;

    public static List<Registration> list=new ArrayList<>();

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
        this.password=password;
    }
    Scanner scanner=new Scanner(System.in);
    public void reg(){
        System.out.print("First Name: ");
        firstName=scanner.next();
        System.out.print("Last Name: ");
        lastName=scanner.next();
        System.out.print("Card Number: ");
        cardNumber=scanner.next();
        System.out.print("Create Password: ");
        password=scanner.next();
        Registration r1=new Registration(firstName,lastName,cardNumber,password);
        list.add(r1);
    }

    public  void signIn(){
        boolean isEnter=true;
        System.out.print("Card Number: ");
        String CardNumber=scanner.next();
        System.out.print("Password: ");
        String CardPassword=scanner.next();
        for (int i = 0; i <list.size() ; i++) {
                    if (list.get(i).cardNumber.equals(CardNumber) && list.get(i).password.equals(CardPassword)) {
                        System.out.println("----------------------Card Balance Transfer System---------------------------");
                        boolean run =true;
                        isEnter=false;
                        while (run) {
                            System.out.println("Choose Options: ");
                            System.out.println("1->Balance");
                            System.out.println("2->Transfer Balance");
                            System.out.println("3->Fill Card Balance");
                            System.out.println("4->Ask Credit");
                            System.out.println("0->Exit");
                            int n = scanner.nextInt();
                            switch (n) {
                                case 0->{ run = false;}
                                case 1 -> {
                                    System.out.print("Card Password: ");
                                    String cardPassword=scanner.next();
                                    System.out.print("Card Number:");
                                    String Cardnumber = scanner.next();
                                    getBalance(cardPassword,Cardnumber);
                                }
                                case 2 -> {
                                    System.out.println("------------------Transfer Balance To Other Card------------------");
                                    System.out.print("Enter The Card Number: ");
                                    String otherCard=scanner.next();
                                    System.out.print("Password: ");
                                    String Password=scanner.next();
                                    System.out.print("Transfer Balance: ");
                                    double transferBalance=scanner.nextDouble();
                                    transferTo(otherCard,Password,transferBalance);
                                }
                                case 3 -> {
                                    System.out.print("Card Password: ");
                                    String Password=scanner.next();
                                    System.out.print("Card Number: ");
                                    String cardNumber=scanner.next();
                                    System.out.print("How much money Filled:");
                                    double fillMoney=scanner.nextDouble();
                                    fillBalance(Password, fillMoney,cardNumber);
                                }
                                case 4 -> {}

                                default -> {
                                    System.out.println("There is not choose option!");
                                }
                            }

                        }
                    }
            }
       if(isEnter){
           System.out.println("There is not card");
       }
    }

    public void getBalance(String CardPassword,String Cardnumber) {
        boolean isTrue = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).password.equals(CardPassword)) {
                if (list.get(i).cardNumber.equals(Cardnumber)) {
                    isTrue = false;
                    balance = list.get(i).balance;
                    System.out.print("Balance=");
                    System.out.println(balance);
                }
            }

        }  if(isTrue){
            System.out.println("Incorrect Password");
        }
    }

    public  void fillBalance(String CardPassword,double amount,String Cardnumber){
        boolean isTrue=true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).password.equals(CardPassword)) {
                if(list.get(i).cardNumber.equals(Cardnumber)){
                isTrue=false;
                    list.get(i).balance=list.get(i).balance+amount;
                    System.out.print("Filled Balance=");System.out.print(list.get(i).balance);
                }
            }
        }
        if(isTrue){
            System.out.println("Incorrect!!");

        }


    }

    public void transferTo(String otherCard,String Password,double transferBalance){
        boolean isTrue=true;
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).cardNumber.equals(otherCard) && list.get(i).password.equals(Password)){
//                if(list.get(i).balance!=0){
                list.get(i).balance+=transferBalance;
                balance-=transferBalance;
                System.out.println("Successfully Transferred!!!");
                isTrue=false;
//            }else {
//                    System.out.println("There is not enough money!!");
//                }
            }
        }if(isTrue){
            System.out.println("Error!!!");
        }

    }

}
