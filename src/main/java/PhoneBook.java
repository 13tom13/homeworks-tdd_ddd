import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

    private final Map<String, Integer> phoneBook = new HashMap<>();

    public Map<String, Integer> getPhoneBook() {
        return phoneBook;
    }

    public int add(String name, int number) {
        if (phoneBook.containsKey(name)) {
            throw new RuntimeException("Контакт с таким именем уже есть");
        } else {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(Integer number) {
        Optional <String> result = phoneBook.entrySet()
                .stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return result.orElse("Контакта с таким номером нет");
    }

}
