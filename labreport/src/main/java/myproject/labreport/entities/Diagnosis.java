package myproject.labreport.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="diagnoses")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Diagnosis {


	@Id
	@Column(name = "diagnosis_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int diagnosisId;

	@NotNull
	@Column(name = "diagnosis")
	private String diagnosis;
	
	@NotNull
	@Column(name = "diagnosis_detail")
	private String diagnosisDetail;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="report_id")
	private PatientReport report;
}
