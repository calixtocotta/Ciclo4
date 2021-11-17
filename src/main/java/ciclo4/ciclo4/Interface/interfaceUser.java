package ciclo4.ciclo4.Interface;

import ciclo4.ciclo4.Modelo.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface interfaceUser extends CrudRepository<User, Integer> {

   public User findAllByEmailAndPassword(String email,String password);
   
   boolean existsByEmail(String email);
}
