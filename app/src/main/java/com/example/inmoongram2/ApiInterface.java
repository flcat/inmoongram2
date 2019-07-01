package com.example.inmoongram2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //회원가입
    @GET("Register2.php")
    Call<User> performRegistraion(@Query("user_id") String user_id,
                          @Query("password") String password,
                          @Query("name") String name,
                          @Query("photoUri") String photoUri);

    //로그인
    @GET("Login2.php")
    Call<User> performUserLogin(@Query("user_id") String user_id,
                                @Query("password") String password);
}