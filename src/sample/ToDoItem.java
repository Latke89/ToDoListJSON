package sample;

import java.io.File;

/**
 * Created by Brett on 8/30/16.
 */
public class ToDoItem {

		public String text;
		public boolean isDone;

	public ToDoItem(String text, boolean isDone) {
		this.text = text;
		this.isDone = isDone;
	}

	public ToDoItem(String text) {
			this.text = text;
			this.isDone = false;
		}

		@Override
		public String toString() {
			if (isDone) {
				return text + " (done)";
			} else {
				return text;
			}
			// A one-line version of the logic above:
			// return text + (isDone ? " (done)" : "");
		}


}
