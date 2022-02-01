package com.example.mvvm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButtonLogin;
    private EditText mEditLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mButtonLogin = findViewById(R.id.button_login);
        this.mEditLogin = findViewById(R.id.edit_login);

        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

        this.mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEditLogin.getText().toString();
                vm.doLogin(email);
            }
        });

        vm.login.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if(success){
                    Toast.makeText(getApplicationContext(),"Sucesso",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}