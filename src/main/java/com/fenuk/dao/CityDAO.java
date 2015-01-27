package com.fenuk.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

import com.fenuk.entity.City;
import com.fenuk.entity.CityLongIdEntity;

public class CityDAO extends BasicDAO<City, Long> {

	public CityDAO(Datastore ds) {
		super(ds);
	}

	@Override
	public Key<City> save(City c) {

		if (c.getId() == null) {

			CityLongIdEntity ent = new CityLongIdEntity(getDs());
			getDs().save(ent);
			c.setId(ent.getMyLongId());
		}
		return getDs().save(c);
	}
}
