package dev.limhm;

import dev.limhm.coponents.AddButton;
import dev.limhm.coponents.DeleteButton;
import dev.limhm.coponents.Filter;
import dev.limhm.coponents.List;
import dev.limhm.coponents.SaveButton;
import dev.limhm.coponents.TextBox;
import dev.limhm.coponents.Title;
import dev.limhm.mediator.Editor;
import dev.limhm.mediator.Mediator;
import javax.swing.DefaultListModel;

public class Demo {

  public static void main(String[] args) {
    Mediator mediator = new Editor();

    mediator.registerComponent(new Title());
    mediator.registerComponent(new TextBox());
    mediator.registerComponent(new AddButton());
    mediator.registerComponent(new DeleteButton());
    mediator.registerComponent(new SaveButton());
    mediator.registerComponent(new List(new DefaultListModel()));
    mediator.registerComponent(new Filter());

    mediator.createGUI();
  }
}
