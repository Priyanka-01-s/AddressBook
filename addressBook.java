package Assgn5_address;

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
    
    public void display(Contact contact) {
        
            System.out.println(contact);
        
    }
}

public class addressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Address address = new Address();

        Contact contact1 = new Contact("Priyanka", "Sengupta", "sector 78", "Noida", "UP", "201307", "891343189",
                "abc@gmail.com");
        address.display(contact1);
    }
}