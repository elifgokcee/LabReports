package myproject.labreport.business.abstracts;

import java.util.List;

import myproject.labreport.entities.Patient;
import myproject.labreport.entities.PatientReport;

public interface PatientService{
	 List<Patient> getAll();
	 void add(Patient patient);
	 void delete(int patientId);
	 Patient getById(int id);
	 List<PatientReport> getReportsById(int patientId);
	 void updateReport(int patientId,PatientReport report);
	
}
