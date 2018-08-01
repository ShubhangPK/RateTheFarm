package com.example.msrit.ratethefarm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private  List<UserData> UserItems;
    private Context context;

    public MyAdapter(List<UserData> UserItems, FarmersList context) {
        this.UserItems = UserItems;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_data, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserData listItem = UserItems.get(position);

        holder.mName.setText(listItem.Name);
       // holder.mAge.setText(listItem.getAge());
        holder.mVillage.setText(listItem.Village);
        holder.mCrop.setText(listItem.Crop);
        holder.mLand.setText(listItem.Land);
        holder.mAnimals.setText(listItem.Animals);
        holder.mRating.setText(listItem.Rating);
    }

    @Override
    public int getItemCount() {
        return UserItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mName;
        public TextView mAge;
        public TextView mVillage;
        public TextView mCrop;
        public TextView mLand;
        public TextView mAnimals;
        public TextView mRating;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mAge = itemView.findViewById(R.id.age);
            mVillage = itemView.findViewById(R.id.village);
            mCrop = itemView.findViewById(R.id.crop);
            mLand = itemView.findViewById(R.id.land);
            mAnimals = itemView.findViewById(R.id.animals);
            mRating = itemView.findViewById(R.id.rating);
        }
    }
}
