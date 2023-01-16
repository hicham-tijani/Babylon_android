package it.itsar.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

public class Profile extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    LinearLayout hiddenView;
    private ImageButton btn_logout;
    private ImageButton collapse;
    private ImageButton home;
    private TextView name,email;
    private ImageView image,posted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        ImageButton btn_logout = findViewById(R.id.logout);
        ImageView image = findViewById(R.id.profileImg);
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        hiddenView = findViewById(R.id.hidden_view);
        ImageButton collapse = findViewById(R.id.collapse_btn);
        String username = getIntent().getStringExtra("value");
        name.setText(username);

        posted = findViewById(R.id.posted);
        Bitmap bitImage=getIntent().getParcelableExtra("bitmap");
        posted.setImageBitmap(bitImage);

        Intent in = getIntent();
        String string = in.getStringExtra("message");

        collapse.setOnClickListener(view -> {
            // If the CardView is already expanded, set its visibility
            // to gone and change the expand less icon to expand more.
            if (hiddenView.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(hiddenView, new AutoTransition());
                hiddenView.setVisibility(View.GONE);
                collapse.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(hiddenView, new AutoTransition());
                hiddenView.setVisibility(View.VISIBLE);
                collapse.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
            }
        });


        btn_logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Confirmation PopUp").
                    setMessage("You sure, that you want to logout?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent i = new Intent(getApplicationContext(),
                                    MainActivity.class);
                            startActivity(i);
                        }
                    });
            builder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder.create();
            alert11.show();
        });


        ImageButton home = findViewById(R.id.btn_home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {

            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personImage = acct.getPhotoUrl();
            name.setText(personName);
            email.setText(personEmail);
            Picasso.get().load(acct.getPhotoUrl()).placeholder(R.mipmap.ic_launcher).into(image);
        }

// disconnette l'account google

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });



    }


    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Confirmation PopUp").
                        setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });

    }

    }
