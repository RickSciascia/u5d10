package ricksciascia.u5d10.payloads;

import jakarta.validation.constraints.NotNull;

public record StatusViaggioDTO(
        @NotNull
        boolean completato) {
}
