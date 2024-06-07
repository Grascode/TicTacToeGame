package com.mirea.kt.ribo.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class WinnerDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.activity_winnerdialog, null);
        builder.setView(view);
        TextView tvTitle = view.findViewById(R.id.Winner);
        String winner = getArguments().getString("winner");
        Log.i("valueReceived", "value received winner");
        builder.setMessage("Победитель: ");
        tvTitle.setText(winner);
        return builder.create();
    }
}
