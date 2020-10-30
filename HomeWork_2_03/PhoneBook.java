package HomeWork_2_03;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args) {
        Contact c1 = new Contact("Ivanov", "+7999");
        Contact c2 = new Contact("Ivanov", "+7888");
        Contact c3 = new Contact("Sidorov", "+77777");

        List<Contact> listContacts = new ArrayList<>();
        listContacts.add(c1);
        listContacts.add(c2);
        listContacts.add(c3);

        System.out.println(get(listContacts, "Ivanov"));

    }

    static List<String> get(List<Contact> listContacts, String surname) {
        List<String> suits = new ArrayList<>();

        for (Contact c : listContacts) {
            if (c.surname == surname) {
                suits.add(c.phone);
            }
        }
        return suits;
    }
}
