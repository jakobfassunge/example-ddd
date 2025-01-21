package com.esentri.ddd.example.bicyclerent.core.domain.station;

import io.domainlifecycles.domain.types.AggregateRoot;
import io.domainlifecycles.domain.types.Identity;
import java.util.List;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/** Station */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Station implements AggregateRoot<Station.StationNumber> {

  public record StationNumber(UUID value) implements Identity<UUID> {}

  @EqualsAndHashCode.Include private final StationNumber stationNumber;

  private final int capacity;
  private final List<Bike.Id> bikes;
  private long concurrencyVersion;

  /**
   * @param stationNumber
   * @param capacity
   * @param bikes
   * @param concurrencyVersion
   */
  public Station(
      StationNumber stationNumber,
      int capacity,
      List<com.esentri.ddd.example.bicyclerent.core.domain.station.Bike.Id> bikes,
      long concurrencyVersion) {
    this.stationNumber = stationNumber;
    this.capacity = capacity;
    this.bikes = bikes;
    this.concurrencyVersion = concurrencyVersion;
  }

  @Override
  public Station.StationNumber id() {
    return stationNumber;
  }

  @Override
  public long concurrencyVersion() {
    return concurrencyVersion;
  }
}
