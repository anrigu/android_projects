package com.example.anrigu.matchinggame;

abstract class Animal {
    abstract public void voice();
}

class Dog extends Animal {
    @Override
    public void voice() {
        System.out.println("bark");
    }
}

class Cat extends Animal {
    @Override
    public void voice() {
        System.out.println("meow");
    }
}

public class AnimalFarm {
    public static void main(String[] args) {
        Animal[] farm = new Animal[] { new Dog(), new Cat(), new Dog()};

        for (Animal a : farm) {
            a.voice();
        }
    }
}