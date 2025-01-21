package com.esentri.ddd.example.bicyclerent.core.domain.station;

import java.time.LocalDateTime;
import java.util.UUID;

import com.esentri.ddd.example.bicyclerent.core.domain.station.Station.StationNumber;

import io.domainlifecycles.domain.types.Identity;
import io.domainlifecycles.domain.types.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Booking
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking implements ValueObject {
	public record Id(UUID value) implements Identity<UUID> {
	}

	@EqualsAndHashCode.Include
	private final Booking.Id id;
	private final LocalDateTime checkInDate;
	private final LocalDateTime checkOutDate;
	private final Station.StationNumber checkInSatStationNumber;
	private final Station.StationNumber checkOutSatStationNumber;
	private final Price price;
	private final BikeType bikeType;

	/**
	 * @param id
	 * @param checkInDate
	 * @param checkOutDate
	 * @param checkInSatStationNumber
	 * @param checkOutSatStationNumber
	 * @param price
	 * @param bikeType
	 */
	public Booking(Id id, LocalDateTime checkInDate, LocalDateTime checkOutDate, StationNumber checkInSatStationNumber,
			StationNumber checkOutSatStationNumber, Price price, BikeType bikeType) {
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.checkInSatStationNumber = checkInSatStationNumber;
		this.checkOutSatStationNumber = checkOutSatStationNumber;
		this.price = price;
		this.bikeType = bikeType;
	}

}
