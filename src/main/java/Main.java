import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            String command = input.nextLine();
            switch(command) {
                case "/help" -> System.out.println("Бот для парсинга статистики с YouTube и VK \nДоступные команды: \n/YouTube \n/vk \n /exit");
                case "/YouTube" -> System.out.println("Отправьте ссылку на видео YouTube");
                case "/VK" -> System.out.println("Отправьте ссылку на пост VK");
                case "/exit" -> {
                    System.exit(0);
                }
                default -> System.out.println("Список доступных команд - /help");
            };
        }

    }
}
