package com.faire.engage.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "product")
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor
public class Product extends BaseEntity<String>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@SequenceGenerator(name="product_sequence", sequenceName="product_sequence")
	@GeneratedValue(generator = "product_sequence", strategy = GenerationType.AUTO)
	private String id;
	
	@Column
	private String brand_id;
	
	@Column
	private String short_description;
	
	@Column
	private String description;
	
	@Column
	private Integer wholesale_price_cents;

	@Column
	private Integer retail_price_cents;

	@Column
	private Boolean active;

	@Column
	private String name;

	@Column
	private Integer unit_multiplier;
	
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<ProductOption> options;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date updated_at;

	
}
