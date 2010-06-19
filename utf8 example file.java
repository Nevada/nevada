import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * EntryPoint class for testing Drag and Drop library.
 * 
 */
public class Johan implements EntryPoint {

  public void onModuleLoad() {
    RootPanel.get().add(new HTML("å,ä,ö,Å,Ä,Ö"));
  }

}
