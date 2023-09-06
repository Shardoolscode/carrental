package com.sm.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 634766354069999161L;
	private Integer uid;
	private String name;
	private Integer age;
}

