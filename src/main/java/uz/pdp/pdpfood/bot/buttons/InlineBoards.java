package uz.pdp.pdpfood.bot.buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.pdpfood.bot.utils.Emojis;
import uz.pdp.pdpfood.dto.department.DepartmentDto;
import uz.pdp.pdpfood.service.department.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InlineBoards {
    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();
    private final DepartmentServiceImpl departmentService;

    public InlineBoards(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public InlineKeyboardMarkup languageButtons() {
        InlineKeyboardButton uz = new InlineKeyboardButton(Emojis.UZ + " Uzbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru = new InlineKeyboardButton(Emojis.RU + " Uzbek");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " Uzbek");
        en.setCallbackData("en");

        board.setKeyboard(Arrays.asList(List.of(uz), List.of(ru), List.of(en)));
        return board;
    }

    public InlineKeyboardMarkup departmentButtons() {
        List<DepartmentDto> departmentDtos = departmentService.getAll();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();

        for (DepartmentDto departmentDto : departmentDtos) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(departmentDto.getName());
            inlineKeyboardButton.setCallbackData(departmentDto.getName());
            lists.add(List.of(inlineKeyboardButton));
        }

      /*  InlineKeyboardButton mentors = new InlineKeyboardButton("Mentors D");
        mentors.setCallbackData("mentors");

        InlineKeyboardButton economic = new InlineKeyboardButton("Economic D");
        economic.setCallbackData("economic");

        InlineKeyboardButton sales = new InlineKeyboardButton("Sales D");
        sales.setCallbackData("sales");
*/
        board.setKeyboard(lists);
        return board;
    }

    public ReplyKeyboard forHeadButtons(Long chatId) {
        InlineKeyboardButton yes = new InlineKeyboardButton("Yes");
        yes.setCallbackData("yes" + chatId);

        InlineKeyboardButton no = new InlineKeyboardButton("No");
        no.setCallbackData("no " + chatId);

        board.setKeyboard(List.of(List.of(yes, no)));
        return board;
    }
}

