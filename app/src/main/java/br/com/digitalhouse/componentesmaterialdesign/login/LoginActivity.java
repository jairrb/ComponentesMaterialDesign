package br.com.digitalhouse.componentesmaterialdesign.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.componentesmaterialdesign.R;
import br.com.digitalhouse.componentesmaterialdesign.home.MainActivity;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;


    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndGoToHome(view);

            }

            private void validateAndGoToHome(View view) {
                String email = textInputLayoutEmail.getEditText().getText().toString();
                String password = textInputLayoutPassword.getEditText().getText().toString();

                if (email.isEmpty()) {
                    textInputLayoutEmail.setError("Email não informado :(");
                    return;

                } else if (password.isEmpty()) {
                    textInputLayoutPassword.setError("Password não informado :(");
                    return;

                } else if (email.equals("jairrb@live.com") && password.equals("123")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);


                    Bundle bundle = new Bundle();
                    bundle.putString("NAME", "Jair");
                    intent.putExtras(bundle);

                    startActivity(intent,bundle);
                    finish();

                } else {
                    Snackbar.make(textInputLayoutEmail, "Email ou senha invalidos :(", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
