package QuickBite.boundary;

public interface PaymentGatewayAPI {

    String mintaTransaksiPembayaran(
            double total,
            String tokenKartu
    );
}

