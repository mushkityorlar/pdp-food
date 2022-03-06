package uz.pdp.pdpfood.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ResponseEntity<T> {
    private final T data;
    private final Integer status;

    public ResponseEntity(T data) {
        this(data, HttpStatus.OK);
    }

    public ResponseEntity(T data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
    }
}
