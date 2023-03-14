package ch4;

import java.util.Scanner;

public class ConditionLogic {
    public static void main(String[] args) {
        //ifStmt();
        //ifDaysInMonth();
        //danglingElse();
        //switchStmt();
        switchExamples();
    }
    public static void switchExamples(){
        // no case labels allowed
        switch("abc"){
        }


    /*    Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sport --> ");
        String sport = sc.next();
        switch(sport){
            case "Soccer":
                System.out.println("I play soccer");
                break;
            case "Rugby":
                System.out.println("I play Rugby");
                break;
            default:// can be moved around
                System.out.println("Unknown sport");
                break;
        }*/

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (1..10) --> ");
        int number = sc.nextInt();
        final int two = 2; // compile-time constant
        switch(number){
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                System.out.println(number + " is odd.");
                break;
            case two:
            case 4: case 6: case 8: case 10:
                System.out.println(number + " is even.");
                break;
            default:
                System.out.println( number + " is outside range (1..10).");
                break;
        }
        // duplicates not allowed
        // case labels must be in range
        // must be constants
        // switch expressions
        byte b = 3;
        switch(b){
            case 127: case -128:
                System.out.println("ok");
                break;
            case 128:
            case 12:
            case 12:
        }
    }
    public static void switchStmt(){
        final int JAN=1;final int FEB=2;final int MAR=3; // define constants
        final int APR=4;final int MAY=5;final int JUN=6;
        final int JUL=7;final int AUG=8;final int SEP=9;
        final int OCT=10;final int NOV=11;final int DEC=12;

        Scanner sc = new Scanner(System.in);    // import java.util.Scanner;
        System.out.print("Enter month --> ");
        int month = sc.nextInt();

        int numDays=0;
        switch(month){
            case JAN:case MAR:case MAY:case JUL: case AUG:case OCT:case DEC:
                numDays=31;
                break;
            case APR:case JUN:case SEP:case NOV:
                numDays=30;
                break;
            case FEB:
                System.out.print("Enter year --> ");
                int year = sc.nextInt();
//                if( (A)         || (        B         &&       C)    ){
                if( (year % 400 == 0) || (year % 4 == 0 && !(year % 100 == 0)) ){
                    numDays = 29; // leap year e.g. 2000, 2012, 2016
                }else{
                    numDays = 28;   // 1900 (divisible by 100)
                }
                break;
            default:
                System.out.println("Invalid month: "+month);
                break;

        }
        if(numDays > 0){
            System.out.println("Number of days is: "+numDays);
        }

    }
    public static void danglingElse(){
        boolean flag=false;
        if (flag)
        if (flag)
        System .out.println("True True");
        else
        System.out.println("True False");

        if (flag)
            if (flag)
                System .out.println("True True");
            else
                System.out.println("True False");

        if (flag) {
            if (flag) {
                System.out.println("True True");
            }
            else {
                System.out.println("True False");
            }
        }
/*
        boolean flag=true;
        if (flag)
        if (flag)
        System .out.println("True True");
        else
        System.out.println("True False");
        else
        System.out.println("False");

        if (flag)
            if (flag)
                System .out.println("True True");
            else
                System.out.println("True False");
        else
            System.out.println("False");

*/
    }
    public static void ifDaysInMonth(){
        final int JAN=1;final int FEB=2;final int MAR=3; // define constants
        final int APR=4;final int MAY=5;final int JUN=6;
        final int JUL=7;final int AUG=8;final int SEP=9;
        final int OCT=10;final int NOV=11;final int DEC=12;

        Scanner sc = new Scanner(System.in);    // import java.util.Scanner;
        System.out.print("Enter month --> ");
        int month = sc.nextInt();

        int numDays=0;
        if(month == JAN || month == MAR || month == MAY || month == JUL
                || month == AUG || month == OCT || month == DEC) {
            numDays=31;
        } else if (month == APR || month == JUN || month == SEP || month == NOV) {
            numDays=30;
        } else if (month == FEB) {
            System.out.print("Enter year --> ");
            int year = sc.nextInt();
//                if( (A)         || (    B         &&       C)    ){
            if( (year % 400 == 0) || (year % 4 == 0 && !(year % 100 == 0)) ){
                numDays = 29; // leap year e.g. 2000, 2012, 2016
            }else{
                numDays = 28;   // 1900 (divisible by 100)
            }
        } else {
            System.out.println("Invalid month: "+month);
        }
        if(numDays > 0){
            System.out.println("Number of days is: "+numDays);
        }
    }

    public static void ifStmt(){
/*
        int x=4, y=5;
        if(x > y)
            System.out.println(x + " > "+y);
        if(x < y)
            System.out.println(x + " < "+y);
        if(x == y){
            String s = x + " == "+y;
            System.out.println(s);
        }
*/
/*
        int x=4, y=5;
        if(x > y) {
            System.out.println(x + " > " + y);
        } else if(x < y) {
            System.out.println(x + " < " + y);
        } else if(x == y){
            System.out.println(x + " == " + y);
        }
        System.out.println("Here");
*/
        int x=4, y=4;
        if(x > y) {
            System.out.println(x + " > " + y);
        } else if(x < y) {
            System.out.println(x + " < " + y);
        } else { //if(x == y){
            System.out.println(x + " == " + y);
        }
        System.out.println("Here");

    }
}