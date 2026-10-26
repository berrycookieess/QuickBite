package QuickBite.boundary.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CheckoutRequest(
        @NotBlank String idPelanggan,
        @NotBlank String tokenKartu,
        @NotEmpty List<@Valid ItemRequest> keranjang
) {
    public record ItemRequest(
            @NotBlank String idMenu,
            @NotNull Integer qty
    ) {
    }
}

