package com.example.inmoongram2;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;

public class WriteFragment extends Fragment {

    private int post_num;
    private String title,mContent,uri,lat,lng,shared_date;

    private TextView share,myLocation;
    private EditText content;
    private Uri contentPhotoUri;
    private ImageView contentImgView;

    public WriteFragment(){
        //
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write, container, false);

        share = view.findViewById(R.id.textView_share);
        content = view.findViewById(R.id.edit_content);
        contentImgView = view.findViewById(R.id.imgView_photo);
        myLocation = view.findViewById(R.id.textView_myLocation);

        return view;
    }

    public void performWrite(){

        mContent = content.getText().toString();


        Call<Post> call = ApiClient
                .getInstance()
                .getApi()
                .postwrite(post_num,title,mContent,uri,lat,lng,shared_date);
    }
}
