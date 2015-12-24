package il.ac.shenkar.todo_app;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TodoListBaseAdapter extends RecyclerView.Adapter<TodoListBaseAdapter.ViewHolder> {
    private List<TodoItem> todoItems;


    public TodoListBaseAdapter(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView todo_textView;
        ImageView todo_imageView;

        public ViewHolder (View parentView) {
            super(parentView);

            todo_textView = (TextView) parentView.findViewById(R.id.todoTextView);
            todo_imageView = (ImageView) parentView.findViewById(R.id.imageView);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_todo_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoItem todoItem = todoItems.get(position);

        holder.todo_textView.setText(todoItem.getTodoItemText());
        holder.todo_imageView.setImageResource(todoItem.getTodoItemImage()); ///////// TODO %s ???
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

}

















