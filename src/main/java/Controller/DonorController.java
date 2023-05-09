package Controller;

import DonorException.DonorException;
import Entity.DonorEntity;
import Repository.DonorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/Donor")
public class DonorController {
    @Autowired
  private DonorRepository donorRepository;
    private Long Id;

    //code for getting all user info
    @GetMapping
    public List<DonorEntity> getAllUser(){
        return donorRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<DonorEntity> getDonorById(@PathVariable long id) {
        DonorEntity getDonor = donorRepository.findById(Id).
                orElseThrow(() -> new DonorException
                        ("Donor does not exist"));
        return  ResponseEntity.ok(getDonor);
    }
    //codes for updating Donor
    @PutMapping("{Id}")
    public ResponseEntity<DonorEntity> UpdateDonor(@PathVariable long Id,@RequestBody DonorEntity DonorDetails){
        DonorEntity UpdateDonor= donorRepository.findById(Id).orElseThrow(()->
             new DonorException("Donor does not exist"));

               UpdateDonor.setUserId(DonorDetails.getUserId());
               UpdateDonor.setUserAddress(DonorDetails.getUserAddress());
               UpdateDonor.setUserContact(DonorDetails.getUserContact());
               UpdateDonor.setUserName(DonorDetails.getUserName());
        donorRepository.save(UpdateDonor);
        return ResponseEntity.ok(UpdateDonor);
    }
    //codes for deleting
    @DeleteMapping("{Id]")
    public ResponseEntity<DonorEntity> deleteUser(Long Id){
        DonorEntity user=donorRepository.findById(Id).orElseThrow(()-> new DonorException("user does not exist"));
        donorRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}
