package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.PagerSnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.databinding.FragmentFeedBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Feed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Feed extends Fragment {
    FragmentFeedBinding binding;

    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> listt = new ArrayList<>();
    ArrayList<Integer> listI = new ArrayList<>();
    ArrayList<String> linklist = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Feed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Feed.
     */
    // TODO: Rename and change types and number of parameters
    public static Feed newInstance(String param1, String param2) {
        Feed fragment = new Feed();
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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_feed,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String news1 = "Avinash Sable on Sunday made history, becoming the first Indian man to clinch a gold medal in the 3000m steeplechase event at the Asian Games in Hangzhou. The 29-year-old, who holds the national record, secured India's first gold medal in athletics at the ongoing Games, finishing the race in a record time of 8 minutes and 19.50 seconds. Sable not only claimed the gold but also rewrote the previous Asian Games record of 8 minutes and 22.79 seconds made by Iran's Hossein Keyhani in the 2018 Jakarta Games.";
        String news2 = "A U.S.-led coalition launched an invasion of Afghanistan in October of 2001, about a month after the 9/11 attacks, sparking what many would go on to call the \"forever war.\" Over the next two decades, photojournalists from AP and Getty Images, often embedded with U.S. troops, documented the cycles of America’s longest war. Throughout that visual coverage was a pattern: vendors in Afghanistan selling colorful balloons, standing in stark contrast to the dusty landscapes and brutal realities around them. These images – of Afghans holding on in the face of war – offer a glimpse into daily life amid years of occupation.";

        list.add(news1);
        list.add(news2);
        list.add(news2);

        String newst1 = "first Indian man to clinch a gold medal";
        String newst2 = "Cycles of a ‘Forever War’";

        listt.add(newst1);
        listt.add(newst2);
        listt.add(newst2);

        listI.add(R.drawable.news11);
        listI.add(R.drawable.new2);
        listI.add(R.drawable.news);

        String link = "https://timesofindia.indiatimes.com/sports/asian-games-2023/live-updates-of-asian-games-2023-day-8-golf-boxing-athletics-equestrian-shooting-archery-boxing-hockey/liveblog/104076967.cms";
        linklist.add(link);

        String link1 = "https://www.usnews.com/photos/2021/09/10/from-9-11-until-today-us-military-in-afghanistan";
        linklist.add(link1);

        String link2 = "https://www.usnews.com/photos/2021/09/10/from-9-11-until-today-us-military-in-afghanistan";
        linklist.add(link2);



        AdapterClass adapterClass = new AdapterClass(listI,list,listt,linklist);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.rcv);
        binding.rcv.setAdapter(adapterClass);
    }
}