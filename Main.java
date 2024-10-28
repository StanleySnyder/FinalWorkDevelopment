import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("1. Add new animal");
            System.out.println("2. List animal commands");
            System.out.println("3. Train new command");
            System.out.println("4. List animals by birth date");
            System.out.println("5. Exit");

            command = scanner.nextLine();

            switch (command) {
                case "1":
                    addAnimal(scanner);
                    break;
                case "2":
                    listAnimalCommands(scanner);
                    break;
                case "3":
                    trainNewCommand(scanner);
                    break;
                case "4":
                    listAnimalsByBirthDate();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    System.out.println("Total number of animals created: " + Animal.getAnimalCount());
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    static void addAnimal(Scanner scanner) {
        System.out.println("Enter animal type (Dog, Cat, Hamster, Horse, Donkey):");
        String type = scanner.nextLine();
        System.out.println("Enter animal name:");
        String name = scanner.nextLine();
        System.out.println("Enter birth date (YYYY-MM-DD):");
        String birthDate = scanner.nextLine();
        System.out.println("Enter commands (comma separated):");
        String[] commands = scanner.nextLine().split(", ");

        switch (type.toLowerCase()) {
            case "dog":
                animals.add(new Dog(name, birthDate, commands));
                break;
            case "cat":
                animals.add(new Cat(name, birthDate, commands));
                break;
            case "hamster":
                animals.add(new Hamster(name, birthDate, commands));
                break;
            case "horse":
                animals.add(new Horse(name, birthDate, commands));
                break;
            case "donkey":
                animals.add(new Donkey(name, birthDate, commands));
                break;
            default:
                System.out.println("Invalid animal type.");
        }
    }

    static void listAnimalCommands(Scanner scanner) {
        System.out.println("Enter animal name:");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.name.equals(name)) {
                if (animal instanceof Pet) {
                    ((Pet) animal).performCommands();
                } else if (animal instanceof PackAnimal) {
                    ((PackAnimal) animal).performCommands();
                }
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    static void trainNewCommand(Scanner scanner) {
        System.out.println("Enter animal name:");
        String name = scanner.nextLine();
        System.out.println("Enter new command:");
        String newCommand = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.name.equals(name)) {
                if (animal instanceof Pet) {
                    String[] newCommands = new String[((Pet) animal).commands.length + 1];
                    System.arraycopy(((Pet) animal).commands, 0, newCommands, 0, ((Pet) animal).commands.length);
                    newCommands[newCommands.length - 1] = newCommand;
                    ((Pet) animal).commands = newCommands;
                } else if (animal instanceof PackAnimal) {
                    String[] newCommands = new String[((PackAnimal) animal).commands.length + 1];
                    System.arraycopy(((PackAnimal) animal).commands, 0, newCommands, 0, ((PackAnimal) animal).commands.length);
                    newCommands[newCommands.length - 1] = newCommand;
                    ((PackAnimal) animal).commands = newCommands;
                }
                System.out.println(name + " has learned a new command: " + newCommand);
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    static void listAnimalsByBirthDate() {
        animals.sort((a1, a2) -> a1.birthDate.compareTo(a2.birthDate));
        for (Animal animal : animals) {
            System.out.println(animal.name + " - " + animal.birthDate);
        }
    }
}

