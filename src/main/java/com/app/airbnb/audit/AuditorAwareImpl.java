package com.app.airbnb.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
  private static final String SYSTEM_USER = "SYSTEM";

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of(SYSTEM_USER);
  }

}
