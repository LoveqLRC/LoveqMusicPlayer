package com.loveqrc.commonlib.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loveqrc.commonlib.R;

/**
 * Created by Rc on 2020/3/31
 */
public class SimpleRecyclerView extends RecyclerView {


    public SimpleRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public SimpleRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public SimpleRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(layoutManager);
        addItemDecoration(new SimpleListDividerDecorator(
                ContextCompat.getDrawable(
                        getContext(),
                        R.drawable.list_divider_h
                ), true
        ));
    }

}
