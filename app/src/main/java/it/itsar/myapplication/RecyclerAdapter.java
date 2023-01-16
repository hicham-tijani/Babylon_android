package it.itsar.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ArrayList<Instagram> arrayList;
    public RecyclerAdapter(ArrayList<Instagram> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Instagram instagram = arrayList.get(position);

        holder.title.setText(instagram.getTitle());
        holder.profileImage.setImageResource(instagram.getProfileIcon());
        holder.postImage.setImageResource(instagram.getPostImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage;
        ImageView postImage;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.ivProfile);
            postImage = itemView.findViewById(R.id.ivPost);
            title = itemView.findViewById(R.id.title);

        }
    }
}
