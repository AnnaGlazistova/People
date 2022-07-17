public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        son.happyBirthday();

        Person dad = new PersonBuilder()
                .setName("Paul")
                .setSurname("Вольф")
                .setAge(31)
                .build();
        dad.hasAddress();
        System.out.println(dad);

        try {
            Person nullPerson = new PersonBuilder().build();
            System.out.println(nullPerson);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

