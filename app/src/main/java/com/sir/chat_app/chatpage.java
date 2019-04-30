package com.sir.chat_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sir.chat_app.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class chatpage extends Fragment implements RecyclerView.OnClickListener {

    List<messagecount> msg= new ArrayList<>();
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    ChatRecyclerViewAdapter ad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.chatpage, container, false);
        Log.i("hi19", "hi19");

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            ad=new ChatRecyclerViewAdapter(msg, mListener);

            recyclerView.setAdapter(ad);

        }

        messagecount mm = new messagecount(2,2);
        msg.add(mm);
        msg.add(mm);
        msg.add(mm);


        return view;



    }
    void add()
    {
//        Toast.makeText(getContext(),"ssssd",Toast.LENGTH_SHORT).show();

        messagecount mm = new messagecount(2,2);
        msg.add(mm);
        msg.add(mm);
        msg.add(mm);
//        ad.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }


    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
