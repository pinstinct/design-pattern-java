package dev.limhm.iterators;

import dev.limhm.profile.Profile;

public interface ProfileIterator {

  boolean hasNext();

  Profile getNext();

  void reset();

}
