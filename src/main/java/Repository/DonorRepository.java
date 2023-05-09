package Repository;


import Entity.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<DonorEntity,Long> {

    /* All crud methods for database */
}
