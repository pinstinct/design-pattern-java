package dev.limhm.iterators;

import dev.limhm.profile.Profile;
import dev.limhm.social_networks.LinkedIn;
import java.util.ArrayList;
import java.util.List;

public class LinkedInIterator implements ProfileIterator {

  private LinkedIn linkedIn;
  private String type;
  private String email;
  private int currentPosition = 0;
  private List<String> emails = new ArrayList<>();
  private List<Profile> contracts = new ArrayList<>();

  public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
    this.linkedIn = linkedIn;
    this.type = type;
    this.email = email;
  }

  private void lazyLoad() {
    if (emails.size() == 0) {
      List<String> profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
      for (String profile : profiles) {
        this.emails.add(profile);
        this.contracts.add(null);
      }
    }
  }

  @Override
  public boolean hasNext() {
    lazyLoad();
    return currentPosition < emails.size();
  }

  @Override
  public Profile getNext() {
    if (!hasNext()) {
      return null;
    }

    String friendEmail = emails.get(currentPosition);
    Profile friendContact = contracts.get(currentPosition);
    if (friendContact == null) {
      friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
      contracts.set(currentPosition, friendContact);
    }
    currentPosition++;
    return friendContact;
  }

  @Override
  public void reset() {
    currentPosition = 0;
  }
}
