package com.ccswe.nvisofalsepositive;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    private String _message;
    private String _negativeButtonText;
    private String _neutralButtonText;
    private String _positiveButtonText;
    private String _title;

    public static AlertDialogFragment newInstance(int dialogId, String message, String positiveButtonText) {
        return newInstance(dialogId, message, null, positiveButtonText, null, null, false);
    }

    public static AlertDialogFragment newInstance(int dialogId, String message, String positiveButtonText, boolean isDestructive) {
        return newInstance(dialogId, message, null, positiveButtonText, null, null, isDestructive);
    }

    public static AlertDialogFragment newInstance(int dialogId, String message, String positiveButtonText, String negativeButtonText) {
        return newInstance(dialogId, message, null, positiveButtonText, null, negativeButtonText, false);
    }

    public static AlertDialogFragment newInstance(int dialogId, String message, String positiveButtonText, String negativeButtonText, boolean isDestructive) {
        return newInstance(dialogId, message, null, positiveButtonText, null, negativeButtonText, isDestructive);
    }

    public static AlertDialogFragment newInstance(int dialogId, String message, String positiveButtonText, String neutralButtonText, String negativeButtonText) {
        return newInstance(dialogId, message, null, positiveButtonText, neutralButtonText, negativeButtonText, false);
    }

    public static AlertDialogFragment newInstance(int dialogId, String message, String title, String positiveButtonText, String neutralButtonText, String negativeButtonText, boolean isDestructive) {
        final AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        final Bundle arguments = new Bundle();

        arguments.putInt(Extra.DIALOG_ID, dialogId);
        arguments.putBoolean(Extra.IS_DESTRUCTIVE, isDestructive);
        arguments.putString(Extra.MESSAGE, message);
        arguments.putString(Extra.NEGATIVE_BUTTON_TEXT, negativeButtonText);
        arguments.putString(Extra.NEUTRAL_BUTTON_TEXT, neutralButtonText);
        arguments.putString(Extra.POSITIVE_BUTTON_TEXT, positiveButtonText);
        arguments.putString(Extra.TITLE, title);

        alertDialogFragment.setArguments(arguments);

        return alertDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadArguments(getArguments());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(_message);
        builder.setTitle(_title);

        if (!StringUtils.isNullOrWhiteSpace(_negativeButtonText)) {
            builder.setNegativeButton(_negativeButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }

        if (!StringUtils.isNullOrWhiteSpace(_neutralButtonText)) {
            builder.setNeutralButton(_neutralButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }

        if (!StringUtils.isNullOrWhiteSpace(_positiveButtonText)) {
            builder.setPositiveButton(_positiveButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().finish();
                }
            });
        }

        return builder.create();
    }

    protected void loadArguments(Bundle arguments) {
        _message = BundleUtils.getString(arguments, Extra.MESSAGE);
        _negativeButtonText = BundleUtils.getString(arguments, Extra.NEGATIVE_BUTTON_TEXT);
        _neutralButtonText = BundleUtils.getString(arguments, Extra.NEUTRAL_BUTTON_TEXT);
        _positiveButtonText = BundleUtils.getString(arguments, Extra.POSITIVE_BUTTON_TEXT);
        _title = BundleUtils.getString(arguments, Extra.TITLE);
    }
}

