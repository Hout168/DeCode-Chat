package kh.com.rupp.ckcc.lapitchatapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends Activity {

    private static final String TAG = "Hout";
    private TextInputEditText mDisplayName;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private Button mCreateBtn;

    // Firebase
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        //Android Fields
        mDisplayName = findViewById(R.id.reg_display_name);
        mEmail =  findViewById(R.id.reg_email);
        mPassword =  findViewById(R.id.reg_password);
        mCreateBtn = findViewById(R.id.reg_CreateBtn);


        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display_name = mDisplayName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                register_user(display_name,email,password);
            }
        });
    }

    private void register_user( String display_name,String email, String password) {
        Log.d(TAG,"StartRegister");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG,"RegisterFinish");
                if(task.isSuccessful()){

                    Intent mainIntent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(mainIntent);

                }else{
                    Log.d(TAG,"RegisteError:" + task.getException());
                    Toast.makeText(RegisterActivity.this,"You got some error.",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
