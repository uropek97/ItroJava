import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook_V2 {
    private Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String number){
        if(phoneBook.containsKey(name)){
            ArrayList<String> list = phoneBook.get(name);
            list.add(number);
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(number);
            phoneBook.put(name, list);
        }
    }
    public String getCont(String name){
        if(!phoneBook.containsKey(name))
            return "Контакт не найден";
        else
            return String.format("%s: %s", name, phoneBook.get(name).toString());
    }

    @Override
    public String toString(){
        return phoneBook.toString();
    }
}
