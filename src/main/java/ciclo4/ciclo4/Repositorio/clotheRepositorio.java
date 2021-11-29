
package ciclo4.ciclo4.Repositorio;

import ciclo4.ciclo4.Interface.interfaceClothe;
import ciclo4.ciclo4.Modelo.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class clotheRepositorio {
    
    @Autowired
    private interfaceClothe crud;

    public List<Clothe> getAll() {
        return crud.findAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return crud.findById(reference);
    }

    public Clothe create(Clothe clothe) {
        return crud.save(clothe);
    }

    public void update(Clothe clothe) {
        crud.save(clothe);
    }

    public void delete(Clothe clothe) {
        crud.delete(clothe);
    }
}
