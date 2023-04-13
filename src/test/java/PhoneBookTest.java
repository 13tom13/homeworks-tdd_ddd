import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

    PhoneBook phoneBook;

    @BeforeEach
    void beforeEach() {
        phoneBook = new PhoneBook();
    }


    @Test
    void addMethodTest() {
        System.out.println("add method test");
        // given:
        String name = "Test";
        int number = 1;
        // when:
        int test = phoneBook.add(name, number);
        // then:
        Assertions.assertTrue(phoneBook.getPhoneBook().containsKey(name));
        System.out.println("Add test - checked");
    }

    @Test
    void addMethodTestAmountNumbers() {
        System.out.println("add method test: amount numbers");
        // given:
        String name = "Test";
        int number = 1;
        int amountNumber = 1;
        // when:
        int test = phoneBook.add(name, number);
        // then:
        Assertions.assertEquals(amountNumber, test);
        System.out.println("amount numbers - checked");
    }


    @Test
    void addTestThrowsException() {
        System.out.println("add method test: throws Exception");
        // given:
        String name1 = "Test";
        int number = 1;
        // when:
        phoneBook.add(name1, number);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
                phoneBook.add(name1, number)
        );
        // then:
        Assertions.assertEquals("Контакт с таким именем уже есть", exception.getMessage());
        System.out.println("throws Exception - checked");
    }
}
