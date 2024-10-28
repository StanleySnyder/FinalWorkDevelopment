class Animal {
    static int animalCount = 0;
    String name;
    String birthDate;

    Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalCount++;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Pet extends Animal {
    String[] commands;

    Pet(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    public void performCommands() {
        System.out.println(name + " can perform: " + String.join(", ", commands));
    }
}

class Dog extends Pet {
    Dog(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Cat extends Pet {
    Cat(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Hamster extends Pet {
    Hamster(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class PackAnimal extends Animal {
    String[] commands;

    PackAnimal(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    public void performCommands() {
        System.out.println(name + " can perform: " + String.join(", ", commands));
    }
}

class Horse extends PackAnimal {
    Horse(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Donkey extends PackAnimal {
    Donkey(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

