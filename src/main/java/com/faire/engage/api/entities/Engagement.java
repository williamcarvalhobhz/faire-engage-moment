/**
 * Engagement entity.
 */
package com.faire.engage.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "engagement")
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor
public class Engagement extends BaseEntity<String>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name="starts_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startsAt;

	@Column(name="ends_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endsAt;
	
	@Column(name="initial_discount")
	private Integer initialDiscount;
	
	@Column(name="final_discount")
	private Integer finalDiscount;
	
	@Column(name="actual_discount")
	private Integer actualDiscount;
		
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="ative")
	private boolean ative;
	
}
