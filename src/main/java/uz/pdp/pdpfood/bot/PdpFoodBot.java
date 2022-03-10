package uz.pdp.pdpfood.bot;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.pdpfood.bot.handlers.UpdateHandler;

@Component
public class PdpFoodBot extends TelegramLongPollingBot {

    private final UpdateHandler handler;

    public PdpFoodBot(@Lazy UpdateHandler handler) {
        this.handler = handler;
    }

    public void run() {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new PdpFoodBot(handler));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        handler.handle(update);
    }


    @Override
    public String getBotToken() {
        return "5261867840:AAHsyqYzi9DwygsAs6Kat5rEFIbs8xlIBIE";
    }

    @Override
    public String getBotUsername() {
        return "@nodir_dot_common_bot";
    }

    public void executePhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeMessage(BotApiMethod<?> message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
