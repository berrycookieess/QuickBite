
package QuickBite.boundary;

import QuickBite.boundary.dto.CheckoutRequest;
import QuickBite.boundary.dto.CheckoutResponse;
import QuickBite.controller.CheckoutController;
import QuickBite.controller.dto.CheckoutCommand;
import QuickBite.controller.dto.CheckoutResult;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutBoundary {

    private final CheckoutController checkoutController;

    public CheckoutBoundary(CheckoutController checkoutController) {
        this.checkoutController = checkoutController;
    }

    @PostMapping
    public ResponseEntity<CheckoutResponse> checkout(
            @Valid @RequestBody CheckoutRequest request) {

        CheckoutCommand command = new CheckoutCommand(
                request.idPelanggan(),
                request.tokenKartu(),
                request.keranjang().stream()
                        .map(item -> new CheckoutCommand.Item(
                                item.idMenu(), item.qty()))
                        .collect(Collectors.toList())
        );

        CheckoutResult result =
                checkoutController.prosesCheckout(request.toCommand());

        return ResponseEntity.ok(
                new CheckoutResponse(
                        result.idPesanan(),
                        result.total()
                )
        );
    }
}
