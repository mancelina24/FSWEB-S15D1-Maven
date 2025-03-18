package org.example.mobile;
import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    //intance variables:
    private String myNumber;
    private List<Contact> myContacts;

    //getter methods:
    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    //contructor:
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    //methods:
    public boolean addNewContact(Contact newContact){
        if(findContact(newContact.getName()) == -1){
            myContacts.add(newContact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int index = findContact(oldContact.getName());
        if(index >= 0){
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int index = findContact(contact);
        if(index >= 0) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contact.getName()) &&
                    myContacts.get(i).getPhoneNumber().equals(contact.getPhoneNumber())) {
                return i;
            }
        }
        return -1;
    }


    public int findContact(String name){
        for(int i=0; i<myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }



    public void printContact (){
        System.out.println("Contact list: ");
        for(Contact contact: myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
