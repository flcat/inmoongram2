package com.example.inmoongram2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
     * A simple {@link Fragment} subclass.
     */
    public class MainFragment extends Fragment {

        private RecyclerView recyclerView;
        private RecyclerView.LayoutManager layoutManager;
        private RecyclerAdapter adapter;
        private List<Contact> contacts;
        private ApiInterface apiInterface;

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

            recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_postlist);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            apiInterface = ApiClient.ApiClient().create(ApiInterface.class);
            Call<List<Contact>> call = apiInterface.getContacts();

            call.enqueue(new Callback<List<Contact>>() {
                @Override
                public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                    contacts = response.body();
                    adapter = new RecyclerAdapter(contacts,getContext());
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Contact>> call, Throwable t) {

                }
            });


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
