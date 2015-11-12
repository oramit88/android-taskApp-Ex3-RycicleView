package il.ac.shenkar.todo_app;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KerenX on 03/11/2015.
 */

public class TodoListBaseAdapter extends BaseAdapter{
    private Context context;
    private List<TodoItem> todoItems;


    public TodoListBaseAdapter(Context context, List<TodoItem> todoItems) {
        this.todoItems = todoItems;
        this.context = context;
    }


    static class ViewHolder {
        TextView todo_textView;
        ImageView todo_imageView;
    }


    @Override   // have to implement because of the BaseAdapter
    public int getCount(){
        return todoItems.size();
    }

    @Override   // have to implement because of the BaseAdapter
    public long getItemId(int position) {  // have to implement because of the BaseAdapter
        return position;
    }

    @Override   // have to implement because of the BaseAdapter
    public Object getItem(int position) {
        if (this.todoItems != null && todoItems.size() > position)
            return this.todoItems.get(position);
        return null;
    }

    @Override   // have to implement because of the BaseAdapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_todo_item, null);

            holder = new ViewHolder();
            holder.todo_textView = (TextView) convertView.findViewById(R.id.todoTextView);
            holder.todo_imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.todo_textView.setText(todoItems.get(position).getTodoItemText());
        holder.todo_imageView.setImageResource(todoItems.get(position).getTodoItemImage());
        return convertView;
    }
}

















