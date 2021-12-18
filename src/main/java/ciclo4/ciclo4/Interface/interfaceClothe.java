package ciclo4.ciclo4.Interface;


import ciclo4.ciclo4.Modelo.clothe;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface interfaceClothe extends MongoRepository<clothe, String> {
    public List<clothe> findByPrice(double price);
    public List<clothe> findByDescriptionContainingIgnoreCase(String description);
    //findByDescriptionContainingIgnoreCase
}
