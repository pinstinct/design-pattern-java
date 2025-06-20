package dev.limhm.commands;

import dev.limhm.editor.Editor;

public class CopyCommand extends Command {

  public CopyCommand(Editor editor) {
    super(editor);
  }

  @Override
  public boolean execute() {
    editor.clipboard = editor.textField.getSelectedText();
    return false;
  }
}
