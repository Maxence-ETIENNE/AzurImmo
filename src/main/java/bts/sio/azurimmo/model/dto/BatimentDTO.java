package bts.sio.azurimmo.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatimentDTO {
	private String adresse;
    private String ville;
    private List<AppartementDTO> appartements;
    
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public List<AppartementDTO> getAppartements() {
		return appartements;
	}
	public void setAppartements(List<AppartementDTO> appartements) {
		this.appartements = appartements;
	}

}