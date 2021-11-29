package ciclo4.ciclo4.Servicios;

import ciclo4.ciclo4.Modelo.Clothe;
import ciclo4.ciclo4.Repositorio.clotheRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosClothe {

    @Autowired
    private clotheRepositorio metodosCrud;

        public List<Clothe> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return metodosCrud.getClothe(reference);
    }

    public Clothe create(Clothe accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return metodosCrud.create(accesory);
        }
    }

    public Clothe update(Clothe clothe){
        if (clothe.getReference()!= null){
            Optional<Clothe> clotheDb = metodosCrud.getClothe(clothe.getReference());
            if (!clotheDb.isEmpty()){
                if (clothe.getReference()!=null){
                    clotheDb.get().setReference(clothe.getReference());
                }
                if (clothe.getCategory()!=null){
                    clotheDb.get().setCategory(clothe.getCategory());
                }
                if (clothe.getSize()!=null){
                    clotheDb.get().setSize(clothe.getSize());
                }
                if (clothe.getDescription()!=null){
                    clotheDb.get().setDescription(clothe.getDescription());
                }
                if (clothe.getPrice()!= 0.0){
                    clotheDb.get().setPrice(clothe.getPrice());
                }
                if (clothe.getQuantity()!=0){
                    clotheDb.get().setQuantity(clothe.getQuantity());
                }
                if (clothe.getPhotography()!=null){
                    clotheDb.get().setPhotography(clothe.getPhotography());
                }
                clotheDb.get().setAvailability(clothe.isAvailability());
                metodosCrud.update(clotheDb.get());
                return clotheDb.get();
            }else{
                return clothe;
            }
        }else{
            return clothe;
        }
    }

    public boolean delete(String reference){
        boolean del = getClothe(reference).map(clothe -> {
            metodosCrud.delete(clothe);
            return true;
        }).orElse(false);
        return del;
    }

}
