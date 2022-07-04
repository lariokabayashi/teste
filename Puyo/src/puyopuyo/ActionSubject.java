package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class ActionSubject {
	final static ArrayList<ActionListener> listenerArr =
         new ArrayList<ActionListener>(); 
  
   public void addActionListener(ActionListener listener) {
	  listenerArr.add(listener);
   }
   
   public void removeActionListener(ActionListener listener) {
      listenerArr.remove(listener);
   }
   
   public void notify(ActionEvent event) {
      for (ActionListener al: listenerArr) {
         al.actionPerformed(event);
      }
   }
}