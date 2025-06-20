package dev.limhm;

import dev.limhm.editor.Editor;
import dev.limhm.listeners.EmailNotificationListener;
import dev.limhm.listeners.LogOpenListener;

public class Demo {

  public static void main(String[] args) {
    Editor editor = new Editor();
    editor.events.subscribe("open", new LogOpenListener("/path"));
    editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

    try {
      editor.openFile("test.txt");
      editor.saveFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
