package com.secondpartial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    RecyclerView rcv_users;
    List<User> userList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcv_users = view.findViewById(R.id.rcv_users);


        userList.add(new User("Risotto Groupon", "Dead", "Human", "https://rickandmortyapi.com/api/character/avatar/72.jpeg"));
        userList.add(new User("Shleemypants", "Alive", "Alien", "https://rickandmortyapi.com/api/character/avatar/120.jpeg"));
        userList.add(new User("Pencilvester", "Alive", "Parasite", "https://rickandmortyapi.com/api/character/avatar/190.jpeg"));
        userList.add(new User("Trandor", "Dead", "Human", "https://rickandmortyapi.com/api/character/avatar/241.jpeg"));


        rcv_users.setLayoutManager(new LinearLayoutManager((getContext())));
        rcv_users.setAdapter(new UserAdapter( userList ));


        // Inflate the layout for this fragment
        return view;
    }
}