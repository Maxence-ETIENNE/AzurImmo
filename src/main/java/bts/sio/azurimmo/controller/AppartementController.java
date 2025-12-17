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
    
    @GetMapping("/")
    public List<Appartement> getAppartements() {
    	
    	System.out.println("NBAPPT" + appartementService.getAppartements().size());
        return appartementService.getAppartements();
    }
    
    @GetMapping("/show/{id}")
    public Optional<Appartement> getAppartementsById(@PathVariable Long id) {
        return appartementService.getAppartementsById(id);
    }
    
    @GetMapping("/ville={ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @GetMapping("/batiment={batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
    	return appartementService.getAppartementsParBatiment(batimentId);
    }
    
    @GetMapping("/surface={surface}")
    public List<Appartement> getAppartementsSupSurface(@PathVariable float surface) {
    	return appartementService.getAppartementsSupSurface(surface);
    }

}