package com.example.listtpp;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contactList;
    private OnItemClickListener listener;

    public ContactAdapter(List<Contact> contactList, OnItemClickListener listener) {
        this.contactList = contactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom_listview, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.bind(contact, listener);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewPhoneNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPhoneNumber = itemView.findViewById(R.id.text_view_phone);
        }

        public void bind(final Contact contact, final OnItemClickListener listener) {
            textViewName.setText(contact.getName());
            textViewPhoneNumber.setText(contact.getPhoneNumber());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(contact);
                }
            });
        }
    }
}

