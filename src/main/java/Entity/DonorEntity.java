package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Donor")
public class DonorEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     Long Id;
    @Column (name = "userId")
    int userId;
    @Column (name = "userName")
    String userName;
    @Column (name = "userContact")
    String userContact;
    @Column (name = "userAddress")
    String userAddress;


}
