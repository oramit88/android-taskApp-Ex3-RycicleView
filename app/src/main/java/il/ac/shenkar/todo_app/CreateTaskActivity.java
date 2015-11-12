package il.ac.shenkar.todo_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class CreateTaskActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        final Button taskButton = (Button)this.findViewById(R.id.createTaskButton);

        taskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.newTaskText);
                String newTodoText = editText.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("todoItemText", newTodoText);    // to add its text value to the intent
                setResult(1, intent);
                finish();
            }
        });
    }
}
