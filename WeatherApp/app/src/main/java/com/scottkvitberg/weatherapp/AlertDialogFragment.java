package com.scottkvitberg.weatherapp;
// Created on 09/11/2016 by kitsco12.


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInsanceState){
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                // TODO: Set messages as String resources.
                .setTitle("Something went wrong, sorry!")
                .setMessage("There was an error. Please try again")
                .setPositiveButton("Ok", null);

        AlertDialog dialog = builder.create();
        return dialog;
    }

}
