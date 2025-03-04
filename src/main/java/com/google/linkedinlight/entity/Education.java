package com.google.linkedinlight.entity;

import com.google.linkedinlight.util.EducationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String universityName;
	private double percentage;
	private int completionYear;
	@Enumerated(EnumType.STRING)
	private  HeighestQualification  heighestQualification;//----->YES//NO
	private EducationStatus status;// enum------> ACTIVE // DELETED
	@ManyToOne
	private Employee employee;

}
