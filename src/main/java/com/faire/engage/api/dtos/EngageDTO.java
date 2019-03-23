package com.faire.engage.api.dtos;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class EngageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date starts_at;
	private Date ends_at;
	
	private Integer initial_discount;
	private Integer final_discount;
	private Integer closing_discount;
	
	private ProductDTO product;
	
	private String image_id;
	
}
