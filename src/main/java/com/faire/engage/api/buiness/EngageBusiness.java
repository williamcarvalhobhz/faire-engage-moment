package com.faire.engage.api.buiness;

import java.util.Date;
import java.util.List;

import com.faire.engage.api.base.BaseBusiness;
import com.faire.engage.api.entities.Engage;

public interface EngageBusiness extends BaseBusiness<Engage, String> {
	
	public List<Engage> findByDate(final Date date, final Boolean ative);
}
