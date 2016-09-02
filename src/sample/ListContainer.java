package sample;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Created by Brett on 8/31/16.
 */
public class ListContainer implements Serializable{



	public ListContainer() {

	}

	public ArrayList<ToDoItem> todoArrayList = new ArrayList<>();

}
