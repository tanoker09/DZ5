import sun.reflect.generics.tree.Tree;

import java.util.*;

public class AnimalFiles {
    //контейнер всех питомцев
    private HashMap<UUID, Animal> data = new HashMap<>();
    //контейнер всех питомцев по кличкам для поиска
    private HashMap<String, TreeSet<Animal>> indexNames = new HashMap<>();

    /**
     *
     * @param newAnimal новое животное для добавления
     * @return
     * @throws Exception
     */
    public UUID add(Animal newAnimal) throws Exception {
        if(newAnimal.getUid() == null){
            //если нету идентификатора, то создаем его
            newAnimal.setUid(UUID.randomUUID());
        }
        if(!data.containsKey(newAnimal.getUid())){
            data.put(newAnimal.getUid(), newAnimal);
        }
        else{
            throw new Exception("Такой питомец уже есть в списке");
        }
        //добавляем питомца в контейнер для поиска по кличке
        if(indexNames.containsKey(newAnimal.getName())){
            indexNames.get(newAnimal.getName()).add(newAnimal);
        }else{
            indexNames.put(newAnimal.getName(), new TreeSet<>());
            indexNames.get(newAnimal.getName()).add(newAnimal);
        }
        return newAnimal.getUid();
    }
    public void update(Animal newAnimal){
        if(!data.containsKey(newAnimal.getUid())){
            return;
        }
        //обновляем сразу все значения
        Animal animal = data.get(newAnimal.getUid());

        indexNames.get(newAnimal.getName()).remove(animal);
        indexNames.get(newAnimal.getName()).add(newAnimal);

        data.put(newAnimal.getUid(), newAnimal);
    }

    public ArrayList<Animal> getAnimalByName(String name){
        if(name == null)
            return new ArrayList<>();

        return new ArrayList<>(indexNames.get(name));
    }

    public Animal getAnimalByUuid(UUID uuid){
        return data.get(uuid);
    }

    @Override
    public String toString() {
        TreeSet<Animal> toCmd = new TreeSet<>(data.values());
        return toCmd.toString();
    }
}
