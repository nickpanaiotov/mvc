package hello.data.repository;

import hello.data.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvocesJpaRepository extends JpaRepository<Invoices, Long> {
}
