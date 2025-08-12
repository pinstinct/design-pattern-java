package dev.limhm.coponents;

import dev.limhm.mediator.Mediator;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Concrete components don't talk with each other. They have only one communication channel-sending
 * request to the mediator.
 */
public class SaveButton extends JButton implements Component {

  private Mediator mediator;

  public SaveButton() {
    super("Save");
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  protected void fireActionPerformed(ActionEvent event) {
    mediator.saveChanges();
  }

  @Override
  public String getName() {
    return "SaveButton";
  }
}
