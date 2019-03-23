package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainView extends Activity {

    private EditText name;
    private EditText password;
    private EditText email;
    private Button button_register;
    private Button button_linkToLogin;
    private EditText login_name;
    private EditText login_password;
    private Button button_login;
    private Button button_linkToRegister;
   // private Button button_logout;

    @Override
    public void onCreate(Bundle savedInstateState){
        super.onCreate(savedInstateState);
        setContentView(R.layout.register);

        name = findViewById(R.id.name);
        password=findViewById(R.id.registerpassword);
        email=findViewById(R.id.registeremail);
        button_register=findViewById(R.id.btnregister);
        button_linkToLogin=findViewById(R.id.btnLinkToLoginScreen);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerTask task=new registerTask();
                task.execute();
            }
        });


        button_linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.login);
                button_login=findViewById(R.id.btnlogin);
                login_name=findViewById(R.id.email);
                login_password=findViewById(R.id.password);
                button_linkToRegister=findViewById(R.id.btnLinkToRegisterScreen);
                button_linkToRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.register);
                        name=findViewById(R.id.name);
                        password=findViewById(R.id.registerpassword);
                        email=findViewById(R.id.registeremail);
                        button_register=findViewById(R.id.btnregister);
                        button_linkToLogin=findViewById(R.id.btnLinkToLoginScreen);



                        button_register.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                registerTask task=new registerTask();
                                task.execute();
                            }
                        });
                        button_linkToLogin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.login);
                                button_login=findViewById(R.id.btnlogin);
                            }
                        });

                    }
                });

                button_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loginTask task=new loginTask();
                        task.execute();
                    }
                });

            }
        });


    }




    class registerTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString("name",name.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.putString("email",email.getText().toString());
            editor.apply();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainView.this, "Sign up success!", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.login);
            login_name=findViewById(R.id.email);
            login_password=findViewById(R.id.password);
            button_login=findViewById(R.id.btnlogin);
            button_linkToRegister=findViewById(R.id.btnLinkToRegisterScreen);
            button_linkToRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.register);
                    name=findViewById(R.id.name);
                    password=findViewById(R.id.registerpassword);
                    email=findViewById(R.id.registeremail);
                    button_register=findViewById(R.id.btnregister);
                    button_linkToLogin=findViewById(R.id.btnLinkToLoginScreen);



                    button_register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            registerTask task=new registerTask();
                            task.execute();
                        }
                    });

                    button_linkToLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.login);
                            button_login=findViewById(R.id.btnlogin);
                        }
                    });

                }
            });

            button_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginTask task=new loginTask();
                    task.execute();
                }
            });
        }
    }

    class loginTask extends AsyncTask<Void,Void,Boolean>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
            String name_store=pref.getString("email","");
            String password_store=pref.getString("password","");
            if(login_name.getText().toString().equals(name_store)){
                if(login_password.getText().toString().equals(password_store)){
                    return true;
                }
            }else{
                return false;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean==true){
             //   Toast.makeText(MainView.this, "Login Success!", Toast.LENGTH_SHORT).show();
                //setContentView(R.layout.monthacc);
                Intent intent = new Intent();
                intent.setClass(MainView.this,MainPage1.class);
                startActivity(intent);
//                button_logout=findViewById(R.id.btnLogout);
//                button_logout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        setContentView(R.layout.layout_login);
//                    }
//                });
            }else{
                Toast.makeText(MainView.this, "Name not exist!", Toast.LENGTH_SHORT).show();
            }
        }
    }





}
