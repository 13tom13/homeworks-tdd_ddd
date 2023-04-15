import org.junit.jupiter.api.*;

import java.util.Map;

public class PhoneBookTest {

    PhoneBook phoneBook;

    String testName = "Test";
    String testNumber = "1";

    @BeforeAll
    public static void init() {
        System.out.println("PhoneBook tests started");
    }

    @AfterAll
    public static void end() {
        System.out.println("PhoneBook tests finished");
    }

    @BeforeEach
    void beforeEach() {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    void afterEach() {
        phoneBook = null;
    }


    @Test
    void addMethodTestAddContact() {
        System.out.println("add method test: add contact");
        // when:
        phoneBook.add(testName, testNumber);
        // then:
        Assertions.assertTrue(phoneBook.getPhoneBook().containsKey(testName));
        System.out.println("add contact - checked");
    }

    @Test
    void addMethodTestAmountNumbers() {
        System.out.println("add method test: amount numbers");
        // given:
        int amountNumber = 1;
        // when:
        int test = phoneBook.add(testName, testNumber);
        // then:
        Assertions.assertEquals(amountNumber, test);
        System.out.println("amount numbers - checked");
    }


    @Test
    void addTestThrowsException() {
        System.out.println("add method test: throws Exception");
        // when:
        phoneBook.add(testName, testNumber);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
                phoneBook.add(testName, testNumber)
        );
        // then:
        Assertions.assertEquals("Контакт с таким именем уже есть", exception.getMessage());
        System.out.println("throws Exception - checked");
    }

    @Test
    void findByNumberTest() {
        System.out.println("findByNumber test");
        // given:
        phoneBook.add(testName, testNumber);
        // when:
        String foundName = phoneBook.findByNumber(testNumber);
        // then:
        Assertions.assertEquals(testName, foundName);
        System.out.println("findByNumber - checked");
    }

    @Test
    void findByNumberNotContainsTest() {
        System.out.println("findByNumber: not contains test");
        // given:
        String testMessage = "Контакта с таким номером нет";
        // when:
        String foundName = phoneBook.findByNumber(testNumber);
        // then:
        Assertions.assertEquals(testMessage, foundName);
        System.out.println("not contains - checked");
    }

    @Test
    void findByNameTest() {
        System.out.println("findByName test");
        // given:
        phoneBook.add(testName, testNumber);
        // when:
        String foundNumber = phoneBook.findByName(testName);
        // then:
        Assertions.assertEquals(testNumber, foundNumber);
        System.out.println("findByName - checked");
    }

    @Test
    void findByNameNotContainsTest() {
        System.out.println("findByName: not contains test");
        // given:
        String testMessage = "Контакта с таким именем нет";
        // when:
        String foundName = phoneBook.findByName(testName);
        // then:
        Assertions.assertEquals(testMessage, foundName);
        System.out.println("not contains - checked");
    }

    @Test
    void printAllNamesTest() {
        System.out.println("printAllNames: not contains test");
        // given:
        boolean isAlphabet = true;
        phoneBook.add("Kate", "1");
        phoneBook.add("Kbte", "3");
        phoneBook.add("Kcte", "4");
        phoneBook.add("Abbe", "5");
        // when:
        String previousName = null;
        for (Map.Entry<String, String> contakt : phoneBook.getPhoneBook().entrySet()) {
            if (previousName == null) {
                previousName = contakt.getKey();
            } else if (previousName.compareTo(contakt.getKey()) <= 0) {
                previousName = contakt.getKey();
            } else {
                isAlphabet = false;
                break;
            }
        }
        // then:
        Assertions.assertTrue(isAlphabet);
        System.out.println("printAllNames - checked");
    }
}
