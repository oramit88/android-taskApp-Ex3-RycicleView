package il.ac.shenkar.todo_app;

import java.util.List;

/**
 * Created by KerenX on 07/11/2015.
 */

public interface IDataAccess {
    List<TodoItem> GetTodoList();
    void SetTodoItem(TodoItem item);
}
