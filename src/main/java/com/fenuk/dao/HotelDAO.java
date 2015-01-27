package com.fenuk.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

import com.fenuk.entity.Hotel;
import com.fenuk.entity.HotelLongIdEntity;

public class HotelDAO extends BasicDAO<Hotel, Long> {

	public HotelDAO(Datastore ds) {
		super(ds);
	}

	@Override
	public Key<Hotel> save(Hotel h) {

		if (h.getId() == null) {

			HotelLongIdEntity ent = new HotelLongIdEntity(getDs());
			getDs().save(ent);
			h.setId(ent.getMyLongId());
		}
		return getDs().save(h);
	}
}
