package sg.edu.np.mad.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "loginActivity";
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("Users");
    EditText EtUsername;
    EditText EtPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EtUsername = findViewById(R.id.editTextUsername);
        EtPassword = findViewById(R.id.editTextPass);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = EtUsername.getText().toString();
                String password = EtPassword.getText().toString();

                loginUser(username,password);
            }
        });
    }


    private void loginUser(String etUsername, String etPassword){
        Query checkUser = ref.orderByChild("username").equalTo(etUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){


                    String dbPassword = snapshot.child(etUsername).child("password").getValue(String.class);
                    Log.i(TAG, "password:" + dbPassword);

                    if(dbPassword.equals(etPassword)){
                        Intent loginIntent = new Intent(LoginActivity.this, ListActivity.class);
                        startActivity(loginIntent);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LoginActivity.this, "Password/Username Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}