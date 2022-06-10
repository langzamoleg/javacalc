package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
            Scanner in= new Scanner(System.in);
            String str = in.nextLine();
            //System.out.println(str);
            String operation="g";
            String[] numbers = new String[10];
            try {
                operation = operate(str);
                numbers = splt(str);
                //System.out.println(operation);
            }catch(IOException e) {
                System.out.println("Математическая операция неизвестна или не указана");
                System.exit(101);
            }
            try{
                if(numbers.length !=2){
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Невозможно выполнить несколько операций");
                System.exit(102);
            }
            int first=1, second=2;
            int numeric=0;
            try {
                first = Integer.valueOf(numbers[0]);
            }catch (NumberFormatException e){
                numeric++;
                try {
                    first = toint(numbers[0]);
                } catch (NumberFormatException f) {
                    System.out.println("Введенные числа неверны или вы попытались выполнить несколько операций");
                    System.exit(103);
                }
            }
            try {
                second = Integer.valueOf(numbers[1]);
            }catch (NumberFormatException e){
                numeric++;
                try {
                    second = toint(numbers[1]);
                } catch (NumberFormatException f) {
                    System.out.println("Введенные числа неверны или вы попытались выполнить несколько операций");
                    System.exit(103);
                }
            }


            if(numeric==1){
                System.out.println("Первое и второе число записаны разными цифрами");
                System.exit(104);
            }
            if(first<1||first>10||second<1||second>10){
                System.out.println("Числа на входе должны быть от 1 до 10 включительно");
                System.exit(105);
            }


            int answer;
            switch(operation.charAt(0)){
                case '/':
                    answer = first/second;
                    break;
                case '*':
                    answer = first*second;
                    break;
                case '-':
                    answer = first-second;
                    break;
                case '+':
                    answer = first+second;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
            //System.out.println(answer);
            if(numeric==2&&answer<1){
                System.out.println("Результат вычисления римских цифр должен быть натуральным числом");
                System.exit(105);
            }

            System.out.println(answer);



        }

    public static String operate(String check) throws IOException {
            String operation;
            if(check.contains("/")){
                operation = "/";
            } else if(check.contains("*")){
                operation = String.valueOf('*');
            } else if(check.contains("-")){
                operation = "-";
            } else if(check.contains("+")){
                operation = String.valueOf('+');
            }else{
                throw new IOException();
            }

            return operation;
        }
    public static String[] splt(String check) throws IOException {
            String[] numbers;
            if(check.contains("/")){
                numbers = check.split("/");
            } else if(check.contains("*")){
                numbers = check.split("\\*");
            } else if(check.contains("-")){
                numbers = check.split("-");
            } else if(check.contains("+")){
                numbers = check.split("\\+");
            }else{
                throw new IOException();
            }

            return numbers;
        }
    public static int toint(String number) throws IOException {
        int ret;
            switch (number){
                case "1":
                    ret = 1;
                    break;
                case "I":
                    ret = 1;
                    break;
                case "2":
                    ret = 2;
                    break;
                case "II":
                    ret =  2;
                    break;
                case "3":
                    ret = 3;
                    break;
                case "III":
                    ret = 3;
                    break;
                case "4":
                    ret = 4;
                    break;
                case "IV":
                    ret = 4;
                    break;
                case "5":
                    ret = 5;
                    break;
                case "V":
                    ret = 5;
                    break;
                case "6":
                    ret = 6;
                    break;
                case "VI":
                    ret = 6;
                    break;
                case "7":
                    ret = 7;
                    break;
                case "VII":
                    ret = 7;
                    break;
                case "8":
                    ret = 8;
                    break;
                case "VIII":
                    ret = 8;
                    break;
                case "9":
                    ret = 9;
                    break;
                case "IX":
                    ret = 9;
                    break;
                case "10":
                    ret = 10;
                    break;
                case "X":
                    ret = 10;
                    break;
                default:
                    throw new NumberFormatException();
            }
            return ret;
        }
    }


