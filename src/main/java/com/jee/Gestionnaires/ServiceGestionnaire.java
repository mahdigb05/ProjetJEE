package com.jee.Gestionnaires;

import com.jee.Beans.Utilisateur;
import com.jee.Repositories.ServiceDAO;
import com.jee.Repositories.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceGestionnaire {
    @Autowired
    private ServiceDAO serviceDAO;

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public void ajouterService(String email,String desc, String etat){
        com.jee.Beans.Service service = new com.jee.Beans.Service();
        Utilisateur user = utilisateurDAO.findByEmail(email);
        service.setDescription(desc);
        service.setEtat(etat);
        service.setUtilisateur(user);
        serviceDAO.save(service);
    }
    public void modifierService(@Valid com.jee.Beans.Service service){
        serviceDAO.save(service);
    }

    public void supprimerService(Long id_service){
        serviceDAO.deleteById(id_service);
    }
    public com.jee.Beans.Service getServiceById(Long id_service){
        Optional<com.jee.Beans.Service> service = serviceDAO.findById(id_service);
        return service.orElse(null);
    }
    public List<com.jee.Beans.Service> getAllService(){
        return (List<com.jee.Beans.Service>) serviceDAO.findAll();
    }

}
