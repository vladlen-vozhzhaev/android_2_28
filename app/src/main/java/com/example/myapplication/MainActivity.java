package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        for (int i = 1; i < 100; i++) {
            users.add("user "+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ListAdapter adapter = new ListAdapter(users);
        recyclerView.setAdapter(adapter);
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        String userName;
        TextView singleItemTextView;
        public ListHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            singleItemTextView = itemView.findViewById(R.id.singleItemTextView);
        }
        public void bind(String userName){
            this.userName = userName;
            singleItemTextView.setText(userName);
        }
    }

    public class ListAdapter extends RecyclerView.Adapter<ListHolder>{
        private ArrayList<String> users;
        public ListAdapter(ArrayList<String> users) {
            this.users = users;
        }

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new ListHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
            String userName = users.get(position);
            holder.bind(userName);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}