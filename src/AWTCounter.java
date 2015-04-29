import java.awt.*;
import java.awt.event.*;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class AWTCounter extends Frame {
   private TextField tfCount;
   private int count = 0;
 
   /** Constructor to setup the GUI */
   public AWTCounter() {
      setLayout(new FlowLayout());
      add(new Label("Counter"));
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);
      add(tfCount);
 
      // Create buttons
      Button btnCountUp = new Button("Count Up");
      add(btnCountUp);
      Button btnCountDown = new Button("Count Down");
      add(btnCountDown);
      Button btnReset = new Button("Reset");
      add(btnReset);
 
      // Allocate an instance of inner class BtnListener.
      BtnListener listener = new BtnListener();
      // Use the same listener to all the 3 buttons.
      btnCountUp.addActionListener(listener);
      btnCountDown.addActionListener(listener);
      btnReset.addActionListener(listener);
 
      setTitle("AWT Counter");
      setSize(400, 100);
      setVisible(true);
   }
 
   /** The entry main method */
   public static void main(String[] args) {
      new AWTCounter();  // Let the constructor do the job
   }
 
   /**
    * BtnListener is a named inner class used as ActionEvent listener for the buttons.
    */
   private class BtnListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // Need to determine which button has fired the event.
         // getActionCommand() returns the button's label
         String btnLabel = e.getActionCommand();
         if (btnLabel.equals("Count Up")) {
            ++count;
         } else if (btnLabel.equals("Count Down")) {
            --count;
         } else {
            count = 0;
         }
         tfCount.setText(count + "");
      }
   }
}