package com.example.toshiba_l15w.pwebchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TOSHIBA-L15W on 1/8/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UsersHolder> {
    List<User> users;
    //private LayoutInflater inflater;
    private Context context;

    SharedPreferences mylocaldata;

    public UserListAdapter(Context context, List<User> users){
        this.context=context;
      //  inflater=LayoutInflater.from(context);
        this.users=users;
        mylocaldata=context.getSharedPreferences("mylocaldata", Context.MODE_PRIVATE);
    }
    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType){
      View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
      UsersHolder holder=new UsersHolder(view);
      return holder;
    }
    @Override
    public void onBindViewHolder(UsersHolder holder, int position){
        User current = users.get(position);
        holder.setData(current, position);
        holder.setListener();
    }
    
    @Override
    public int getItemCount(){return users.size();}


    public class UsersHolder extends RecyclerView.ViewHolder {
     //   View itemView;
        TextView tvnama, tvemail, tvtelepon;
        CardView thisuser;
    
        int position;
        User current;
        
        public UsersHolder(View itemView){
            super(itemView);
       //     this.itemView=itemView;
            
            thisuser=(CardView) itemView.findViewById(R.id.cvItemUser);
            tvnama=(TextView) itemView.findViewById(R.id.tvNama);
            tvemail=(TextView) itemView.findViewById(R.id.tvEmail);
            tvtelepon=(TextView)itemView.findViewById(R.id.tvNomor);
        }
        public void setData(User current, int position){
            tvnama.setText(current.getNama());
            tvemail.setText(current.getEmail());
            tvtelepon.setText(current.getTelepon());
            String uid = mylocaldata.getString("uid", "");
            this.position=position;
            this.current=current;
        }

        public void setListener() {
            thisuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, ProfilActivity.class);
                    intent.putExtra("user", current);
                    context.startActivity(intent);
                }
            });
        }
    }

    
    
    
}
