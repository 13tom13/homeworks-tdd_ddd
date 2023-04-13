import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map <String, Integer> phoneBook = new HashMap<>();

    public Map<String, Integer> getPhoneBook() {
        return phoneBook;
    }

    public int add (String name, int number){
        if (phoneBook.containsKey(name)){
            throw new RuntimeException("Контакт с таким именем уже есть");
        } else {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

}
