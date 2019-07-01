package com.example.inmoongram2;


import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {

    private EditText userId,userName,userPassword;
    private ImageView userPhoto;
    private Uri userphotoUri;
    private Button registerBtn;


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        userId = view.findViewById(R.id.edit_signup_id);
        userName = view.findViewById(R.id.edit_signup_name);
        userPassword = view.findViewById(R.id.edit_signup_pwd);
        userPhoto = view.findViewById(R.id.userphoto_signup_imgv);
        registerBtn = view.findViewById(R.id.signup_btn);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistraion();
            }
        });
        return view;
    }

    public void performRegistraion() {

        String userid = userId.getText().toString();
        String username = userName.getText().toString();
        String userpassword = userPassword.getText().toString();
        String userphoto = "http://flcat.vps.phps.kr/uploads/images/15605099469451560770742368.jpg"; //userphotoUri.toString();
        Call<User> call = ApiClient
                .getInstance()
                .getApi()
                .performRegistraion(userid,username,userpassword,userphoto);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                    response.body().getResponse();
                if (response.body().getResponse().equals("success")) {
                    MainActivity.prefConfig.displayToast("Registration success...");
                } else if (response.body().getResponse().equals("exist")) {
                    MainActivity.prefConfig.displayToast("User already exist...");
                } else if (response.body().getResponse().equals("error")) {
                    MainActivity.prefConfig.displayToast("Something went wrong...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
        userId.setText("");
        userPassword.setText("");
        userName.setText("");
    }
}
