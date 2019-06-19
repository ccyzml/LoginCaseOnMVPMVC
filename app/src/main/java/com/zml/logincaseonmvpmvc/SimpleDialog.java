package com.zml.logincaseonmvpmvc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class SimpleDialog {
    public static void showSimpleDialog(Context context,String title) {
        Dialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setNegativeButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog = builder.create();
        dialog.setTitle(title);
        dialog.show();
    }
}
