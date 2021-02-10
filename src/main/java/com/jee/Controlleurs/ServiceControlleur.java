package com.jee.Controlleurs;

import com.jee.Beans.Service;
import com.jee.Gestionnaires.ServiceGestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")

public class ServiceControlleur {

    @Autowired
    private ServiceGestionnaire serviceGestionnaire;

    @PostMapping("/ajouterService")
    @RolesAllowed({"ETUDIANT"})
    public ResponseEntity<?> ajouterService(@RequestBody HashMap<String,Object> map ){
        String email = (String) map.get("email");
        String desc = (String) map.get("description");
        String etat = (String) map.get("etat");
        serviceGestionnaire.ajouterService(email,desc,etat);
        return new ResponseEntity<>("service ajouter avec succes", HttpStatus.OK);
    }

    @PutMapping("/modifierService")
    @RolesAllowed({"ADMINISTRATEUR"})
    public ResponseEntity<?> modifierService(@Valid @RequestBody Service service){
        serviceGestionnaire.modifierService(service);
        return new ResponseEntity<Service>(service, HttpStatus.OK);
    }

    @GetMapping("/services")
    @RolesAllowed({"ADMINISTRATEUR","ETUDIANT"})
    public Collection<Service> getAllServices(){
        Collection<Service> services = serviceGestionnaire.getAllService();
        return services;
    }

    @GetMapping("/service/{id_service}")
    @RolesAllowed({"ETUDIANT", "ADMINISTRATEUR"})
    public ResponseEntity<?> getServiceById(@PathVariable Long id_service){
        return new ResponseEntity<>(serviceGestionnaire.getServiceById(id_service), HttpStatus.OK);
    }

    @DeleteMapping("/supprimerService/{id_service}")
    @RolesAllowed({"ADMINISTRATEUR","ETUDIANT"})
    public ResponseEntity<?> supprimerService(@PathVariable Long id_service){
        serviceGestionnaire.supprimerService(id_service);
        return new ResponseEntity<>("Service supprimer avec succes", HttpStatus.OK);
    }
}
