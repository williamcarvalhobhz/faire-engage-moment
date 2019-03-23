package com.faire.engage.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.faire.engage.api.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
@Entity
@Table(name = "product_option")
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor
public class ProductOption extends BaseEntity<String>{

	private static final long serialVersionUID = 1L;
	

	@Id
	@Column
	@SequenceGenerator(name="product_option_sequence", sequenceName="product_option_sequence")
	@GeneratedValue(generator = "product_option_sequence", strategy = GenerationType.AUTO)
	private String id;
	
	@Column
	private Product product_id;
	
	@Column
	private Boolean active;

	@Column
	private String name;

	@Column
	private String sku;

	@Column
	private Integer available_quantity;

	@Column
	private String backordered_until;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date updated_at;
}
