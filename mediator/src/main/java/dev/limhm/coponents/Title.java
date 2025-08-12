package dev.limhm.coponents;

import dev.limhm.mediator.Mediator;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Title extends JTextField implements Component {

  private Mediator mediator;

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  protected void processComponentKeyEvent(KeyEvent e) {
    mediator.markNote();
  }

  @Override
  public String getName() {
    return "Title";
  }
}
