package uz.pdp.pdpfood.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.pdpfood.bot.buttons.MarkupBoards;
import uz.pdp.pdpfood.bot.processors.AuthorizationProcessor;
import uz.pdp.pdpfood.bot.processors.MainProcessor;
import uz.pdp.pdpfood.bot.state.State;
import uz.pdp.pdpfood.bot.state.UserState;
import uz.pdp.pdpfood.entity.user.AuthUser;

import java.io.File;

@Component
public class MessageHandler implements BaseHandler {

    private final AuthorizationProcessor authorizationProcessor;
    private final MainProcessor mainProcessor;
    private final State state;

    public MessageHandler(AuthorizationProcessor authorizationProcessor, MainProcessor mainProcessor, State state) {
        this.authorizationProcessor = authorizationProcessor;
        this.mainProcessor = mainProcessor;
        this.state = state;
    }

    @Override
    public void process(Update update) {
        long chatId = update.getMessage().getChatId();

        if (!isAuthorized(chatId)) {
            authorizationProcessor.process(update, state.getState(chatId));
        }

        //getUsersByChatId(""+chatId);
        AuthUser user = new AuthUser();

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId("" + chatId);
        if (user.getRoles().equals("ADMIN")) {
            sendPhoto.setReplyMarkup(MarkupBoards.adminMainMenu());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/contentManager.jpg")));
        } else if (user.getRoles().equals("DELIVER")) {
            sendPhoto.setReplyMarkup(MarkupBoards.deliverMainMenu());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/headDepartment.jpg")));
        }


        if (update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            if (text.equals("Order meal")) {
                changeState(chatId, UserState.ORDER_MEAL);
            } else if (text.equals("Cancel order")) {
                changeState(chatId, UserState.CANCEL_ORDER);
            } else if (text.equals("Update order")) {
                changeState(chatId, UserState.UPDATE_ORDER);
            } else if (text.equals("Write Comment")) {
                changeState(chatId, UserState.WRITE_COMMENT);
            } else if (text.equals("Settings")) {
                changeState(chatId, UserState.SETTINGS);
            } else if (text.equals("Users")) {
                changeState(chatId, UserState.USERS);
            } else if (text.equals("My orders")) {
                changeState(chatId, UserState.MY_ORDERS);
            } else if (text.equals("Today orders")) {
                changeState(chatId, UserState.TODAY_ORDERS);
            } else if (text.equals("Add meals")) {
                changeState(chatId, UserState.ADD_MEALS);
            } else if (text.equals("Update meals")) {
                changeState(chatId, UserState.UPDATE_MEALS);
            }
            mainProcessor.process(update, state.getState(chatId));
        }
    }

    private boolean isAuthorized(long chatId) {
        return UserState.AUTHORIZED.equals(state.getState(chatId));
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }
}

