package myproject.labreport.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LaborantRegisterDto {

	private int hospitalIdentityId;
	private String password;
	private String email;
	private String laborantSurName;
	private String laborantName;
	
}
