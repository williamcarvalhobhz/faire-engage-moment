/**
 * Engagement business interface for the dependency injection.
 */
package com.faire.engage.api.buiness;

import java.util.Date;
import java.util.List;

import com.faire.engage.api.base.BaseBusiness;
import com.faire.engage.api.entities.Engagement;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public interface EngagementBusiness extends BaseBusiness<Engagement, String> {
	
	/**
	 * 
	 * @param date
	 * @param ative
	 * @return 
	 */
	public List<Engagement> findByDate(final Date date, final Boolean ative);
}
