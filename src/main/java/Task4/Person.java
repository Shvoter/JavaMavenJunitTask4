package Task4;

public class Person {
    private String surName = "";
    private String name = "";
    private String patronymic = "";
    private int age;

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setSurName(String surName) {
        if(surName != null)
            this.surName = surName;
    }

    public void setName(String name) {
        if(name != null)
            this.name = name;
    }

    public void setPatronymic(String patronymic) {
        if(patronymic != null)
            this.patronymic = patronymic;
    }

    public void setAge(int age) {
        if(age >= 0)
            this.age = age;
    }

    public String getFullName() throws IncorrectUsernameException {
        if (name.isEmpty() || surName.isEmpty() || patronymic.isEmpty())
            throw new IncorrectUsernameException("Not filled arguments for Full name");

        return name + " " + surName + " " + patronymic;
    }

    public static boolean isAdult(Person p) {
        return p.getAge() >= 18;
    }
}
