package uz.waxa;

import uz.waxa.data.DataBase;
import uz.waxa.service.Registration;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("----------------------Card Balance Transfer System---------------------------");
        boolean a=true;
        while (a){
            Registration registration=new Registration();
            System.out.println("1->Registration\n2->SignIn\n0->Exit");
            int n=scanner.nextInt();
            switch (n){
                case 0->{a=false;}
                case 1->{
                    registration.reg();
                }
                case 2->{
                    registration.signIn();
                }

                default -> {
                    System.out.println("There is not choose option!!!");
                }
            }
        }

    }
}
