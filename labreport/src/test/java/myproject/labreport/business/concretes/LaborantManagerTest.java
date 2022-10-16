package myproject.labreport.business.concretes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import myproject.labreport.dataAccess.LaborantDao;
import myproject.labreport.entities.Laborant;
import myproject.labreport.entities.dtos.LaborantRegisterDto;
import myproject.labreport.entities.role.Role;

import static org.junit.Assert.*;

import java.util.Arrays;

public class LaborantManagerTest {
	private LaborantManager laborantManager;
	
	private   LaborantDao dao;
    private PasswordEncoder passwordEncoder;
	
	@Before
   public void setUp() throws Exception{
		dao=Mockito.mock(LaborantDao.class);
		passwordEncoder=Mockito.mock(PasswordEncoder.class);
	    laborantManager=new LaborantManager(dao,passwordEncoder);
    }
	
	@Test
	public void whenAdd() {
		LaborantRegisterDto dto=new LaborantRegisterDto();
		dto.setEmail("gokceeliif@gmail.com");
		dto.setHospitalIdentityId(1234560);
		dto.setLaborantName("Elif");
		dto.setPassword("selam");
		dto.setLaborantSurName("Gökce");
		
		
		Laborant laborant=new Laborant(dto.getEmail(),passwordEncoder.encode(dto.getPassword()),dto.getHospitalIdentityId(),
				dto.getLaborantName(),dto.getLaborantSurName(),Arrays.asList(new Role("USER")));
		Mockito.when(dao.getById(laborant.getLaborantId())).thenReturn(laborant);
		Mockito.when(dao.save(laborant)).thenReturn(laborant);
		Mockito.when(passwordEncoder.encode(dto.getPassword())).thenReturn(laborant.getPassword());
		
		
		
		Laborant lab=laborantManager.add(dto);
		
		Assert.assertEquals(dto,lab);
		
		Mockito.verify(laborantManager).add(dto);
		Mockito.verify(dao.save(laborant));
		Mockito.verify(passwordEncoder).encode(dto.getPassword());
		
		
		
		
		
		
		
		
		
		
		
	}
}
