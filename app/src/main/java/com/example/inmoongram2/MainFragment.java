package com.example.inmoongram2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


    /**
     * A simple {@link Fragment} subclass.
     */
    public class MainFragment extends Fragment {

        private TextView textView;
        private Button logoutBtn;
        OnLogoutListener logoutListener;

        public interface OnLogoutListener {
            public void logoutPerformed();
        }
        public MainFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            textView = view.findViewById(R.id.txt_name_info);
            textView.setText("Welcome "+MainActivity.prefConfig.readName());
            logoutBtn = view.findViewById(R.id.mainfragm_Logout_Btn);

            logoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logoutListener.logoutPerformed();
                }
            });
            return view;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Activity activity = (Activity) context;
            logoutListener = (OnLogoutListener) activity;
        }
}
