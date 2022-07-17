import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    boolean hasAge() {
        boolean answer = (getAge().isPresent()) ? true : false;
        return answer;
    }

    boolean hasAddress() {
        if (address == null) {
            setAddress("NY");
            return false;
        }
        return true;
    }

    void happyBirthday() {
        age++;
        System.out.println("Happy birthday, " + name +
                ", you are now " + age + " y.o.");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getName().equals(person.getName()) && getSurname().equals(person.getSurname()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder babyPerson = new PersonBuilder();
        babyPerson.setSurname(this.surname);
        babyPerson.setAddress(this.address);
        return babyPerson;
    }
}
