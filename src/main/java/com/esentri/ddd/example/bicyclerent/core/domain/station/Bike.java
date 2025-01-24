package com.esentri.ddd.example.bicyclerent.core.domain.station;

import java.util.List;
import java.util.UUID;

import io.domainlifecycles.domain.types.AggregateRoot;
import io.domainlifecycles.domain.types.Identity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/** Bike */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bike implements AggregateRoot<Bike.Id> {
  public record Id(UUID value) implements Identity<UUID> {}

  @EqualsAndHashCode.Include private final Bike.Id id;

  private final BikeType bikeType;
  private final List<Occupancy> occupancies;
  private long concurrencyVersion;

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

@Override
public Id id() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'id'");
}

@Override
public long concurrencyVersion() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'concurrencyVersion'");
}
}
