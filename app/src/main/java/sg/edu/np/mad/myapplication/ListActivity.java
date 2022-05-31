package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<user> userlist = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            user user1 = createUser();
            userlist.add(user1);
            Log.i(TAG, "1");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter mAdapter = new adapter(ListActivity.this,userlist);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
    private user createUser(){
        user user1 = new user();
        int ran1 = randomOTP();
        int ran2 = randomOTP();
        user1.name = "Name" + ran1;
        user1.followed = false;
        user1.description = "Description " + ran2;
        return user1;
    }
}