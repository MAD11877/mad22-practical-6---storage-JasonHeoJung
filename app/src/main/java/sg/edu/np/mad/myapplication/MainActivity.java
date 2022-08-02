package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        Button follow = findViewById(R.id.follow);
        Button message = findViewById(R.id.message);
        TextView name = findViewById(R.id.textView2);
        TextView des = findViewById(R.id.textView);

        user user1 = (user) getIntent().getSerializableExtra("key");
        name.setText(user1.name);
        des.setText(user1.description);
        follow.setText(user1.followed ? "unfollow" : "follow");

        follow.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
                if (!user1.followed){
                    follow.setText("unfollow");
                    user1.followed = true;
                    db.updateUser(user1);
                    Toast.makeText(getApplicationContext(),
                            "followed",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    follow.setText("follow");
                    user1.followed = false;
                    db.updateUser(user1);
                }
            }

        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageIntent);
            }
        });
    }
}