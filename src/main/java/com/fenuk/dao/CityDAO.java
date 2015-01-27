package com.fenuk.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.fenuk.entity.City;

public class CityDAO extends BasicDAO<City, Long>{

	protected CityDAO(Datastore ds) {
		super(ds);
	}

}
