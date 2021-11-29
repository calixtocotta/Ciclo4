
package ciclo4.ciclo4.Modelo;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author calix
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User{
   
    @Id
    private Integer id;
    private String identification;
    private String name;
    private String address;
    private Integer cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
    
        
}
