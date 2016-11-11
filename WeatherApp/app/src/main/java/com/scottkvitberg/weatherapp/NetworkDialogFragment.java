package com.scottkvitberg.weatherapp;
// Created on 11/11/2016 by kitsco12.


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

public class NetworkDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInsanceState){

        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(R.string.network_unavaialable_title)
                .setMessage(R.string.network_unavailable_message)
                .setPositiveButton(R.string.network_unavailable_confirmation, null);

        AlertDialog dialog = builder.create();
        return dialog;
    }
}
