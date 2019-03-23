package com.faire.engage.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "engage")
@EqualsAndHashCode(callSuper = false, of = "id")
@NoArgsConstructor
public class Engage extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@SequenceGenerator(name="engage_sequence", sequenceName="engage_sequence")
	@GeneratedValue(generator = "engage_sequence", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date starts_at;
	
	@Column
	private Date ends_at;
	
	@Column
	private Integer initial_discount;
	
	@Column
	private Integer final_discount;
	
	@Column
	private Integer actual_discount;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Product product;
	
	@Column
	private String image_url;
	
	@Column
	private boolean ative;
	
}
