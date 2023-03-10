package com.eDiary.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminEntity extends UserEntity{

	public AdminEntity() {
		super();
	}
}
