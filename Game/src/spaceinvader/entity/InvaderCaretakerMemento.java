package spaceinvader.entity;

import java.util.ArrayList;

public class InvaderCaretakerMemento {
	private ArrayList savedStates = new ArrayList();
	private Object last;
	 
    public void addMemento(Object m) { savedStates.add(m); 
    last = m;}
    public Object getMemento(int index) { return savedStates.get(index); }
    public Object getMemento() {return last;}
}
