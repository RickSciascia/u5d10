package ricksciascia.u5d10.payloads;

import java.time.LocalDateTime;

public record ErrorDTO(String messaggio, LocalDateTime timestampErrore) {
}
