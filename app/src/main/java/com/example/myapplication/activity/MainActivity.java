package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Comment;
import com.example.myapplication.model.Post;
import com.example.myapplication.retrofit.ApiClient;
import com.example.myapplication.retrofit.jsonPPlaceHolderApi;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private jsonPPlaceHolderApi jsonPlaceHolderApi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        jsonPlaceHolderApi = ApiClient.getRetrofitInstance().create(jsonPPlaceHolderApi.class);

        //getPosts();

        // getComments();

        //CreatePost();

        // updatePut();

       // updatePatch();

        deletePost();
    }


    private void getPosts() {

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(2);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "text:" + post.getBody() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


    private void getComments() {

        Call<List<Comment>> call = jsonPlaceHolderApi.getComments(2);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("code" + response.code());
                    return;
                }
                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "POST ID: " + comment.getPostId() + "\n";
                    content += "User NAME: " + comment.getName() + "\n";
                    content += "USER EMAIL: " + comment.getEmail() + "\n";
                    content += "text:" + comment.getBody() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void CreatePost() {

        Post post = new Post(4, "New title", "New Body Text");

        Call<Post> call = jsonPlaceHolderApi.CreatePost(4, "new title", "text something");


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code" + response.code());
                    return;
                }
                Post postresponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle() + "\n";
                content += "text:" + postresponse.getBody() + "\n\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });

    }

    private void updatePut() {
        //This patch method  update  all value,other value is  change or  represent null

        Post post = new Post(4, null, "New Text");

        Call<Post> call = jsonPlaceHolderApi.PutPostUpdate(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code" + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "text:" + postResponse.getBody() + "\n\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void updatePatch() {
        //This patch method only update  call value,other value is same not change or null represent

        Post post = new Post(4, null, "New Text");

        Call<Post> call = jsonPlaceHolderApi.PatchPostUpdate(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code" + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "text:" + postResponse.getBody() + "\n\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void deletePost(){
        Call<Void>call = jsonPlaceHolderApi.deletePost(4);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code: "+response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });

    }


}