package il.ac.shenkar.todo_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KerenX on 07/11/2015.
 */

public class DataAccess implements IDataAccess {
    private static DataAccess instance;
    private List<TodoItem> todoItems;


    public DataAccess()
    {
        this.todoItems = new ArrayList<TodoItem>();
    }

    /* Singletone implement. */
    public static DataAccess getInstance()
    {
        if(instance ==  null)
            instance = new DataAccess();
        return instance;
    }


    public List<TodoItem> GetTodoList() {
        return CreateTodoList();
    }

    public List<TodoItem> CreateTodoList() {
        int image1 = R.drawable.buy_coffee;
        TodoItem todoItem1 = new TodoItem("Buy coffee", image1);
        todoItems.add(todoItem1);

        int image2 = R.drawable.homework;
        TodoItem todoItem2 = new TodoItem("Do my homework", image2);
        todoItems.add(todoItem2);

        int image3 = R.drawable.clean_house;
        TodoItem todoItem3 = new TodoItem("Clean my apartment", image3);
        todoItems.add(todoItem3);

        return todoItems;
    }



    public void SetTodoItem(TodoItem item)
    {
        todoItems.add(item);
    }

}
