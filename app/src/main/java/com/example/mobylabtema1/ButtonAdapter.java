package com.example.mobylabtema1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.mobylabtema1.Utils.displayToast;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private final List<String> mButtonList;
    private LayoutInflater mInflater;
    private Context mContext;

    public ButtonAdapter(Context context, List<String> buttonList) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mButtonList = buttonList;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.button_item, parent, false);
        return new ButtonViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        String mCurrent = mButtonList.get(position);
        holder.buttonView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mButtonList.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final Button buttonView;
        final ButtonAdapter mAdapter;

        public ButtonViewHolder(@NonNull View itemView, ButtonAdapter adapter) {
            super(itemView);

            buttonView = itemView.findViewById(R.id.button);
            mAdapter = adapter;

            buttonView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            displayToast(mContext, "Click " + (mPosition + 1) + " !");
        }
    }
}
