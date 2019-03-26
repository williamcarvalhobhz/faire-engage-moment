/**
 * Enumeration of order status.
 */
package com.faire.engage.api.enums;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public enum OrderStatus {
	NEW,
	PROCESSING,
	PRE_TRANSIT,
	IN_TRANSIT,
	DELIVERED,
	BACKORDERED,
	CANCELED;
}
