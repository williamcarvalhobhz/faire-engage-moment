/**
 * Product option entity.
 */
package com.faire.engage.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

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
	@Column(nullable=false)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name="product_id")
	private String productId;
	
	@Column(name="active")
	private Boolean active;

	@Column(name="name")
	private String name;

	@Column(name="sku")
	private String sku;

	@Column(name="available_quantity")
	private Integer availableQuantity;

	@Column(name="backordered_until")
	private String backOrderedUntil;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
}
