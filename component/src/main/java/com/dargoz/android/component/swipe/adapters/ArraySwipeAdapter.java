package com.dargoz.android.component.swipe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.dargoz.android.component.swipe.SwipeLayout;
import com.dargoz.android.component.swipe.util.Attributes;
import com.dargoz.android.component.swipe.implments.SwipeItemMangerImpl;
import com.dargoz.android.component.swipe.interfaces.SwipeAdapterInterface;
import com.dargoz.android.component.swipe.interfaces.SwipeItemMangerInterface;

import java.util.List;

public abstract class ArraySwipeAdapter<T> extends ArrayAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {

    private SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);
    {}
    public ArraySwipeAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ArraySwipeAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public void notifyDatasetChanged(int position) {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        mItemManger.bindView(v, position);
        return v;
    }

    @Override
    public void openItem(int position) {
        mItemManger.openItem(position);
    }

    @Override
    public void closeItem(int position) {
        mItemManger.closeItem(position);
    }

    @Override
    public void closeAllExcept(SwipeLayout layout) {
        mItemManger.closeAllExcept(layout);
    }

    @Override
    public void closeAllItems() {
        mItemManger.closeAllItems();
    }

    @Override
    public List<Integer> getOpenItems() {
        return mItemManger.getOpenItems();
    }

    @Override
    public List<SwipeLayout> getOpenLayouts() {
        return mItemManger.getOpenLayouts();
    }

    @Override
    public void removeShownLayouts(SwipeLayout layout) {
        mItemManger.removeShownLayouts(layout);
    }

    @Override
    public boolean isOpen(int position) {
        return mItemManger.isOpen(position);
    }

    @Override
    public Attributes.Mode getMode() {
        return mItemManger.getMode();
    }

    @Override
    public void setMode(Attributes.Mode mode) {
        mItemManger.setMode(mode);
    }
}
