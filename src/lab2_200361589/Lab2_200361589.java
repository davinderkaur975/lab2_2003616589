/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_200361589;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Davinder Kaur
 */
public class Lab2_200361589 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        //asking user to enter the password for creating the account
        System.out.println("Please enter your password");
        String password = input.nextLine();
       
        //hashing the password
        byte[] salt = User.getSalt();
      	String passwordInstance = User.getPW(password, salt);
        String hasheduserPassword;
        
        User newUser=new User(passwordInstance);
          
    
        
        System.out.println("---Log in into your account----");
        
        //asking the user to enter the password for login into the account
        System.out.println("Please enter your password");
        String userPassword = input.nextLine();
        
        //hashing the password
        hasheduserPassword = User.getPW(userPassword, salt);
         
        //checking if both the passwords are same or not
        if(!(hasheduserPassword.equals(newUser.getPassword()))) 
        {
            do{
                //if password is invalid, it asks user to again enter the valid password
                System.out.println("Please enter the valid password");
                String userPassword2 = input.nextLine();
                String hasheduserPassword2 = User.getPW(userPassword2, salt);
          
                hasheduserPassword = hasheduserPassword2;
                }
            while(!(hasheduserPassword.equals(newUser.getPassword())));
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Success");
        }
    }
}
    

