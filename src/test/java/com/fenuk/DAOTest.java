package com.fenuk;

import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.fenuk.dao.CityDAO;
import com.fenuk.dao.HotelDAO;
import com.fenuk.entity.City;
import com.fenuk.entity.Hotel;
import com.mongodb.MongoClient;

public class DAOTest {
	private static MongoClient mongo;
	private static Datastore ds;
	private static final String db_name = "MongoLongIdTest";

	@BeforeClass
	public static void beforeClass() throws UnknownHostException {

		mongo = new MongoClient();

		Morphia morphia = new Morphia();
		morphia.map(City.class).map(Hotel.class);
		ds = morphia.createDatastore(mongo, db_name);

	}

	@AfterClass
	public static void afterClass() {

		mongo.close();
	}

	@Before
	public void before() {

		mongo.dropDatabase(db_name);

	}

	@Test
	public void createAndSaveNewHotel() {

		HotelDAO h_dao = new HotelDAO(ds);
		Hotel h = new Hotel();

		h_dao.save(h);

		assertTrue(1 == h.getId());
	}

	@Test
	public void createAndSaveTwoNewHotels() {

		HotelDAO h_dao = new HotelDAO(ds);
		Hotel h = new Hotel();

		h_dao.save(h);

		h = new Hotel();
		h_dao.save(h);

		assertTrue(2 == h.getId());
	}

	@Test
	public void createAndSaveNewHotelAndNewCity() {

		HotelDAO h_dao = new HotelDAO(ds);
		CityDAO c_dao = new CityDAO(ds);

		Hotel h = new Hotel();
		h_dao.save(h);

		City c = new City();
		c_dao.save(c);

		assertTrue(1 == h.getId());
		assertTrue(1 == c.getId());
	}

	@Test
	public void createAndSaveFiveNewCities() {

		CityDAO c_dao = new CityDAO(ds);
		City c = new City();

		for (int i = 0; i < 5; i++) {
			c = new City();
			c_dao.save(c);
		}
		assertTrue(5 == c.getId());
	}
}
