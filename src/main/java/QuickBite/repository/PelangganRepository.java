
package QuickBite.repository;

import QuickBite.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository
        extends JpaRepository<Pelanggan, String> {
}
