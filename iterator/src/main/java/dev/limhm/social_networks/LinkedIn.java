package dev.limhm.social_networks;

import dev.limhm.iterators.LinkedInIterator;
import dev.limhm.iterators.ProfileIterator;
import dev.limhm.profile.Profile;
import java.util.ArrayList;
import java.util.List;

public class LinkedIn implements SocialNetwork {

  private List<Profile> contacts;

  public LinkedIn(List<Profile> cache) {
    if (cache != null) {
      this.contacts = cache;
    } else {
      this.contacts = new ArrayList<>();
    }
  }

  public Profile requestContactInfoFromLinkedInAPI(String profileEmail) {
    // Here would be a POST request to one of the LinkedIn API endpoints.
    // Instead, we emulate long network connection, which you would expect
    // in the real life...
    simulateNetworkLatency();
    System.out.println("LinkedIn: Loading profile " + profileEmail + " over the network...");

    // ...and return test data.
    return findContact(profileEmail);
  }

  private Profile findContact(String profileEmail) {
    for (Profile profile : contacts) {
      if (profile.getEmail().equals(profileEmail)) {
        return profile;
      }
    }
    return null;
  }


  private void simulateNetworkLatency() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  public List<String> requestRelatedContactsFromLinkedInAPI(String email, String type) {
    // Here would be a POST request to one of the LinkedIn API endpoints.
    // Instead, we emulate long network connection, which you would expect
    // in the real life...
    simulateNetworkLatency();
    System.out.println("LinkedIn: Loading " + type + "list of " + email + " over the network..");

    // ...and return test data.
    Profile profile = findContact(email);
    if (profile != null) {
      return profile.getContacts(type);
    }
    return null;
  }


  @Override
  public ProfileIterator createFriendsIterator(String profileEmail) {
    return new LinkedInIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(String profileEmail) {
    return new LinkedInIterator(this, "coworkers", profileEmail);
  }
}

