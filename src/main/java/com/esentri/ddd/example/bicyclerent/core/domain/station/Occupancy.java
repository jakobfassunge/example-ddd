package com.esentri.ddd.example.bicyclerent.core.domain.station;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.domainlifecycles.domain.types.ValueObject;

/**
 * Belegung
 */
public record Occupancy(LocalDateTime von, LocalDateTime bis) implements ValueObject {
}
