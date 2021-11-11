package com.onlineClass.mgt;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="classId")
	private int classId;
	
	@Column(name ="className")
	private String className;

	public Classes(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public Classes() {
		super();
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + "]";
	}
	
	
	
	}	