package uz.pdp.pdpfood.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum     Language {
    ENGLISH("en"),
    RUSSIAN("ru"),
    UZBEK("uz");

    private String code;
}
