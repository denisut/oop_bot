package bot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Привет, список доступных команд - /help");

        while (true) {
            String command = input.nextLine();
            setCommand(command.toLowerCase());
        }
    }

    public static void setCommand(String command) {
        switch (command) {
            case "/help" -> System.out.println(
                    "Бот для парсинга статистики с YouTube и VK \nДоступные команды: \n/YouTube \n/vk \n/exit");
            case "/youtube" -> System.out.println("Отправьте ссылку на видео YouTube");
            case "/vk" -> System.out.println("Отправьте ссылку на пост VK");
            case "/exit" -> {
                System.exit(0);
            }
            default -> System.out.println("Список доступных команд - /help");
        }
    }
}
