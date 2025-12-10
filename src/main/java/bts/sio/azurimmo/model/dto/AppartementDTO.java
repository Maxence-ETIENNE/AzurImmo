package bts.sio.azurimmo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppartementDTO {
	 private String numero;
	 private String description;
	 private Float surface;
	 
	 public String getNumero() {
		 return numero;
	 }
	 public void setNumero(String numero) {
		 this.numero = numero;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public void setDescription(String description) {
		 this.description = description;
	 }
	 public Float getSurface() {
		 return surface;
	 }
	 public void setSurface(Float surface) {
		 this.surface = surface;
	 }

	 
}