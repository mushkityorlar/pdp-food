package uz.pdp.pdpfood.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum MealType {
    FAST_FOOD("fastfood"),
    SOUP("soup"),
    FOOD("food");

    private String name;
}
