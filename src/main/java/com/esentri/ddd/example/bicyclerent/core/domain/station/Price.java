package com.esentri.ddd.example.bicyclerent.core.domain.station;

import java.math.BigDecimal;
import java.math.RoundingMode;

import io.domainlifecycles.domain.types.ValueObject;

/**
 * Price
 */
public record Price(BigDecimal amount) implements ValueObject {
	public static Price NULL = new Price(BigDecimal.ZERO);

	public Price(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Price has to be larger then 0");
		}
		this.amount = amount.setScale(2, RoundingMode.HALF_UP);
	}
}
