package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Brett on 8/31/16.
 */
public class ListContainer implements Initializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ListContainer(String name, ObservableList<ToDoItem> todoList) {
		this.name = name;
		this.userTodoList = todoList;
	}

	ObservableList<ToDoItem> userTodoList = FXCollections.observableArrayList();

	public void containerDump() {
		for (ToDoItem item : userTodoList) {
			todoArrayList.add(item);
//			System.out.println(item);
		}
	}


	ArrayList<ToDoItem> todoArrayList = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


}
