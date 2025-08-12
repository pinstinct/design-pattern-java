package dev.limhm.coponents;

import dev.limhm.mediator.Mediator;

/**
 * Common component interface.
 */
public interface Component {

  void setMediator(Mediator mediator);

  String getName();
}
