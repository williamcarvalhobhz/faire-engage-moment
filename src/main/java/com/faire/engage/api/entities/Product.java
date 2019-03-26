/**
 * Product entity.
 */
package com.faire.engage.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.faire.engage.api.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString(exclude="options")
public class Product extends BaseEntity<String>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name="brand_id")
	private String brandId;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Lob
	@Column(name="description", columnDefinition="clob")
	private String description;
	
	@Column(name="wholesale_price_cents")
	private Integer wholeSalePriceCents;

	@Column(name="retail_price_cents")
	private Integer retailPriceCents;

	@Column(name="active")
	private Boolean active;

	@Column(name="name")
	private String name;

	@Column(name="unit_multiplier")
	private Integer unitMultiplier;
		
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<ProductOption> options;

	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	
}
