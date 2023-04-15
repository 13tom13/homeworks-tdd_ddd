import java.util.*;

public class PhoneBook {

    private final Map<String, String> phoneBook = new TreeMap<>();

    protected Map<String, String> getPhoneBook() {
        return phoneBook;
    }

    public int add(String name, String number) {
        if (phoneBook.containsKey(name)) {
            throw new RuntimeException("Контакт с таким именем уже есть");
        } else {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        Optional <String> result = phoneBook.entrySet()
                .stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return result.orElse("Контакта с таким номером нет");
    }

    public String findByName (String name){
        return phoneBook.getOrDefault(name, "Контакта с таким именем нет");
    }

    public void printAllNames (){
        for (Map.Entry<String, String> contakt : phoneBook.entrySet()){
            System.out.println(contakt.getKey() + ":" + contakt.getValue());
        }
    }

}
