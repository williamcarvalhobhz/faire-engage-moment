package com.faire.engage.api.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class PreOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private OrderAddressDTO address;
	private List<OrderItemDTO> items;
	private List<OrderShipmentDTO> shipments;	
	private Date created_at;
	private Date updated_at;	
}
