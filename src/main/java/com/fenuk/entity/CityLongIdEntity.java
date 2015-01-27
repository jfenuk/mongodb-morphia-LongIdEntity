package com.fenuk.entity;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.utils.LongIdEntity;

public class CityLongIdEntity extends LongIdEntity {

	public CityLongIdEntity(Datastore ds) {
		super(ds);
	}

}
