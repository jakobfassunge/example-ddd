package com.esentri.ddd.example.bicyclerent.outbound;

import io.domainlifecycles.domain.types.DomainEvent;
import io.domainlifecycles.events.publish.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/** ApplicationDomainEventPublisher */
@Service
@RequiredArgsConstructor
public class ApplicationDomainEventPublisher implements DomainEventPublisher {
  /**
   * @see ApplicationEventPublisher
   */
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void publish(DomainEvent domainEvent) {
    applicationEventPublisher.publishEvent(domainEvent);
  }
}
