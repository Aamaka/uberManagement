package africa.semicolon.ubermanagement.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserResponse {
    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime = LocalDateTime.now();
}
