package com.example.murugesan.pappa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity {
    EditText editTextUserName, editTextPassword, editTextConfirmPassword,editTextRegno,editTextStudent,editTextEmail,editTextdob,editTextMob;
    Button btnCreateAccount;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        editTextRegno = (EditText) findViewById(R.id.editTextRegno);
        editTextStudent = (EditText) findViewById(R.id.editTextStudentname);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextdob = (EditText) findViewById(R.id.editTextDob);
        editTextMob = (EditText) findViewById(R.id.editTextMobile);

        btnCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText()
                        .toString();
                String reg = editTextRegno.getText().toString();
                String stu = editTextStudent.getText().toString();
                String email = editTextEmail.getText().toString();
                String dob = editTextdob.getText().toString();
                String mob = editTextMob.getText().toString();
                if (userName.equals("") || password.equals("")
                        || confirmPassword.equals("")|| reg.equals("")|| stu.equals("")|| email.equals("")|| dob.equals("")|| mob.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(),
                            "Password does not match", Toast.LENGTH_LONG)
                            .show();
                    return;
                } else {

                    loginDataBaseAdapter.insertEntry(userName,password,reg,stu,email,dob,mob);
                    Toast.makeText(getApplicationContext(),
                            "Account Successfully Created ", Toast.LENGTH_LONG)
                            .show();
                    Intent i = new Intent(SignUPActivity.this,
                            HomeActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}