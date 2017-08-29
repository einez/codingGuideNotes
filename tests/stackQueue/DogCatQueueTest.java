package stackQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * poll应该返回一个有序数组然后检验各出队实例是否相符
 */
public class DogCatQueueTest {
    DogCatQueue dogCatQueue;
    Random random;
    DogCatQueue.Dog[] genDogs;
    DogCatQueue.Cat[] genCats;
    DogCatQueue.Dog[] dogsInQueue;
    DogCatQueue.Cat[] catsInQueue;
    DogCatQueue.Pet[] petsInQueue;

    @Before
    public void init() {
        dogCatQueue = new DogCatQueue();
        random = new Random();
        genDogs = new DogCatQueue.Dog[5];
        genCats = new DogCatQueue.Cat[genDogs.length];
        dogsInQueue = new DogCatQueue.Dog[genDogs.length * 2];
        catsInQueue = new DogCatQueue.Cat[genCats.length * 2];
        petsInQueue = new DogCatQueue.Pet[dogsInQueue.length + catsInQueue.length];
        for (int i = 0; i < genDogs.length; i++) {
            genDogs[i] = new DogCatQueue.Dog();
        }
        for (int i = 0; i < genCats.length; i++) {
            genCats[i] = new DogCatQueue.Cat();
        }
        for (int i = 0, j = 0; i + j < petsInQueue.length; ) {
            if (i == dogsInQueue.length || j < catsInQueue.length && random.nextInt(2) == 1) {
                catsInQueue[j] = genCats[random.nextInt(genCats.length)];
                petsInQueue[i + j] = catsInQueue[j];
                j++;
            } else {
                dogsInQueue[i] = genDogs[random.nextInt(genDogs.length)];
                petsInQueue[j + i] = dogsInQueue[i];
                i++;
            }
        }
        for (int i = 0; i < petsInQueue.length; i++) {
            dogCatQueue.add(petsInQueue[i]);
        }
    }

    @Test
    public void add() throws Exception {
        for (int i = 0; i < dogsInQueue.length; i++) {
            assertTrue(dogCatQueue.add(dogsInQueue[i]));
            assertTrue(dogCatQueue.add(catsInQueue[i]));
        }
    }

    @Test
    public void pollAll() throws Exception {
        DogCatQueue.Pet[] retPets = dogCatQueue.pollAll();
        for (int i = 0; i < petsInQueue.length; i++) {
            assertSame(petsInQueue[i], retPets[i]);
        }
    }

    @Test
    public void pollDog() throws Exception {
        DogCatQueue.Dog[] retDogs = dogCatQueue.pollDog();
        for (int i = 0; i < dogsInQueue.length; i++) {
            assertSame(dogsInQueue[i], retDogs[i]);
        }
    }

    @Test
    public void pollCat() throws Exception {
        DogCatQueue.Cat[] retCats = dogCatQueue.pollCat();
        for (int i = 0; i < catsInQueue.length; i++) {
            assertSame(catsInQueue[i], retCats[i]);
        }
    }

    @Test
    public void isEmpty() throws Exception {
        dogCatQueue.pollAll();
        assertTrue(dogCatQueue.isEmpty());
    }

    @Test
    public void isDogEmpty() throws Exception {
        dogCatQueue.pollDog();
        assertTrue(dogCatQueue.isDogEmpty());
    }

    @Test
    public void isCatEmpty() throws Exception {
        dogCatQueue.pollCat();
        assertTrue(dogCatQueue.isCatEmpty());
    }

}