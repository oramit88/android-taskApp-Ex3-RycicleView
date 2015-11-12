package il.ac.shenkar.todo_app;

/**
 * Created by KerenX on 03/11/2015.
 */

public class TodoItem {
    private String todoItemText;
    private int todoItemImage;


    public TodoItem(String todoItemText, int todoItemImage)
    {
        super();
        this.todoItemText = todoItemText;
        this.todoItemImage = todoItemImage;
    }


    public String getTodoItemText() {
        return todoItemText;
    }
    public void setTodoItemText(String todoItemText) {
        this.todoItemText = todoItemText;
    }

    public int getTodoItemImage() {
        return todoItemImage;
    }
    public void setTodoItemImage(int todoItemImage) {
        this.todoItemImage = todoItemImage;
    }

}
