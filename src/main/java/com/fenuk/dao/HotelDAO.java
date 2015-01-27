package com.fenuk.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.fenuk.entity.Hotel;

public class HotelDAO extends BasicDAO<Hotel,Long> {

	protected HotelDAO(Datastore ds) {
		super(ds);
	}

}
