package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.service.BatimentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/batiments")
@Tag(name = "Bâtiments", description = "Gestion des bâtiments")
public class BatimentController {
	
    @Autowired
    private BatimentService batimentService;

	
    @PostMapping("/")
    @Operation(summary = "Crée un bâtiment")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); // 201 Created
    }
    
    @PutMapping("/addAppartement/{batimentId}")
    @Operation(summary = "Ajouter un appartement à un bâtiment")
    public ResponseEntity<BatimentDTO> addAppartementToBatiment(@RequestBody AppartementDTO dto, @PathVariable long batimentId) {
        BatimentDTO savedDTO = batimentService.saveAppartementDTO(dto, batimentId);
        return ResponseEntity.status(201).body(savedDTO); // 201 Created
    }
    
    @GetMapping("/")
    @Operation(summary = "Récupère tous les bâtiments")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
    
    @GetMapping("/{batimentId}")
    @Operation(summary = "Récupère un bâtiment selon un id")
    public Optional <BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId);
    }

    @GetMapping("/re/{batimentId}")
    @Operation(summary = "Récupère un bâtiment selon un id en utilisant ResponseEntity")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)   // batiment trouvé → 200
                                  .orElse(ResponseEntity.notFound().build()); // pas trouvé → 404
    }
}