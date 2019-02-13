package com.example.myapplication.retrofit;

import com.example.myapplication.model.Comment;
import com.example.myapplication.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface jsonPPlaceHolderApi {


    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId
                              //@Query("_sort") String sort,
                              //@Query("_order") String order
    );


    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);


    @POST("Posts")
    Call<Post> CreatePost(@Body Post post);


    @POST("Posts")
    @FormUrlEncoded
    Call<Post> CreatePost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @PUT("Posts/{id}")
    Call<Post> PutPostUpdate(@Path("id") int id, @Body Post post);


    @PATCH("Posts/{id}")
    Call<Post> PatchPostUpdate(@Path("id") int id, @Body Post post);

    @DELETE("Posts/{id}")
    Call<Void>deletePost(@Path("id")int id);

}
