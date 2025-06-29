package dev.limhm.social_networks;

import dev.limhm.iterators.FacebookIterator;
import dev.limhm.iterators.ProfileIterator;
import dev.limhm.profile.Profile;
import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork {
  private List<Profile> profiles;

  public Facebook(List<Profile> cache) {
    if (cache != null) {
      this.profiles = cache;
    } else {
      this.profiles = new ArrayList<>();
    }
  }

  public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
    // Here would be a POST request to one of the Facebook API endpoints.
    // Instead, we emulate long network connection, which you would expect
    // in the real life...
    simulateNetworkLatency();
    System.out.println("Facebook: Loading " + contactType + " list of " + profileEmail + " over the network...");

    // ...and return test data.
    Profile profile = findProfile(profileEmail);
    if (profile != null) {
      return profile.getContacts(contactType);
    }
    return null;
  }

  public Profile requestProfileFromFacebook(String profileEmail) {
    // Here would be a POST request to one of the Facebook API endpoints.
    // Instead, we emulate long network connection, which you would expect
    // in the real life...
    simulateNetworkLatency();
    System.out.println("Facebook: Loading profile '" + profileEmail + "' over the network...");

    // ...and return test data.
    return findProfile(profileEmail);
  }

  private Profile findProfile(String profileEmail) {
    for (Profile profile: profiles) {
      if (profile.getEmail().equals(profileEmail)) {
        return profile;
      }
    }
    return null;
  }

  private void simulateNetworkLatency() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ProfileIterator createFriendsIterator(String profileEmail) {
    return new FacebookIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(String profileEmail) {
    return new FacebookIterator(this, "coworkers", profileEmail);
  }
}
