package dev.limhm.social_networks;

import dev.limhm.iterators.ProfileIterator;

public interface SocialNetwork {

  ProfileIterator createFriendsIterator(String profileEmail);

  ProfileIterator createCoworkersIterator(String profileEmail);

}
