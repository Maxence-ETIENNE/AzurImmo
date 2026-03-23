package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.service.AppartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/appartements")
@Tag(name = "Appartements", description = "Gestion des appartements")
public class AppartementController {
	
    @Autowired
    private AppartementService appartementService;

	
    @PostMapping("/")
    @Operation(summary = "Crée un appartement")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }
    
    @GetMapping("/")
    @Operation(summary = "Récupère tous les appartements")
    public String getAppartements(Model model) {
    	
//    	System.out.println("NBAPPT" + appartementService.getAppartements().size());
    	model.addAttribute("appartements", appartementService.getAppartements());
        return "appartements";
    }
    
    @GetMapping("/show/{id}")
    @Operation(summary = "Récupère un appartement selon un id demandé")
    public Optional<Appartement> getAppartementsById(@PathVariable Long id) {
        return appartementService.getAppartementsById(id);
    }
    
    @GetMapping("/ville={ville}")
    @Operation(summary = "Récupère les appartements selon une ville demandée")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @GetMapping("/batiment={batimentId}")
    @Operation(summary = "Récupère les appartements selon l'id d'un bâtiment")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
    	return appartementService.getAppartementsParBatiment(batimentId);
    }
    
    @Operation(summary = "Récupère les appartements ayant une surface plus grande que celle demandée")
    @GetMapping("/surface={surface}")
    public List<Appartement> getAppartementsSupSurface(@PathVariable float surface) {
    	return appartementService.getAppartementsSupSurface(surface);
    }

}