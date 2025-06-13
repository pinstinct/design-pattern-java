package dev.limhm.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
  private String name;
  private String email;
  private Map<String, List<String >> contracts = new HashMap<>();

  public Profile(String email, String name, String... contacts) {
    this.name = name;
    this.email = email;

    // Please contact list from a set of "friend:email@gmail.com" pairs.
    for (String contact: contacts) {
      String[] parts = contact.split(":");
      String contactType = "friend", contactEmail;
      if (parts.length == 1) {
        contactEmail = parts[0];
      } else {
        contactType = parts[0];
        contactEmail = parts[1];
      }
      if (!this.contracts.containsKey(contactType)) {
        this.contracts.put(contactType, new ArrayList<>());
      }
      this.contracts.get(contactType).add(contactEmail);
    }
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<String> getContacts(String contactType) {
    return contracts.get(contactType);
  }
}
