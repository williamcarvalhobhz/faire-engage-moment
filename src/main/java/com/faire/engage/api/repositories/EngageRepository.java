package com.faire.engage.api.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.faire.engage.api.base.BaseRepository;
import com.faire.engage.api.entities.Engage;

public interface EngageRepository extends BaseRepository<Engage, String> {
	
	@Query("SELECT e FROM Engage e WHERE cast(e.starts_at as date) <= cast(:date as date) AND cast(e.ends_at as date) >= cast(:date as date) and e.ative = :ative order by e.starts_at ASC" )
	public List<Engage> findByDate(@Param("date") final Date date, @Param("ative") final Boolean ative);
}
