import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        AnimalFiles animalContainer = new AnimalFiles();
        ArrayList<Person> persons = getConstPersons();
        Animal animal1 = new Animal(null, "Barsik", persons.get(0), 10);
        Animal animal2 = new Animal(null, "Mopsik", persons.get(1), 3);
        Animal animal3 = new Animal(null, "Sharik", persons.get(2), 15);
        Animal animal4 = new Animal(null, "Bobik", persons.get(0), 25);
        Animal animal5 = new Animal(null, "Mopsik", persons.get(3), 6);

        UUID uid1 = animalContainer.add(animal1);
        animalContainer.add(animal2);
        animalContainer.add(animal3);
        animalContainer.add(animal4);
        UUID uid5 =animalContainer.add(animal5);
        System.out.println(animalContainer.toString());

        animal5.setWeight(26);
        animalContainer.update(animal5);

        System.out.println(animalContainer.toString());

        System.out.println(animalContainer.getAnimalByName("Mopsik").toString());
    }

    public static ArrayList<Person> getConstPersons(){
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person(25, "MAN", "Petrov"));
        persons.add(new Person(32, "MAN", "Sidorov"));
        persons.add(new Person(54, "MAN", "Ivanov"));
        persons.add(new Person(67, "WOMAN", "Medvedeva"));
        persons.add(new Person(33, "MAN", "Chistyakov"));
        persons.add(new Person(20, "MAN", "Konev"));
        persons.add(new Person(25, "MAN", "Milonov"));
        persons.add(new Person(25, "MAN", "Medvedev"));
        persons.add(new Person(25, "WOMAN", "Piankova"));

        return persons;
    }
}
