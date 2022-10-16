package  myproject.labreport.api.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import myproject.labreport.business.abstracts.DiagnosisService;
import myproject.labreport.business.abstracts.LaborantService;
import  myproject.labreport.business.abstracts.PatientReportService;
import myproject.labreport.business.abstracts.PatientService;
import myproject.labreport.entities.Diagnosis;
import myproject.labreport.entities.Laborant;
import myproject.labreport.entities.Patient;
import  myproject.labreport.entities.PatientReport;
import myproject.labreport.entities.dtos.LaborantRegisterDto;


@CrossOrigin 

@RestController
public class PatientReportsController {
	
private PatientReportService service;

@Autowired
LaborantService userService;
@Autowired
PatientService patientService;
@Autowired
DiagnosisService diagnosisService;
   @Autowired

	public PatientReportsController( PatientReportService service) {
		this.service=service;
	}
   
   
	@GetMapping("/patientreports")
	public ModelAndView getAll(){
		ModelAndView mav=new ModelAndView("get-reports");
		List<PatientReport> list=service.getAll();
		mav.addObject("patientreports", list);
		
		return mav;}
 
		@GetMapping("/patientreports/{id}")
		public ModelAndView getById(@PathVariable (name="id") int id){
			ModelAndView mav=new ModelAndView("get-report-details");
			PatientReport report=service.getById(id);
			mav.addObject("patientreportdetails", report);
			
			return mav;
			}
		@GetMapping("patientreports/addreportform/{id}")
		public ModelAndView addReportForm(@PathVariable (name="id") int id) {
			PatientReport report=new PatientReport();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			Laborant laborant=userService.findByEmail(currentPrincipalName);
			ModelAndView mav=new ModelAndView("add-report-form");
			Patient patient=patientService.getById(id);
			
			
			
			patient.getReport().add(report);
			laborant.getReport().add(report);
			
			
			patientService.updateReport(patient.getPatientId(),report);
			userService.updateReport(laborant.getLaborantId(),report);
		
			
			report.setPatient(patient);
			report.setLaborant(laborant);
				
			
			
			
		
		    mav.addObject("report", report);
		 
			
			mav.addObject("laborant", laborant);
			mav.addObject("patient",patient);
			
		  

		   
		
	
			return mav;
		}
	
      @PostMapping("patientreports/addreport")
    public ModelAndView addReport(@ModelAttribute("report") PatientReport report
    		
    		
    		) {
    		

service.add(report);
ModelAndView mav=new ModelAndView("redirect:/patientreports");

    
     
		return mav;
    	
      }
    
    
    
}