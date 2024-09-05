package org.sqlCRUDapp;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String name = "" , email = "" ;
        int id = 0 , age = 0 ;
        boolean again = true;
        Scanner kb = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();


        do { //for(int i = 0 ; i<1 ;){

            System.out.println("Would you like to :" +
                    "\n 1: Make a new entry to the database." +
                    "\n 2: Update an entry name." +
                    "\n 3: Remove an entry." +
                    "\n 4: Retrieve all information on an entry." +
                    "\n 5: EXIT");

            switch (kb.next()){

                case  "1" :
                    System.out.println("Enter Name :");
                    name = kb.next();
                    System.out.println("Enter Age :");
                    age = kb.nextInt();
                    System.out.println("Enter Email :");
                    email = kb.next();
                    //System.out.println(name + age + email);//Debug
                    studentDAO.addStudent(name , age , email);
                    break;

                case  "2" :
                    System.out.println("Name the entry ID you wish to update :");
                    id = kb.nextInt();
                    System.out.println("Enter the new name :");
                    name = kb.next();
                    System.out.println("Enter the new age :");
                    age = kb.nextInt();
                    System.out.println("Enter the new email address :");
                    email = kb.next();
                    studentDAO.updateStudentName(id , name , age , email);
                    break;

                case  "3" :
                    //Remove
                    break;

                case  "4" :

                    break;

                case  "5" :
                    //Info
                    again = false;
                    break;

            }
        }while(again == true);
    }
}
