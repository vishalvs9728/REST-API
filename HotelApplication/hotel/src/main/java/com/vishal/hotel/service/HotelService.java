package com.vishal.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vishal.hotel.exception.HotelNotFoundException;
import com.vishal.hotel.model.Hotel;

@Service
public class HotelService {

	List<Hotel> hotelList = new ArrayList<>();
	Map<String, Hotel> hotelMap = new HashMap<>();

	public void createHotel(Hotel hotel) {
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);

	}

	public Hotel getHotelById(String id) {
		if (hotelMap.containsKey(id)) {
			return hotelMap.get(id);
		}
		throw new HotelNotFoundException("Hotel Not Found "+id);
	}

	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelList;
	}

	public void deleteHotelById(String id) {
		if (hotelMap.containsKey(id)) {
			Hotel hotel = hotelMap.remove(id);
			hotelList.remove(hotel);
		}

	}

	public void updateHotel(Hotel updatedHotel, String id) {
		
		if (hotelMap.containsKey(id)) {
			Hotel hotel = hotelMap.get(id);
			hotelList.remove(hotel);
			
			
		}
		hotelMap.put(id, updatedHotel);
		hotelList.add(updatedHotel);
	}

}
