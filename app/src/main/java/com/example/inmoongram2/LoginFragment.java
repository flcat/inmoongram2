package com.example.inmoongram2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private TextView regText;
    private EditText UserId,UserPassword;
    private Button LoginBtn;

    OnLoginFormActivityListener loginFormActivityListener;

    public interface OnLoginFormActivityListener {
        public void performRegister();
        public void performLogin(String name);
    }

    public LoginFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        regText = view.findViewById(R.id.register_txt);
        UserId = view.findViewById(R.id.edit_login_id);
        UserPassword = view.findViewById(R.id.edit_login_pwd);
        LoginBtn = view.findViewById(R.id.login_btn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFormActivityListener.performRegister();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }
    private void performLogin() {
        String userid = UserId.getText().toString();
        String userpwd = UserPassword.getText().toString();

        //Log.e("아이디비밀번호",userid+userpwd);
        Call<User> call = ApiClient
                .getInstance()
                .getApi()
                .performUserLogin(userid,userpwd);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("success")) {
                    MainActivity.prefConfig.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getuserName());
                } else if (response.body().getResponse().equals("failed")) {
                    MainActivity.prefConfig.displayToast("Login Failed..please try again...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        UserId.setText("");
        UserPassword.setText("");
    }
}
