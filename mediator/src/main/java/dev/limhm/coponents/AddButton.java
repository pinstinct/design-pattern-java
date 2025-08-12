package dev.limhm.coponents;

import dev.limhm.mediator.Mediator;
import dev.limhm.mediator.Note;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Concrete components don't talk with each other. They have only one communication channel-sending
 * requests to the mediator.
 */
public class AddButton extends JButton implements Component {

  private Mediator mediator;

  public AddButton() {
    super("Add");
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  protected void fireActionPerformed(ActionEvent event) {
    mediator.addNewNote(new Note());
  }

  @Override
  public String getName() {
    return "AddButton";
  }
}
