package uz.pdp.pdpfood.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateHandler {
    private final MessageHandler messageHandler;
    private final CallbackHandler callbackHandler;

    public UpdateHandler(MessageHandler messageHandler, CallbackHandler callbackHandler) {
        this.messageHandler = messageHandler;
        this.callbackHandler = callbackHandler;
    }

    public void handle(Update update) {
        if (update.hasMessage()) messageHandler.process(update);
        else if (update.hasCallbackQuery()) callbackHandler.process(update);
    }
}
