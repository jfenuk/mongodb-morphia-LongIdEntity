package com.fenuk.entity;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.utils.LongIdEntity;

public class HotelLongIdEntity extends LongIdEntity {

	protected HotelLongIdEntity(Datastore ds) {
		super(ds);
	}

}
