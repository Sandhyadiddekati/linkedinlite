package com.google.linkedinlight.entity;

import com.google.linkedinlight.util.AddressStatus;
import com.google.linkedinlight.util.AddressType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int doorNo;
	private String addressLine1;
	private String addressLine2;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private int pincode;
	@Enumerated(EnumType.STRING)
	private AddressStatus status=AddressStatus.ACTIVE;
	@Enumerated(EnumType.STRING)
	private AddressType type=AddressType.PRESENT;// enum------->PERMINENT // PRESENT // WORK// DELETED
	
	@ManyToOne
	private Employee employee;
	
}





//POST-----> /addresses/{eid}     address json obj{ }-----------> saveaddress for a employee
//GET----> /addresses/{eid}                            -->        fetch all address of a employee
//GET----> /addresses{aid}                                ------->fetch a address by its id
//PATCH--> /ADDRESSES/type/{aid}/{type}                 ---->    change the address type an address by it is id
//patch---> /addresses/status/{aid}/{status}           -------> change the status of an address by it is id
