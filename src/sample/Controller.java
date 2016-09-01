package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

	@FXML
	ListView todoList;

	@FXML
	TextField todoText;

	ObservableList<ToDoItem> todoItems = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		todoList.setItems(todoItems);
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter your name");
		String setName = inputScanner.nextLine();
//		ListContainer myContainer = new ListContainer(setName, todoItems);
//		System.out.println("Thank you, " + myContainer.getName());


		try {
			File listFile = new File("list.json");
			Scanner listScanner = new Scanner(listFile);

			String scanList = null;
			scanList = listScanner.nextLine();

			ListContainer myContainer = jsonRestore(scanList);


//				System.out.println(something);
//				String[] listArray = listScanner.nextLine().split("=");
//				todoItems.add(new ToDoItem((listArray[0]), Boolean.valueOf(listArray[1])));

		}
		catch (FileNotFoundException exception) {

		}
	}

	public void addOnEnter(KeyEvent e) {
		if(e.getCode().equals(KeyCode.ENTER)) {
			System.out.println("Adding item...");
			todoItems.add(new ToDoItem(todoText.getText()));
			todoText.setText("");
			saveList();

		}
	}

	public void addItem() {
		System.out.println("Adding item ...");
		todoItems.add(new ToDoItem(todoText.getText()));
		todoText.setText("");
		saveList();
	}

	public void removeItem() {
		System.out.println("Removing item ...");
		ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
		System.out.println("Removing " + todoItem.text + " ...");
		todoItems.remove(todoItem);
		saveList();
	}

	public void toggleItem() {
		System.out.println("Toggling item ...");
		ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
		if (todoItem != null) {
			todoItem.isDone = !todoItem.isDone;
			todoList.setItems(null);
			todoList.setItems(todoItems);
			saveList();
		}
	}

	public void allDone() {
		System.out.println("Everything done...");
		for (ToDoItem item : todoItems) {
			if (item != null) {
				item.isDone = true;
				todoList.setItems(null);
				todoList.setItems(todoItems);
				saveList();
			}
		}
	}

	public void noneDone() {
		System.out.println("Nothing is done!");
		for (ToDoItem item : todoItems) {
			if (item != null) {
				item.isDone = false;
				todoList.setItems(null);
				todoList.setItems(todoItems);
				saveList();
			}
		}

	}

	public void toggleAll() {
		System.out.println("Toggling...");
		for (ToDoItem item : todoItems) {
			if (item != null) {
				item.isDone = !item.isDone;
				todoList.setItems(null);
				todoList.setItems(todoItems);
				saveList();
			}
		}
	}

	public void saveList() {
		FileWriter listWriter = null;
		try {
			ListContainer myContainer = new ListContainer();
			File listFile = new File("list.json");
			listWriter = new FileWriter(listFile);
			for (ToDoItem item : todoItems) {
				myContainer.todoArrayList.add(item);
			}
			for (int counter = 0; counter < todoItems.size(); counter++) {
				System.out.println(myContainer.todoArrayList.get(counter));
			}
//			System.out.println(myContainer.todoArrayList.get(1));
//			listWriter.write(jsonGenerateString(myContainer.todoArrayList));
			listWriter.write(jsonGenerateString(myContainer));

			listWriter.close();
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}


//	public void containerDump(ListContainer container) {
//		for (ToDoItem item : todoItems) {
//			container.userTodoList.add(item);
//			System.out.println(item);
//		}
//	}

	public String jsonGenerateString(ListContainer container) {
		JsonSerializer jsonSerializer = new JsonSerializer().deep(true);
		String jsonString = jsonSerializer.serialize(container);

		return jsonString;
	}

	public ToDoItem jsonRestore(String jsonTD) {
		JsonParser toDoItemParser = new JsonParser();
		ToDoItem item = toDoItemParser.parse(jsonTD, ToDoItem.class);

		return item;
	}



}
