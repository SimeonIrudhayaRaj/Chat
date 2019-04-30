package com.sir.chat_app;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sir.chat_app.chatpage.OnListFragmentInteractionListener;
import com.sir.chat_app.dummy.DummyContent.DummyItem;

import java.util.List;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {
static int i=0;
    private final List<messagecount> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ChatRecyclerViewAdapter(List<messagecount> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.day.setVisibility(View.GONE);
        holder.img.setVisibility(View.GONE);
        if(i%2==0)
        {

            holder.msg_s.setText("sample Message " + i);
            holder.msg_s.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.msg_r.setText("sample Message " + i);
            holder.msg_r.setVisibility(View.VISIBLE);

        }
        i++;

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                messagecount mm = new messagecount(2,2);
                mValues.add(mm);
                notifyItemChanged(position);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        LinearLayout linearLayout;
        TextView day,msg_s,msg_r;
        ImageView img;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            day= view.findViewById(R.id.day);
            msg_s=view.findViewById(R.id.msg_s);
            msg_r=view.findViewById(R.id.msg_r);
            img=view.findViewById(R.id.image);
            linearLayout = view.findViewById(R.id.linear);


        }

    }
}
