package sg.edu.np.mad.myapplication;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView txt;
    TextView txtdes;
    public ViewHolder(View itemView){
        super(itemView);
        image = itemView.findViewById(R.id.imageView3);
        txt = itemView.findViewById(R.id.textView3);
        txtdes = itemView.findViewById(R.id.textView4);
    }

}
