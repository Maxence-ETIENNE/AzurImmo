package bts.sio.azurimmo.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.model.mapper.BatimentMapper;
import bts.sio.azurimmo.repository.BatimentRepository;
import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.mapper.AppartementMapper;
import bts.sio.azurimmo.repository.AppartementRepository;
import lombok.Data;

@Data
@Service
public class BatimentService {
	
	 @Autowired
	 private BatimentRepository batimentRepository;
	 
	 @Autowired
	 private AppartementRepository appartementRepository;

	 public BatimentDTO saveBatimentDTO(BatimentDTO dto) {
	        Batiment entity = BatimentMapper.toEntity(dto);
	        Batiment saved = batimentRepository.save(entity);
	        return BatimentMapper.toDTO(saved);
	 }
	 
	 public BatimentDTO saveAppartementDTO(AppartementDTO dto, long batimentId) {
	        Batiment bat = batimentRepository.findById(batimentId).orElseThrow(() -> new RuntimeException("Batiment non trouvé"));
	        Appartement appartement = AppartementMapper.toEntity(dto);
	        appartement.setBatiment(bat);
	        appartementRepository.save(appartement);
	        bat.getAppartements().add(appartement);
	        Batiment saved = batimentRepository.save(bat);
	        return BatimentMapper.toDTO(saved);
	 }

	 public List<Batiment> getBatiments() {
		 List<Batiment> ba = batimentRepository.findAll();
		 System.out.println(ba.size());
		 return ba;
	 }
	 
	 public Optional<BatimentDTO> getBatimentDTO(Long id) {
		 return batimentRepository.findById(id)
                 .map(BatimentMapper::toDTO);
	 }
	 
	 public List<BatimentDTO> getBatimentsDTO() {
	        return batimentRepository.findAll()
	                                 .stream()
	                                 .map(BatimentMapper::toDTO)
	                                 .collect(Collectors.toList());
	}
}