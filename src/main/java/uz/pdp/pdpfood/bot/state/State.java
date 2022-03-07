package uz.pdp.pdpfood.bot.state;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class State {
    private Map<Long, UserState> userState = new HashMap<>();

    public UserState getState(Long chatID) {
        for (Map.Entry<Long, UserState> entry : userState.entrySet()) {
            if (entry.getKey().equals(chatID)) return entry.getValue();
        }
        return null;
    }

    public void setState(Long chatID, UserState newState) {
        userState.put(chatID, newState);
    }
}
