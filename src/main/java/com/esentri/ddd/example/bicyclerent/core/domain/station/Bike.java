package com.esentri.ddd.example.bicyclerent.core.domain.station;

import java.util.List;
import java.util.UUID;

import io.domainlifecycles.domain.types.Identity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Bike
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bike {
	public record Id(UUID value) implements Identity<UUID> {
	}

	@EqualsAndHashCode.Include
	private final Bike.Id id;

	private final BikeType bikeType;
	private final List<Occupancy> occupancies;

	/**
	 * @param id
	 * @param bikeType
	 * @param occupancies
	 */
	public Bike(Id id, BikeType bikeType, List<Occupancy> occupancies) {
		this.id = id;
		this.bikeType = bikeType;
		this.occupancies = occupancies;
	}

}
