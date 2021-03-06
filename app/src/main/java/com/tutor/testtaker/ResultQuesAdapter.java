package com.tutor.testtaker;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ResultQuesAdapter extends QuesAdapter {
    private static final String TAG = "ResultQuesAdapter";

    public ResultQuesAdapter(ArrayList<Ques> queslist, ArrayList<String> selectedAnslist, Context context) {
        super(queslist, selectedAnslist, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        initviews(holder,position);

        //Log.d(TAG, "onBindViewHolder: "+queslist.get(position).getOpt1()+" "+ selectedAnslist.get(position));
        if(queslist.get(position).getOpt1().equals(selectedAnslist.get(position))){
            holder.rdobtnAns0.setTextColor(context.getResources().getColor(R.color.red));
            holder.rdobtnAns0.setEnabled(true);
            holder.rdobtnAns0.setChecked(true);
            Log.d(TAG, "onBindViewHolder: "+queslist.get(position).getOpt1()+" "+ selectedAnslist.get(position));
        }
        if(queslist.get(position).getOpt1().equals(queslist.get(position).getAns())){
            holder.rdobtnAns0.setTextColor(context.getResources().getColor(R.color.green));
        }
        if(queslist.get(position).getOpt2().equals(selectedAnslist.get(position))){
            holder.rdobtnAns1.setTextColor(context.getResources().getColor(R.color.red));
            holder.rdobtnAns1.setEnabled(true);
            holder.rdobtnAns1.setChecked(true);
        }
        if(queslist.get(position).getOpt2().equals(queslist.get(position).getAns())){
            holder.rdobtnAns1.setTextColor(context.getResources().getColor(R.color.light_green));
        }
        if(queslist.get(position).getOpt3().equals(selectedAnslist.get(position))){
            holder.rdobtnAns2.setTextColor(context.getResources().getColor(R.color.red));
            holder.rdobtnAns2.setEnabled(true);
            holder.rdobtnAns2.setChecked(true);
        }
        if(queslist.get(position).getOpt3().equals(queslist.get(position).getAns())){
            holder.rdobtnAns2.setTextColor(context.getResources().getColor(R.color.light_green));
        }
        if(queslist.get(position).getOpt4().equals(selectedAnslist.get(position))){
            holder.rdobtnAns3.setTextColor(context.getResources().getColor(R.color.red));
            holder.rdobtnAns3.setEnabled(true);
            holder.rdobtnAns3.setChecked(true);
        }
        if(queslist.get(position).getOpt4().equals(queslist.get(position).getAns())){
            holder.rdobtnAns3.setTextColor(context.getResources().getColor(R.color.light_green));
        }

    }

    @Override
    public void initviews(ViewHolder holder, int position) {
        super.initviews(holder, position);

        holder.rdobtnAns0.setEnabled(false);
        holder.rdobtnAns1.setEnabled(false);
        holder.rdobtnAns2.setEnabled(false);
        holder.rdobtnAns3.setEnabled(false);

    }
}
