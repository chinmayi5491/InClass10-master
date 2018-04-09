package com.uncc.mobileappdev.inclass10;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/*
 * Created by CHINU on 4/9/2018.
 */

public class MessageThreadsAdapter extends ArrayAdapter<Thread> {
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       final Thread thread= getItem(position);
        final ViewHolder viewHolder;
        ListView lv;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_thread_message,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.MessageThread= (TextView) convertView.findViewById(R.id.MessageThread);
            viewHolder.remove= (ImageButton) convertView.findViewById(R.id.imageButtonDelete);
            /*viewHolder.textViewEmail= (TextView) convertView.findViewById(R.id.textViewEmail);*/
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            /*viewHolder.MessageThread.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   callIntent();
                }
            });
*/


        }
        viewHolder.remove= (ImageButton) convertView.findViewById(R.id.imageButtonDelete);
        viewHolder.remove.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Log.d("demo","ImageButton clicked"+ position);

                    }
                });

        viewHolder.MessageThread.setText(thread.title);
        /*viewHolder.remove.setText(email.summary);
        viewHolder.textViewEmail.setText(email.sender);*/
        return convertView;
    }
    private static class ViewHolder{
        TextView MessageThread;
        ImageButton remove;



    }
/*ublic interface CallActivity{
    public void callIntent();

    }*/
    public MessageThreadsAdapter(@NonNull Context context, int resource, @NonNull List<Thread> objects) {
        super(context, resource, objects);
    }
}
