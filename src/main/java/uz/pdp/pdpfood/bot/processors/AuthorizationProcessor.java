package uz.pdp.pdpfood.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdpfood.bot.PdpFoodBot;
import uz.pdp.pdpfood.bot.buttons.InlineBoards;
import uz.pdp.pdpfood.bot.buttons.MarkupBoards;
import uz.pdp.pdpfood.bot.state.State;
import uz.pdp.pdpfood.bot.state.UserState;
import uz.pdp.pdpfood.bot.utils.Emojis;
import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.service.user.UserServiceImpl;

import java.io.File;
import java.util.Objects;

@Component
public class AuthorizationProcessor {

    private final PdpFoodBot bot;
    private final State state;
    private final UserServiceImpl userService;
    private final InlineBoards inlineBoards;
    private final MarkupBoards markupBoards;

    public AuthorizationProcessor(PdpFoodBot bot, State state, UserServiceImpl userService, InlineBoards inlineBoards, MarkupBoards markupBoards) {
        this.bot = bot;
        this.state = state;
        this.userService = userService;
        this.inlineBoards = inlineBoards;
        this.markupBoards = markupBoards;
    }

    public void process(Update update, UserState state) {
        Message message = update.getMessage();
        long chatID = message.getChatId();
        User user = message.getFrom();
        UserCreateDto authCreateDto = new UserCreateDto();
        if (Objects.isNull(state)) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(message.getChatId().toString());
            sendPhoto.setPhoto(new InputFile(new File("src/main/resources/statics/logo.png")));
            sendPhoto.setCaption("Welcome to our %s %s".formatted("PDPFoodBot", user.getFirstName()));
            bot.executePhoto(sendPhoto);

            SendMessage sendMessage = messageObj(chatID, "Choose language please");
            sendMessage.setReplyMarkup(inlineBoards.languageButtons());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.LANGUAGE);
        } else if (UserState.LANGUAGE.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        } else if (UserState.DEPARTMENT.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        } else if (UserState.DEPARTMENT_CHOSEN.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatID, message.getMessageId()));
        } else if (UserState.DEPARTMENT_ACCEPTED.equals(state)) {
            authCreateDto.setFullName(message.getText());
            SendMessage sendMessage = messageObj(chatID, "Your password please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.PASSWORD);
        } else if (UserState.PASSWORD.equals(state)) {
            authCreateDto.setPassword(message.getText());
            SendMessage sendMessage = messageObj(chatID, Emojis.PHONE + "Share your phone number please");
            sendMessage.setReplyMarkup(MarkupBoards.sharePhoneNumber());
            bot.executeMessage(sendMessage);
            changeState(chatID, UserState.PHONE);
        } else if (UserState.PHONE.equals(state)) {
            if (message.hasContact()) {
                authCreateDto.setPhoneNumber(message.getContact().getPhoneNumber());
                SendMessage sendMessage = messageObj(chatID, "Enter your position");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                changeState(chatID, UserState.POSITION);
            } else {
                authCreateDto.setPhoneNumber(message.getText());
                SendMessage sendMessage = messageObj(chatID, "Enter your position");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                changeState(chatID, UserState.POSITION);
            }
        }
        /*else if (UserState.POSITION.equals(state)) {
            authCreateDto.setPosition(message.getText());
            SendMessage sendMessage = messageObj(chatID, "Successfully registered");
            sendMessage.setReplyMarkup(MarkupBoards.mainMenu());
            bot.executeMessage(sendMessage);
            authCreateDto.setRole("EMPLOYEE");
            authCreateDto.setStatus("ACTIVE");
            authCreateDto.setChatId(chatID);
            userService.create(authCreateDto);
            changeState(chatID, UserState.AUTHORIZED);
        }*/
    }

    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage(String.valueOf(chatID), text);
    }
}
