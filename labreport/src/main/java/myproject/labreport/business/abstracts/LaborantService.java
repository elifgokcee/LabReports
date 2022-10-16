package myproject.labreport.business.abstracts;




import java.util.Optional;

import myproject.labreport.entities.Laborant;
import myproject.labreport.entities.PatientReport;
import myproject.labreport.entities.dtos.LaborantRegisterDto;

public interface LaborantService  {
public Laborant add(LaborantRegisterDto laborantdto);
public void delete(int laborantId);
public void update(int laborantId);
public Laborant findByEmail(String email);
void updateReport(int userId,PatientReport report);

}
