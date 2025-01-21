package com.esentri.ddd.example.bicyclerent.core.domain.station;

import io.domainlifecycles.domain.types.ValueObject;
import java.time.LocalDateTime;

/** Belegung */
public record Occupancy(LocalDateTime von, LocalDateTime bis) implements ValueObject {}
