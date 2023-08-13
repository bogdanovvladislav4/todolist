import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    // TODO: написать консольное приложение для работы со списком дел todoList

    public static void main(String[] args) {
        System.out.println("Выберите одну из команд и введите дело: " +
                "\n ADD " +
                "\n EDIT " +
                "\n DELETE " +
                "\n LIST ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String[] act;

            if (input.matches("ADD\\s\\d+\\s\\w.+")) {
                act = input.split(" ", 3);
                System.out.printf("Добавлено дело %s%n", act[2]);
                System.out.printf("на позицию %s%n", act[1]);
                todoList.add(Integer.parseInt(act[1]), act[2]);

            } else if (input.matches("ADD\\s.+")) {
                act = input.split(" ", 2);
                System.out.printf("Добавлено дело %s%n", act[1]);
                todoList.add(act[1]);

            } else if (input.matches("EDIT\\s\\d+\\s\\w.+")) {
                act = input.split(" ", 3);
                todoList.edit(act[2], (Integer.parseInt(act[1])-1));

            } else if (input.matches("DELETE\\s\\d+")) {
                act = input.split(" ", 2);
                todoList.delete((Integer.parseInt(act[1]))-1);

            } else if (input.equals("LIST")) {
                for (int todo = 0; todo < todoList.getTodos().size(); todo++) {
                    int index = todo + 1;
                    System.out.println(index + " - " + todoList.getTodos().get(todo));
                }
            } else {
                System.out.println("Неверная команда");
            }
        }
    }
}
