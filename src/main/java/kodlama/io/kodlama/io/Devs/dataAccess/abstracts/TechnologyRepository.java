package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology,Integer>{

}
