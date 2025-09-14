package lk.acpt.library;

import java.io.FileReader;
import java.io.IOException;

public class Exeption{
    public static void main(String[] args){
        int val = 10;
        int val2 = 0;

        try {
            int result = val / val2;
            System.out.println("Result: " + result);
        }catch (Exception ex) {
//            throw new NumberFormatException("number is less than 20");//throw keyword eka
        }finally {//finally block eka(exception eka awath run wenawa)
            System.out.println("End of the program");
        }

        String age = "28";//wrapper class
        double i = Double.parseDouble(age);


        try {
            throwsException();
        } catch (Exception e) { //Exception eka super class eka wei(onama exception ekakata damiya hakiya)
            System.out.println("Exception: ");
        }


//        final int mark = 75;
//        if (mark < 100) {
//            System.out.println("Mark: " + (mark+=5));//finall key eka (final dala thinawanam nawatha wenass kala nohaka)
//        }



    }
    public static void throwsException()throws Exception { //throws keyword eka (exeption ekak thina method ekak main method ekata pass karai)
        FileReader fr = new FileReader("data.txt");
    }
}
