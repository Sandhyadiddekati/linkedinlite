package com.google.linkedinlight.responsestructure;

import java.util.ArrayList;
import java.util.List;

import com.google.linkedinlight.entity.Education;
import com.google.linkedinlight.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseStructure<T> {
	
     private int status;
     private String message;
     private T body;
	
}
