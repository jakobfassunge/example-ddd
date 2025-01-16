package com.esentri.ddd.example;

import java.util.Objects;
import java.util.UUID;

import io.domainlifecycles.domain.types.AggregateRoot;
import io.domainlifecycles.domain.types.Identity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * User
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class User implements AggregateRoot<User.Id> {

	/**
	 * Note that the UUID has to be named value as this is the same name as the
	 * function of the Identity<?> Interface
	 */
	public record Id(UUID value) implements Identity<UUID> {
	}

	private long concurrencyVersion;

	@EqualsAndHashCode.Include
	private final Id id;

	/**
	 * @param concurrencyVersion
	 * @param id
	 */
	@Builder
	public User(long concurrencyVersion, Id id) {
		Objects.requireNonNull(id, "Die Id darf nicht Null sein");
		this.concurrencyVersion = concurrencyVersion;
		this.id = id;
	}

	@Override
	public long concurrencyVersion() {
		return concurrencyVersion;
	}

	@Override
	public Id id() {
		return id;
	}

}
