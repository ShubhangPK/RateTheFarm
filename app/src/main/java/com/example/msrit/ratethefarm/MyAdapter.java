package com.example.msrit.ratethefarm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.List;

import static android.support.design.widget.CoordinatorLayout.Behavior.setTag;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private  List<UserData> UserItems;
    private Context context;
    public static String mClickID;

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

        final UserData listItem = UserItems.get(position);

        holder.mName.setText(listItem.getName());
        holder.mAge.setText(listItem.getAge());
        holder.mVillage.setText(listItem.getVillage());
        holder.mCrop.setText(listItem.getCrop());
        holder.mLand.setText(listItem.getLand());
        holder.mAnimals.setText(listItem.getAnimals());
        holder.mRating.setText(listItem.getRating());

        holder.mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ShowFarmerDetails.class);

                mClickID = Integer.toString(listItem.getUserID());
                context.startActivity(myIntent);
            }
        });
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
        public ConstraintLayout mConstraintLayout;

        public ViewHolder(final View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mAge = itemView.findViewById(R.id.age);
            mVillage = itemView.findViewById(R.id.village);
            mCrop = itemView.findViewById(R.id.crop);
            mLand = itemView.findViewById(R.id.land);
            mAnimals = itemView.findViewById(R.id.animals);
            mRating = itemView.findViewById(R.id.rating);
            mConstraintLayout = itemView.findViewById(R.id.constraint_layout);

        }
    }
}
