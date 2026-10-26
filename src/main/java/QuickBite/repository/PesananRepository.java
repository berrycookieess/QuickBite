package QuickBite.repository;

import QuickBite.entity.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesananRepository
        extends JpaRepository<Pesanan, String> {
}
