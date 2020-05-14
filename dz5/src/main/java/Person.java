import java.util.Objects;

public class Person implements Comparable{
    private int age;
    private String sex;
    private String name;

    public Person(int age, String sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 100 || age <= 0){
            throw new IllegalArgumentException("Возраст должен быть от 0 до 100");
        }
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if(sex == null){
            throw new IllegalArgumentException("Пол оказался null");
        }
        if(sex.equals("MAN") || sex.equals("WOMAN")){
            this.sex = sex;
        }
        else{
            throw new IllegalArgumentException("Пол должен быть одной из строк: 'MAN', 'WOMAN'");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Имя - null");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        if(!(o instanceof Person)){
            return 1;
        }

        Person a = (Person)o;

        if(!sex.equals(a.getSex())){
            return sex.equals("WOMAN") ? -1 : 1;
        }

        if(age != a.getAge()){
            return ((Integer)age).compareTo(((Integer)a.getAge()));
        }

        return name.compareTo(a.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                sex.equals(person.sex) &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, name);
    }
}
