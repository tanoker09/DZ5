import java.util.Objects;
import java.util.UUID;

public class Animal implements Comparable {
    private UUID uid;
    private String name;
    private Person master;
    private Integer weight;

    public Animal(UUID uid, String name, Person master, Integer weight) {
        this.uid = uid;
        this.name = name;
        this.master = master;
        this.weight = weight;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getMaster() {
        return master;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Animal)){
            return 1;
        }

        Animal a = (Animal)o;
        if(!master.equals(a.getMaster())){
            return master.compareTo(a.getMaster());
        }

        if(!(name.equals(a.getName()))){
            return name.compareTo(a.getName());
        }

        return weight.compareTo(a.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return uid.equals(animal.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", master=" + master +
                ", weight=" + weight +
                '}';
    }
}
