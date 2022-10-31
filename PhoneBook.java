import java.util.HashMap;
import java.util.Map;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();

    public void addContact(String number, String name){
        if (phoneBook.containsKey(number))
            return;
        phoneBook.put(number, name);
    }

    public String getInfo(String name){
        StringBuilder SB = new StringBuilder();
        SB.append(name).append(": ");
        for (var item: phoneBook.entrySet()) {
            if(item.getValue() == name)
                SB.append(item.getKey()).append(' ');
        }
        if(SB.toString().equals(name+": ")){
            return "Контакт " + name + " не найден";
        }
        return SB.toString();
    }

    public void showPhoneBook(){
        for (var item : phoneBook.entrySet()){
            System.out.printf("%s: %s\n", item.getKey(), item.getValue());
        }
    }

    @Override
    public String toString(){
        return phoneBook.toString();
    }
}
