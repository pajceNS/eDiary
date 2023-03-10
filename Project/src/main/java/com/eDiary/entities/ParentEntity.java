package com.eDiary.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parent")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ParentEntity extends UserEntity {

	@Column
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> children;

	public ParentEntity() {
		super();
	}

	public ParentEntity(String email, List<StudentEntity> children) {
		super();
		this.email = email;
		this.children = children;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentEntity> getChildren() {
		return children;
	}

	public void setChildren(List<StudentEntity> children) {
		this.children = children;
	}
}