package com.example.guest.moviedatabase.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.moviedatabase.R;
import com.example.guest.moviedatabase.models.Cast;
import com.example.guest.moviedatabase.models.Movies;
import com.example.guest.moviedatabase.ui.ActorDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/28/16.
 */
public class CastListAdapter extends RecyclerView.Adapter<CastListAdapter.CastViewHolder> {
    private ArrayList<Cast> mCasts = new ArrayList<>();
    private Context mContext;

    public CastListAdapter(Context context, ArrayList<Cast> casts) {
        mContext = context;
        mCasts = casts;
    }

    @Override
    public CastListAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_list_item, parent, false);
        CastViewHolder viewHolder = new CastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CastListAdapter.CastViewHolder holder, int position) {
        holder.bindCast(mCasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mCasts.size();
    }



    public class CastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.actorImageView)
        ImageView mActorImageView;
        @Bind(R.id.actorTextView)
        TextView mActorTextView;
        @Bind(R.id.characterTextView)
        TextView mCharacterTextView;
        private Context mContext;

        private Cast mCast;




        public CastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

//            itemView.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    String id = mCast.getActorId() + "";
//                    Log.d("cast id", id + "");
//                    Intent intent = new Intent(mContext, ActorDetailActivity.class);
//                    intent.putExtra("id", id + "");
//                    mContext.startActivity(intent);
//                }
//            });
        }

        public void bindCast(Cast cast) {
            Picasso.with(mContext).load(cast.getImage()).into(mActorImageView);
            mActorTextView.setText(cast.getName());
            mCharacterTextView.setText(cast.getCharacter());
        }
    }
}
