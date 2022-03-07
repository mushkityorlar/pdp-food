package uz.pdp.pdpfood.bot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BaseHandler {
    void process(Update update);
}
