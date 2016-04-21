package mvc.data.repository;

import mvc.data.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvocesJpaRepository extends JpaRepository<Invoices, Long> {
}
