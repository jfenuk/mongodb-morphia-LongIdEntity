package com.fenuk.entity;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.utils.LongIdEntity;

public class CityLongIdEntity extends LongIdEntity {

	protected CityLongIdEntity(Datastore ds) {
		super(ds);
	}

}
