package il.ac.shenkar.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;


public class TaskListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ITodoController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controller = new TodoController();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TodoListBaseAdapter(controller.GetTodoList());
        mRecyclerView.setAdapter(mAdapter);


        Button addNewTaskButton = (Button)this.findViewById(R.id.AddTaskButton);
        addNewTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // what will happen when we click ADD NEW TASK
                Intent addTaskActivity = new Intent(v.getContext(), CreateTaskActivity.class);
                startActivityForResult(addTaskActivity, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            String todoItemText = data.getStringExtra("todoItemText").toString();
            controller.SetItemToList(new TodoItem(todoItemText, R.drawable.default_pic));
        }
    }

}
