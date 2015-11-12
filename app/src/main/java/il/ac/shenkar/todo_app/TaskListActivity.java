package il.ac.shenkar.todo_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends Activity {

    private ITodoController todoController;
    private TodoListBaseAdapter todoListBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        todoController =  new TodoController();
        ListView  lv = (ListView) findViewById(R.id.listView);

        if(lv != null)
        {
            TodoListBaseAdapter adapter = new TodoListBaseAdapter(this, todoController.GetTodoList());
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(TaskListActivity.this, "Item number "+(position+1)+" was clicked" , Toast.LENGTH_LONG).show();
                }
            });
        }

        Button addNewTaskButton = (Button)this.findViewById(R.id.AddTaskButton);
        addNewTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {   // what will happen when we click ADD NEW TASK
                Intent addTaskActivity = new Intent(v.getContext() , CreateTaskActivity.class);
                startActivityForResult(addTaskActivity, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            String todoItemText = data.getStringExtra("todoItemText").toString();
            todoController.SetItemToList(new TodoItem(todoItemText, R.drawable.default_pic));
        }
    }
}
