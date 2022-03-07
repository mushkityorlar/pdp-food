package uz.pdp.pdpfood.bot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.pdp.pdpfood.bot.PdpFoodBot;
import uz.pdp.pdpfood.bot.state.State;
import uz.pdp.pdpfood.bot.state.UserState;
import uz.pdp.pdpfood.dto.meal.MealDto;
import uz.pdp.pdpfood.service.meal.MealServiceImpl;

import java.time.LocalDate;
import java.util.List;

@Component
public class MainProcessor {

    private final State state;
    private final PdpFoodBot bot;
    private final MealServiceImpl mealService;

    public MainProcessor(State state, PdpFoodBot bot, MealServiceImpl mealService) {
        this.state = state;
        this.bot = bot;
        this.mealService = mealService;
    }


    public void process(Update update, UserState state) {
        Message message = update.getMessage();
        long chatId = message.getChatId();
        User user = message.getFrom();

//        if (UserState.ORDER_MEAL.equals(state)) {
//            List<MealDto> mealDtos = mealService.getAllByDate(LocalDate.now().toString());
//            SendMessage sendMessage = messageObj(chatId, getDataMeals(mealDtos));
//            bot.executeMessage(sendMessage);
//        }

    }

    private String getDataMeals(List<MealDto> mealDtos) {
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 1;
        for (MealDto mealDto : mealDtos) {
            stringBuilder.append(String.format("%s. %s \n", i++, mealDto.getName()));
        }
        return stringBuilder.toString();
    }


    private void changeState(long chatID, UserState newState) {
        state.setState(chatID, newState);
    }

    private SendMessage messageObj(long chatID, String text) {
        return new SendMessage(String.valueOf(chatID), text);
    }
}
