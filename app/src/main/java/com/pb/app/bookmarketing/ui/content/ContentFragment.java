package com.pb.app.bookmarketing.ui.content;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pb.app.bookmarketing.R;
import com.pb.app.bookmarketing.ui.adapters.AdapterContent;

import java.util.ArrayList;

public class ContentFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private ContentViewModel contentViewModel;
    private AdapterContent adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contentViewModel = new ViewModelProvider(this).get(ContentViewModel.class);
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_content, container, false);
        recyclerView = root.findViewById(R.id.content_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> items = new ArrayList<>();
        for(int i = 0; i < getResources().getStringArray(R.array.content_items).length; i++){
            items.add(getResources().getStringArray(R.array.content_items)[i]);
        }
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment(R.layout.frame_1));
        fragments.add(new Fragment(R.layout.frame_2));
        fragments.add(new Fragment(R.layout.frame_3));
        fragments.add(new Fragment(R.layout.frame_4));
        fragments.add(new Fragment(R.layout.frame_5));
        fragments.add(new Fragment(R.layout.frame_6));
        adapter = new AdapterContent(items, getFragmentManager(), fragments);
        recyclerView.setAdapter(adapter);
        return root;
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