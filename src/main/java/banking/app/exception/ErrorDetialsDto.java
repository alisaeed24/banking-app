package banking.app.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetialsDto {
   private LocalDateTime timestamp;
   private String message;
   private String detials;
   private String errorCode;

}
