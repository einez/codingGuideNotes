package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by einez on 8/8/2017.
 */
public class DogCatQueue {
    public static abstract class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    private static class DogDelegate {
        private Dog dog;
        private int inQueueSeq;

        private DogDelegate(Dog dog, int inQueueSeq) {
            this.dog = dog;
            this.inQueueSeq = inQueueSeq;
        }
    }

    private static class CatDelegate {
        private Cat cat;
        private int inQueueSeq;

        private CatDelegate(Cat cat, int inQueueSeq) {
            this.cat = cat;
            this.inQueueSeq = inQueueSeq;
        }
    }

    private int inQueueSeq = 0;
    private Queue<DogDelegate> dogs = new LinkedList<>();
    private Queue<CatDelegate> cats = new LinkedList<>();

    public boolean add(Pet pet) {
        if (pet.type == "dog")
            dogs.add(new DogDelegate((Dog) pet, this.inQueueSeq++));
        else if (pet.type == "cat") cats.add(new CatDelegate((Cat) pet, this.inQueueSeq++));
        else return false;
        return true;
    }

    public Pet[] pollAll() {
        int petCount = dogs.size() + cats.size();
        Pet[] ret = new Pet[petCount];
        int i = 0;
        while (!dogs.isEmpty() && !cats.isEmpty()) {
            if (dogs.peek().inQueueSeq < cats.peek().inQueueSeq)
                ret[i++] = dogs.poll().dog;
            else ret[i++] = cats.poll().cat;
        }
        while (!dogs.isEmpty())
            ret[i++] = dogs.poll().dog;
        while (!cats.isEmpty())
            ret[i++] = cats.poll().cat;
        return ret;
    }

    public Dog[] pollDog() {
        int dogCount = dogs.size();
        Dog[] ret = new Dog[dogCount];
        int i = 0;
        while (!dogs.isEmpty())
            ret[i++] = dogs.poll().dog;
        return ret;
    }

    public Cat[] pollCat() {
        int catCount = cats.size();
        Cat[] ret = new Cat[catCount];
        int i = 0;
        while (!cats.isEmpty())
            ret[i++] = cats.poll().cat;
        return ret;
    }

    public boolean isEmpty() {
        return dogs.size() + cats.size() == 0;
    }

    public boolean isDogEmpty() {
        return dogs.size() == 0;
    }

    public boolean isCatEmpty() {
        return cats.size() == 0;
    }
}
