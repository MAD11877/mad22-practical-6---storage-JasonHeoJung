package sg.edu.np.mad.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<user> data;
    Context mContext;
    AlertDialog.Builder builder;
    public adapter (Context context, ArrayList<user> input){
        data = input;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        user s = data.get(position);
        if (s.name.endsWith("7")) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View item2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler2, parent, false);
            return new ViewHolder(item2);
        }
        View item1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
        return new ViewHolder(item1);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        user s = data.get(position);
        holder.txt.setText(s.name);
        holder.txtdes.setText(s.description);
        builder = new AlertDialog.Builder(mContext);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Profile");
                builder.setMessage(s.name);
                builder.setPositiveButton(
                        "VIEW",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent myIntent = new Intent(mContext, MainActivity.class);
                                myIntent.putExtra("key",s);
                                mContext.startActivity(myIntent);
                            }
                        });
                builder.setNegativeButton(
                        "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
    }

    public int getItemCount(){
        return data.size();
    }
}
