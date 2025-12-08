package bts.sio.azurimmo.repository;

import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
}
