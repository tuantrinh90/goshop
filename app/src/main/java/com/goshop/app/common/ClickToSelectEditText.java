package com.goshop.app.common;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import java.util.List;



public class ClickToSelectEditText<T> extends AppCompatEditText {

    CharSequence mHint;

    List<T> mItems;

    String[] mListableItems;

    OnItemSelectedListener<T> onItemSelectedListener;

    public ClickToSelectEditText(Context context) {
        super(context);
        mHint = getHint();
    }

    public ClickToSelectEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHint = getHint();
    }

    public ClickToSelectEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHint = getHint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setFocusable(false);
        setClickable(true);
    }

    public void setItems(List<T> items) {
        this.mItems = items;
        this.mListableItems = new String[items.size()];
        int i = 0;
        for (T item : mItems) {
            mListableItems[i++] = (String) item;
        }
        configureOnClickListener();
    }

    private void configureOnClickListener() {
        setOnClickListener(edit -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(edit.getContext());
                builder.setTitle(mHint);
                builder.setItems(mListableItems,
                    (DialogInterface dialogInterface, int selectedIndex) -> {
                        setText(mListableItems[selectedIndex]);
                        if (onItemSelectedListener != null) {
                            onItemSelectedListener
                                .onItemSelectedListener(mItems.get(selectedIndex), selectedIndex);
                        }
                    });
                builder.create().show();
            }
        );
    }

    public void setOnItemSelectedListener(OnItemSelectedListener<T> onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public interface OnItemSelectedListener<T> {
        void onItemSelectedListener(T item, int selectedIndex);
    }
}
