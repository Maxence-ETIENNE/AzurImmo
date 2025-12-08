package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.service.AppartementService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/appartements")
public class AppartementController {
	
    @Autowired
    private AppartementService appartementService;

	
    @PostMapping("/")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }
    
    @GetMapping("/list")
    public List<Appartement> getAppartements() {
        return appartementService.getAppartements();
    }
    
    @GetMapping("/show/{id}")
    public Optional<Appartement> getAppartementsById(Long id) {
        return appartementService.getAppartementsById(id);
    }

}