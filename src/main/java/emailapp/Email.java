package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String companySuffix = "supercompany.com";

    //constructor to receive the first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: "+this.password);

        //combine elements to generate email

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"+department.toLowerCase()+ "."  + companySuffix;
    }

    //ask for a department
    private String setDepartment(){
        System.out.print("Department codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice= in.nextInt();

        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFJHIGKLMNOPQRSTUVWXYZ123456789!@?#$%";
        char[] password = new char[length];
        for (int i =0; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i]=passwordSet.charAt(random);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity (int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //change password
    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+ " " + lastName+
                "\nCOMPANY EMAIL: "+email+
                "\nMAILBOX CAPACITY: "+mailboxCapacity+ "mb";
    }
}
