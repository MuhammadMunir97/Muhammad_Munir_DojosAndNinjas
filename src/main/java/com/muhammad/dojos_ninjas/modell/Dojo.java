package com.muhammad.dojos_ninjas.modell;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	public Dojo() {
		
	}
	
	public int getSize() {
		return ninjas.size();
	}
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar created_at) {
		this.createdAt = created_at;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
	protected void onCreate() {
	  createdAt = Calendar.getInstance();
	}
	@PreUpdate
	protected void onUpdate() {
	  updatedAt = Calendar.getInstance();
	}
	
}
