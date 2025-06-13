package dev.limhm.spammer;

import dev.limhm.iterators.ProfileIterator;
import dev.limhm.profile.Profile;
import dev.limhm.social_networks.SocialNetwork;


// 메시지 전송 앱
public class SocialSpammer {

  public SocialNetwork network;
  public ProfileIterator iterator;

  public SocialSpammer(SocialNetwork network) {
    this.network = network;
  }

  public void sendSpamToFriends(String profileEmail, String message) {
    System.out.println("\nIterating over friends..\n");
    iterator = network.createFriendsIterator(profileEmail);
    while (iterator.hasNext()) {
      Profile profile = iterator.getNext();
      sendMessage(profile.getEmail(), message);
    }
  }

  public void sendSpamToCoworkers(String profileEmail, String message) {
    System.out.println("\nIterating over coworkers...\n");
    iterator = network.createCoworkersIterator(profileEmail);
    while (iterator.hasNext()) {
      Profile profile = iterator.getNext();
      sendMessage(profile.getEmail(), message);
    }
  }

  private void sendMessage(String email, String message) {
    System.out.println("Sent message to: " + email + ". message body: " + message);
  }
}
