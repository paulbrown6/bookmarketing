package com.pb.app.bookmarketing.ui.content;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pb.app.bookmarketing.MainActivity;
import com.pb.app.bookmarketing.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentFrame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFrame extends Fragment {


    private OnFragmentInteractionListener mListener;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private static int contentLayoutId;

    public ContentFrame(@LayoutRes int contentLayoutId) {
        this.contentLayoutId = contentLayoutId;
    }
    public static ContentFrame newInstance(String param1, String param2) {
        ContentFrame fragment = new ContentFrame(contentLayoutId);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(contentLayoutId, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}