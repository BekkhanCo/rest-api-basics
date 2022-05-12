package dto;



public class BaseResponseDto<T> {

    private int status;
    private String message;
    private T data;

    public BaseResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponseDto(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponseDto() {
    }
}
