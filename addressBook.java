package Assgn5_address;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String fname;
    private String lname;
    private String address;
    private String city;
    private String zip;
    private String state;
    private String phone;
    private String email;

    public Contact(String fname, String lname, String address, String city, String state, String zip, String phone,
            String email) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.phone = phone;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return zip;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format(
                "NAME : %s %s\nADDRESS : %s\nCITY : %s\nSTATE :%s\nZIP : %s\nPHONE NUMBER : %s\nEMAIL : %s\n",
                fname, lname, address, city, state, zip, phone, email);
    }

}

class Address{

    private ArrayList<Contact> contacts;

    public Address(){
        contacts = new ArrayList<Contact>();
    }

    public void addAddress(Contact contact){
        contacts.add(contact);
        System.out.println("Contact added successfully");
    
    }
    
    public void display() {
        if(contacts.isEmpty()){
            System.out.println("No contacts in the address book");
        }else{
            System.out.println("Address book updated\n");
            for(Contact c : contacts){
                System.out.println(c);
                System.out.println();
            
        }
        }
        
            
        
    }
}

public class addressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Address address = new Address();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter address: ");
        String addressStr = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();

        System.out.print("Enter zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Contact contact1 = new Contact("Priyanka", "Sengupta", "sector 78", "Noida", "UP", "201307", "891343189",
        //         "abc@gmail.com");

        Contact newContact = new  Contact(fname, lname, addressStr, city, state, zip, phone, email);
        address.addAddress(newContact);
        address.display();
    }
}