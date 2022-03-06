package uz.pdp.pdpfood.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpStatus {
    INVALID_TOKEN(440, "Invalid Token"),
    BAD_REQUEST(400, "Bad Request");

    private final Integer code;
    private final String message;
}
