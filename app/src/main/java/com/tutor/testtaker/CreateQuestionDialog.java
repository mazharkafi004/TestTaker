package com.tutor.testtaker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateQuestionDialog extends DialogFragment {
    public static final String TAG= "CreateQuestionDialog";

    private EditText question;
    private EditText opt1;
    private EditText opt2;
    private EditText opt3;
    private EditText opt4;
    private String ans;
    private Button btnCreate;
    private RadioGroup option;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_create_question,null);
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity())
                .setTitle("Create Question")
                .setView(view);
        initviews(view);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioButtonId = option.getCheckedRadioButtonId();
                if (checkedRadioButtonId == opt1.getId()) {
                    ans = opt1.getText().toString();
                } else if (checkedRadioButtonId == opt2.getId()) {
                    ans = opt2.getText().toString();
                } else if (checkedRadioButtonId == opt3.getId()) {
                    ans = opt3.getText().toString();
                } else if (checkedRadioButtonId == opt4.getId()) {
                    ans = opt4.getText().toString();
                } else {
                    Toast.makeText(getContext(), "Please Select The Correct Answer!", Toast.LENGTH_SHORT).show();
                    return;
                }

                postQuestion(question.getText().toString(),
                        opt1.getText().toString(),
                        opt2.getText().toString(),
                        opt3.getText().toString(),
                        opt4.getText().toString(),
                        ans);
            }
        });

        return builder.create();
    }

    private void initviews(View view){
        question= view.findViewById(R.id.txtmakeques);
        opt1= view.findViewById(R.id.opt1);
        opt2= view.findViewById(R.id.opt2);
        opt3= view.findViewById(R.id.opt3);
        opt4= view.findViewById(R.id.opt4);
        option= view.findViewById(R.id.option);
    }

    public void postQuestion(String question,String opt1,String opt2,String opt3,String opt4,String ans){
        String url= "https://presslu1.pythonanywhere.com/api/question/";
        Map<String,String> data= new HashMap<>();

        data.put("question",question);
        data.put("opt1",opt1);
        data.put("opt2",opt2);
        data.put("opt3",opt3);
        data.put("opt4",opt4);
        data.put("ans",ans);

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, new JSONObject(data), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: CreateQuestion started");
                Toast.makeText(getContext(), "Question created", Toast.LENGTH_SHORT).show();
                dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: CreateQuestion started");
                Toast.makeText(getContext(), "Question creating failed", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
        requestQueue.start();

    }
}