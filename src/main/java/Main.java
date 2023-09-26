import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            String command = input.nextLine();
            String s = switch(command) {
                case "/help" -> "Бот для парсинга статистики с YouTube и VK \nДоступные команды: \n/YouTube \n/vk \n /exit";
                case "/YouTube" -> "Отправьте ссылку на видео YouTube";
                case "/VK" -> "Отправьте ссылку на пост VK";
                case "/exit" -> throw new IllegalArgumentException("Выход");
                default -> "Список доступных команд - /help";
            };
            System.out.println(s);
        }

    }
}
