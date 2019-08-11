package com.example.inmoongram2;

import android.net.Uri;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    //SignUp_user
    @GET("Register2.php")
    Call<User> performRegistraion(@Query("user_id") String user_id,
                          @Query("password") String password,
                          @Query("name") String name,
                          @Query("photoUri") String photoUri);

    //Login
    @GET("Login2.php")
    Call<User> performUserLogin(@Query("user_id") String user_id,
                                @Query("password") String password);


    @FormUrlEncoded
    @POST("write2.php")
    Call<Post> postwrite(@Field("post_num") int post_num,
                         @Field("title") String title,
                         @Field("content") String content,
                         @Field("uri") String uri,
                         @Field("lat") String lat,
                         @Field("lng") String lng,
                         @Field("shared_date") String sharedDate);

    //readContents
    @POST("readContacts.php")
    Call<List<Contact>> getContacts();

}