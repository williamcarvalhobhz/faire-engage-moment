/**
 * Repository of engagements.
 */
package com.faire.engage.api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.faire.engage.api.base.BaseRepository;
import com.faire.engage.api.entities.Engagement;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public interface EngagementRepository extends BaseRepository<Engagement, String> {
	
	@Query("SELECT e FROM Engagement e WHERE cast(e.startsAt as date) <= cast(:date as date) AND cast(e.endsAt as date) >= cast(:date as date) and e.ative = :ative order by e.startsAt ASC" )
	public List<Engagement> findByDate(@Param("date") final Date date, @Param("ative") final Boolean ative);
}
