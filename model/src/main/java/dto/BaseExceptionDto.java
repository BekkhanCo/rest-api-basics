package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BaseExceptionDto {
    private int HttpStatus;
    private String errorMessage;
    private int errorCode;

    public BaseExceptionDto(int httpStatus, String errorMessage, int errorCode) {
        HttpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public BaseExceptionDto() {
    }
}
