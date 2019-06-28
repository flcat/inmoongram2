package com.example.inmoongram2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //회원가입
    @FormUrlEncoded
    @POST("Register.php")
    Call<User> performRegistraion(@Field("user_id") String user_id,
                          @Field("password") String password,
                          @Field("name") String name,
                          @Field("photoUri") String photoUri);

    @FormUrlEncoded
    //로그인
    @POST("Login.php")
    Call<User> performUserLogin(@Field("user_id") String user_id,
                                @Field("password") String password);
}