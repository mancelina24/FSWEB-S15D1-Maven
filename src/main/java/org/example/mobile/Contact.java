package org.example.mobile;

import java.util.Objects;



    public class Contact {
        //intance variables:
        private String name;
        private String phoneNumber;

        //getter methods:
        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        //contructor:
        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        //methods:
        public static Contact createContact(String name, String phoneNumber){
            Contact newContact = new Contact(name, phoneNumber);
            return newContact;
        }

        //Override methods:
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Contact contact = (Contact) obj;
            return Objects.equals(name, contact.name) &&
                    Objects.equals(phoneNumber, contact.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, phoneNumber);
        }
}
