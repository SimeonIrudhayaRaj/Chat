package com.sir.chat__app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.github.bassaer.chatmessageview.model.IChatUser;
import com.github.bassaer.chatmessageview.model.Message;
import com.github.bassaer.chatmessageview.view.ChatView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Chat_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private ChatView mChatView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public boolean isOnline(Context context)
    {
        boolean isOnline = false;
        try
        {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            isOnline = (netInfo != null && netInfo.isConnected());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return isOnline;
    }

    int i=0;
void add_img(){


        if(i%2==0) {
            Message message = new Message.Builder().setUser(new IChatUser() {
                @NotNull
                @Override
                public String getId() {
                    return null;
                }

                @Nullable
                @Override
                public String getName() {
                    return null;
                }

                @Nullable
                @Override
                public Bitmap getIcon() {
                    return null;
                }

                @Override
                public void setIcon(@NotNull Bitmap bitmap) {

                }
            })
                    .setRight(true)
                    .setText("sample send")
                    .hideIcon(true)
                    .build();
            mChatView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            Bitmap picture = BitmapFactory.decodeResource(getResources(),  R.mipmap.image
            );
            message.setPicture(picture);
            message.setType(Message.Type.PICTURE);

            mChatView.send(message);
        }else
        {
            final Message receivedMessage = new Message.Builder().setUser(new IChatUser() {
                @NotNull
                @Override
                public String getId() {
                    return null;
                }

                @Nullable
                @Override
                public String getName() {
                    return null;
                }

                @Nullable
                @Override
                public Bitmap getIcon() {
                    return null;
                }

                @Override
                public void setIcon(@NotNull Bitmap bitmap) {

                }
            })
                    .setRight(false)
                    .setText("sample receive")
                    .build();

            mChatView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
            receivedMessage.setPicture(picture);
            receivedMessage.setType(Message.Type.PICTURE);
            mChatView.receive(receivedMessage);

        }

    i++;
}
void add_msg(){

    if(i%2==0) {
        Message message = new Message.Builder().setUser(new IChatUser() {
            @NotNull
            @Override
            public String getId() {
                return null;
            }

            @Nullable
            @Override
            public String getName() {
                return null;
            }

            @Nullable
            @Override
            public Bitmap getIcon() {
                return null;
            }

            @Override
            public void setIcon(@NotNull Bitmap bitmap) {

            }
        })
                .setRight(true)
                .setText("sample send")
                .hideIcon(true)
                .build();
        mChatView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

        mChatView.send(message);
    }else {
        final Message receivedMessage = new Message.Builder().setUser(new IChatUser() {
            @NotNull
            @Override
            public String getId() {
                return null;
            }

            @Nullable
            @Override
            public String getName() {
                return null;
            }

            @Nullable
            @Override
            public Bitmap getIcon() {
                return null;
            }

            @Override
            public void setIcon(@NotNull Bitmap bitmap) {

            }
        })
                .setRight(false)
                .setText("sample receive")
                .build();

        mChatView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        mChatView.receive(receivedMessage);
    }
    i++;
    mChatView.scrollToEnd();

}
    void add()
    {
        if(!isOnline(getActivity()))
        {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame,new internet_check()).commit();

        }
        if(i%5==0)
        {
            add_img();
        }
        else
        {
            add_msg();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_chat_page, container, false);


        mChatView = (ChatView)v.findViewById(R.id.chat_view);
        mChatView.setRightBubbleColor(ContextCompat.getColor(v.getContext(), R.color.green500));
        mChatView.setLeftBubbleColor(Color.WHITE);
        mChatView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.blueGray500));
        mChatView.setSendButtonColor(ContextCompat.getColor(v.getContext(), R.color.blueGray200));
        mChatView.setSendIcon(R.drawable.ic_action_send);
        mChatView.setRightMessageTextColor(Color.WHITE);
        mChatView.setLeftMessageTextColor(Color.BLACK);
        mChatView.setUsernameTextColor(Color.WHITE);
        mChatView.setSendTimeTextColor(Color.WHITE);
        mChatView.setDateSeparatorColor(Color.WHITE);
        mChatView.setInputTextHint("new message...");
        mChatView.setMessageMarginTop(5);
        mChatView.setMessageMarginBottom(5);
        mChatView.setInputTextHint("aaaaa\t\tThis is a sample input");
        mChatView.setOnBubbleClickListener(new Message.OnBubbleClickListener() {
            @Override
            public void onClick(@NotNull Message message) {
                add();
            }
        });
        mChatView.getMessageView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                add();
            }
        });

        add();
        add();
        add();
        add();
        add();
        add();

        return  v;

    }


}
