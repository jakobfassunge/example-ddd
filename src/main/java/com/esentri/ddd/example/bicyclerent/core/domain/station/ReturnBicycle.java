package com.esentri.ddd.example.bicyclerent.core.domain.station;

import io.domainlifecycles.domain.types.DomainCommand;

public record ReturnBicycle(Bike.Id bikeId, Station.StationNumber stationNumber)
    implements DomainCommand {}
