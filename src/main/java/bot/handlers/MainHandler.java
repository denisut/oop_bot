package bot.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainHandler extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "mathmechluchevsehBot";
    }

    @Override
    public String getBotToken() { return "6574409936:AAGHRUr8BMeJrNckwds8Pi-xVirYl8mTr4w"; }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String inputText = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId());

            Pattern pattern = Pattern.compile("^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube(-nocookie)?\\.com|youtu\\.be))(\\/(?:[\\w\\-]+\\?v=|embed\\/|live\\/|v\\/)?)([\\w\\-]+)(\\S+)?$");
            Matcher matcher = pattern.matcher(inputText);

            if (inputText.startsWith("/")) {
                inputText = inputText.substring(1).toLowerCase();
                switch (inputText) {
                    case "start" -> {
                        message.setText(
                                "Привет! Я - бот для парсинга статистики видео с YouTube. \n\nОтправь ссылку на видео");
                    }
                    case "help" -> {
                        message.setText("Отправь ссылку на видео");
                    }
                    default -> {
                        message.setText("Такой команды нет");
                    }
                }
            } else if (matcher.matches()) {
                YoutubeHandler youtubeHandler = new YoutubeHandler(matcher.group(6));
                message.setText(youtubeHandler.getAnswer());
            } else {
                message.setText("Упс...Не получилось найти видео. Наверно, неверная ссылка. Попробуй еще раз.");
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
