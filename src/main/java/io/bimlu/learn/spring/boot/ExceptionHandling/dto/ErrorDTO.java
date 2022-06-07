package io.bimlu.learn.spring.boot.ExceptionHandling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ErrorDTO {

    public String title;
    public String detail;
    public int status;
    public String errorType;
    public String errorCode;
    public String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern(
            "yyyy-MM-dd hh:mm:ss a z Z"));

    public ErrorDTO(String title, String detail, int status, String errorType,
                    String errorCode) {
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.errorType = errorType;
        this.errorCode = errorCode;
    }
}
