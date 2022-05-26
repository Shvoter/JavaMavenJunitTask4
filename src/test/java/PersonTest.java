import Task4.IncorrectUsernameException;
import Task4.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private static Person p;

    @BeforeEach
    public void createNewPerson() {
        p = new Person();

    }

    @Test
    public void notFiledPersonGettingFullNameShouldThrowException() {
        Exception e = Assertions.assertThrows(IncorrectUsernameException.class,
                () -> p.getFullName()
        );

        Assertions.assertEquals("Not filled arguments for Full name", e.getMessage());
    }

    @Test
    public void notFiledNameGettingFullNameShouldThrowException() {
        p.setSurName("Khrychov");
        p.setPatronymic("Sergeevich");

        Exception e = Assertions.assertThrows(IncorrectUsernameException.class,
                () -> p.getFullName()
        );

        Assertions.assertEquals("Not filled arguments for Full name", e.getMessage());
    }

    @Test
    public void notSurNamePersonGettingFullNameShouldThrowException() {
        p.setName("Artem");
        p.setPatronymic("Sergeevich");

        Exception e = Assertions.assertThrows(IncorrectUsernameException.class,
                () -> p.getFullName()
        );

        Assertions.assertEquals("Not filled arguments for Full name", e.getMessage());
    }

    @Test
    public void notFiledPatronymicGettingFullNameShouldThrowException() {
        p.setName("Artem");
        p.setSurName("Khrychov");

        Exception e = Assertions.assertThrows(IncorrectUsernameException.class,
                () -> p.getFullName()
        );

        Assertions.assertEquals("Not filled arguments for Full name", e.getMessage());
    }

    @Test
    public void filedPersonShouldGetFullName() throws IncorrectUsernameException {
        p.setName("Artem");
        p.setSurName("Khrychov");
        p.setPatronymic("Sergeevich");

        Assertions.assertEquals("Artem Khrychov Sergeevich", p.getFullName());
    }

    @Test
    public void personShouldBeAdult() {
        p.setAge(18);
        Assertions.assertEquals(true, Person.isAdult(p));
    }

    @Test
    public void personShouldNotBeAdult() {
        p.setAge(17);
        Assertions.assertEquals(false, Person.isAdult(p));
    }

    @Test
    public void personNameShouldNotChangeWhenPassNull() {
        p.setName(null);
        Assertions.assertEquals("", p.getName());
    }

    @Test
    public void personSurnameShouldNotChangeWhenPassNull() {
        p.setSurName(null);
        Assertions.assertEquals("", p.getSurName());
    }

    @Test
    public void personPatronymicShouldNotChangeWhenPassNull() {
        p.setPatronymic(null);
        Assertions.assertEquals("", p.getPatronymic());
    }

    @Test
    public void personAgeShouldNotChangeWhenPassNegativeInt() {
        p.setAge(-6);
        Assertions.assertEquals(0, p.getAge());
    }
}
