
package QuickBite.boundary.dto;

import QuickBite.controller.dto.CheckoutCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record CheckoutRequest(
        @NotBlank String idPelanggan,
        @NotBlank String tokenKartu,
        @NotEmpty List<@Valid ItemRequest> keranjang
) {

    public record ItemRequest(
            @NotBlank String idMenu,
            @NotNull Integer qty
    ) {}

    public CheckoutCommand toCommand() {
        return new CheckoutCommand(
                idPelanggan,
                tokenKartu,
                keranjang.stream()
                        .map(item -> new CheckoutCommand.Item(
                                item.idMenu(),
                                item.qty()
                        ))
                        .collect(Collectors.toList())
        );
    }
}
