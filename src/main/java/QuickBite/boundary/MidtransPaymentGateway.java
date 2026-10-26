package QuickBite.boundary;

import org.springframework.stereotype.Component;

@Component
public class MidtransPaymentGateway implements PaymentGatewayAPI {

    @Override
    public String mintaTransaksiPembayaran(
            double total,
            String tokenKartu
    ) {
        throw new UnsupportedOperationException(
                "Integrasi payment gateway belum dikonfigurasi."
        );
    }
}

