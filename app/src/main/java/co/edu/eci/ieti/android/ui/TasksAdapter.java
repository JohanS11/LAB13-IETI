package co.edu.eci.ieti.android.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.edu.eci.ieti.R;
import co.edu.eci.ieti.android.network.data.Task;

public class TasksAdapter
        extends RecyclerView.Adapter<TasksAdapter.ViewHolder>
{

    List<Task> taskList = null;

    public TasksAdapter(List<Task> tasks) {
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType )
    {
        return new ViewHolder( LayoutInflater.from( parent.getContext() ).inflate( R.layout.task_row, parent, false ) );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position )
    {
        Task task = taskList.get( position );
        ((TextView) holder.itemView.findViewById(R.id.name)).setText(task.getDescription());
        ((TextView) holder.itemView.findViewById(R.id.priority)).setText("Priority: "+ task.getPriority());
        ((TextView) holder.itemView.findViewById(R.id.date)).setText("Date: "+ task.getDueDate().toString());
    }

    @Override
    public int getItemCount()
    {
        return taskList != null ? taskList.size() : 0;
    }

    public void updateTasks(List<Task> tasks){
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    class ViewHolder
            extends RecyclerView.ViewHolder
    {
        ViewHolder( @NonNull View itemView )
        {
            super( itemView );
        }
    }

}