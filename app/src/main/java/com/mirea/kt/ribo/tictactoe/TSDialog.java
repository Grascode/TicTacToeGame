package com.mirea.kt.ribo.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TSDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.activity_tsdialog, null);
        builder.setView(view);
        TextView tvTitle = view.findViewById(R.id.studentTitle);
        TextView tvTask = view.findViewById(R.id.studentTask);
        String title = getArguments().getString("title");
        Log.i("valueReceived", "value received title");
        String task = getArguments().getString("task");
        Log.i("valueReceived", "value received task");
        tvTitle.setText(title);
        Log.i("setText", "tvTitle updated");
        tvTask.setText(task);
        Log.i("setText", "tvTask updated");
        builder.setMessage("Данные по курсовой: ")
                .setPositiveButton("Дальше", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getContext(), EnterLogin.class));
                        Log.i("startNewActivity", "go to DisplayRecordsActivity");
                    }
                });
        return builder.create();
    }
}
