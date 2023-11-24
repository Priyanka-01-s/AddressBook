package Assgn5_address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public void updateContact(String address, String city, String state, String zip, String phone, String email) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return String.format(
                "NAME : %s %s\nADDRESS : %s\nCITY : %s\nSTATE :%s\nZIP : %s\nPHONE NUMBER : %s\nEMAIL : %s\n",
                fname, lname, address, city, state, zip, phone, email);
    }
}

class Address {

    private String name;
    private ArrayList<Contact> contacts;

    public Address(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAddress(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully to " + name);
    }

    public void display() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in " + name + " the address book");
        } else {
            System.out.println(name + " Address book updated\n");
            for (Contact c : contacts) {
                System.out.println(c);
                System.out.println();
            }
        }
    }

    public void editAddress(String firstName, String lastName, Scanner scanner) {
        for (Contact contact : contacts) {
            if (contact.getFname().equalsIgnoreCase(firstName) && contact.getLname().equalsIgnoreCase(lastName)) {
                System.out.println("Enter the updated details :");

                System.out.print("Enter address: ");
                String address = scanner.nextLine();

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

                contact.updateContact(address, city, state, zip, phone, email);
                System.out.println("Contact updated successfully in " + name + " address book.\n");
                return;
            }else{
                System.out.println("CONTACT NOT AVAILABLE in " + name);
            }
        }
        
    }

    public void deleteAddress(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFname().equalsIgnoreCase(firstName) && contact.getLname().equalsIgnoreCase(lastName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully from " + name);
                return;
            } else {
                System.out.println("\nCONTACT NOT AVAILABLE IN " + name);
            }
        }
    }
}

class AddressManager {
    private Map<String, Address> addressBookManager;

    public AddressManager() {
        this.addressBookManager = new HashMap<>();
    }

    public void createAddressBook(String name) {
        if (!addressBookManager.containsKey(name)) {
            addressBookManager.put(name, new Address(name));
            System.out.println("Address book " + name + " created successfully.");
        } else {
            System.out.println("Address with " + name + " already exists.");
        }
    }

    public Address getAddress(String name) {
        return addressBookManager.get(name);
    }
}

public class addressBookMain {
    public static void main(String[] args) {
        System.out.println("-------WELCOME TO ADDRESS BOOK PROGRAM-------");

        AddressManager addressBookManager = new AddressManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Choose an option:");

            System.out.println("1. Create a new address book");
            System.out.println("2. Operate on the existing address book");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the new address book");
                    String newBookName = scanner.nextLine();
                    addressBookManager.createAddressBook(newBookName);
                    break;

                case 2:
                    operateOnAddressBook(addressBookManager, scanner);
                    break;

                case 0:
                    System.out.println("---------THANK YOU FOR USING ADDRESS BOOK---------");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void operateOnAddressBook(AddressManager addressBookManager, Scanner scanner) {
        System.out.println("---------ADDRESS BOOK OPERATIONS---------");
        // if (addressBookManager.getAddress().isEmpty()) {
        //     System.out.println("No contacts in the address book.");
        //     return;
        // }
        // System.out.println("Existing address books:");
        // addressBookManager.getAddress().keySet().forEach(System.out::println);

        System.out.print("Enter the name of the address book to operate on: ");
        String addressBookName = scanner.nextLine();

        Address selectedAddressBook = addressBookManager.getAddress(addressBookName);

        if (selectedAddressBook != null) {
            operateOnAddressBook(selectedAddressBook, scanner);
        } else {
            System.out.println("Address book '" + addressBookName + "' does not exist.");
        }
    }

    private static void operateOnAddressBook(Address selectedAddressBook, Scanner scanner) {
        int choice;
        do {
            System.out.println("Choose an option for " + selectedAddressBook.getName() + " address book:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display all contacts");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(selectedAddressBook, scanner);
                    break;

                case 2:
                    editContact(selectedAddressBook, scanner);
                    break;

                case 3:
                    deleteContact(selectedAddressBook, scanner);
                    break;

                case 4:
                    selectedAddressBook.display();
                    break;

                case 0:
                    System.out.println("Exiting to the main menu.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void addContact(Address selectedAddressBook, Scanner scanner) {
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

        Contact newContact = new Contact(fname, lname, addressStr, city, state, zip, phone, email);
        selectedAddressBook.addAddress(newContact);
    }

    private static void editContact(Address selectedAddressBook, Scanner scanner) {
        System.out.println("Editing an existing contact:");

        System.out.print("Enter first name of the contact to edit: ");
        String editFirstName = scanner.nextLine();

        System.out.print("Enter last name of the contact to edit: ");
        String editLastName = scanner.nextLine();

        selectedAddressBook.editAddress(editFirstName, editLastName, scanner);
    }

    private static void deleteContact(Address selectedAddressBook, Scanner scanner) {
        System.out.println("Deleting an existing contact:");

        System.out.print("Enter first name of the contact to delete: ");
        String delFName = scanner.nextLine();

        System.out.print("Enter last name of the contact to delete: ");
        String delLName = scanner.nextLine();

        selectedAddressBook.deleteAddress(delFName, delLName);
    }
}

