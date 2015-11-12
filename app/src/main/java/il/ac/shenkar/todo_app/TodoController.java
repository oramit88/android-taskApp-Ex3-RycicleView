package il.ac.shenkar.todo_app;

import java.util.List;

/**
 * Created by KerenX on 07/11/2015.
 */

public class TodoController implements ITodoController {
    private IDataAccess data;

    public TodoController() { data = DataAccess.getInstance(); }

    public List<TodoItem> GetTodoList() {
        return data.GetTodoList();
    }

    public void SetItemToList(TodoItem item)
    {
        data.SetTodoItem(item);
    }

}
