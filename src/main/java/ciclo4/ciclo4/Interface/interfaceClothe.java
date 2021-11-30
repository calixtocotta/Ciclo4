package ciclo4.ciclo4.Interface;


import ciclo4.ciclo4.Modelo.clothe;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface interfaceClothe extends MongoRepository<clothe, String> {
    //Lo utilizo porque con findById siempre me devuelve null
   //Optional<Clothe> findByReference(String reference);
    
}
