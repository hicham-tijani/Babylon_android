package it.itsar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends AppCompatActivity  {
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;

    private TextView camera,gallery, cancel;
    private ImageView post;
    private RecyclerView recyclerView;
    private EditText edd;
    private ImageButton profile,addBtn;
    private ArrayList<Instagram> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        arrayList.add(new Instagram(R.drawable.sinana, R.drawable.cartoon,"ht_spaceman"));
        arrayList.add(new Instagram(R.drawable.face_logo, R.drawable.thing,"iconeo"));
        arrayList.add(new Instagram(R.drawable.face_logo2, R.drawable.delaaah_logo,"delaaah"));
        arrayList.add(new Instagram(R.drawable._33, R.drawable.maroc,"433"));
        arrayList.add(new Instagram(R.drawable.dvx, R.drawable.face,"ardnofficial"));
        arrayList.add(new Instagram(R.drawable.nasa_logo, R.drawable.nasa,"NASA"));


        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ImageButton gotoprofile = findViewById(R.id.gotoProfile);
        gotoprofile.setOnClickListener(view -> {
            Intent intent  = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);
        });

        addBtn = findViewById(R.id.addImage);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewPost.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.icons8_bebo_32);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_bar, menu);

            return super.onCreateOptionsMenu(menu);
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.maps:
                startActivity(new Intent(this, Maps.class));
                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }
}

