package com.freud.mrzz.frags;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.freud.mrzz.R;
import com.freud.mrzz.adapter.TopicAdapter;
import com.freud.mrzz.entity.Topic;
import com.freud.mrzz.entity.TopicLists;
import com.freud.mrzz.net.NetCore;
import com.freud.mrzz.utils.T;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class communityFrag_socialFrag extends Fragment {
    public static final String TITLE = "title";
    private String mTitle = "Defaut Value";

    private PullToRefreshListView mPulltoRefreshListView;

    private TopicAdapter mAdapter;
    private List<Topic> topicList = new ArrayList<Topic>();

    private int count = 10;

    private RequestQueue mQuene;

    private Thread mThread;


    private static final int MSG_SUCCESS = 0;//获取图片成功的标识
    private static final int MSG_FAILURE = 1;//获取图片失败的标识

    private static final String mUrl = NetCore.URL_HEAD+"forum/get_topic_list.php";

    Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {

            switch (msg.what) {

                case MSG_SUCCESS:
                    String jsonData = (String) msg.obj;
                    String jsonData2 = jsonData.replace("\\", "");
                    System.out.print(jsonData2);
                    TopicLists topicLists = null;
                    if (jsonData2 != null) {
                        Gson gson = new Gson();
                        topicLists = gson.fromJson(jsonData2, TopicLists.class);

                    }
                    for (int i = 0; i < topicLists.topic_list.size(); i++) {
                        topicList.add(topicLists.topic_list.get(i));
                    }
                    mAdapter.notifyDataSetChanged();
                    mPulltoRefreshListView.onRefreshComplete();
                    break;
                case MSG_FAILURE:
                    T.showShort(getActivity(), "fail to download");
                    break;
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuene = Volley.newRequestQueue(getActivity());
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_community_socialfrag, container, false);

        initDatas();
        initView(view);

        return view;

    }

    private void initDatas() {
        // 初始化数据和数据源


        topicList = new ArrayList<Topic>();
/*
        Topic topic1 = new Topic("比尔盖茨", "Microsoft", "....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);
        Topic topic2 = new Topic("乔布斯", "Apple", "....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);
        Topic topic3 = new Topic("马云", "阿里巴巴", "....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);
        Topic topic4 = new Topic("李彦宏", "百度", ".....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);
        Topic topic5 = new Topic("马化腾", "腾讯", "....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);
        Topic topic6 = new Topic("刘强东", "京东", "....", "16:38", R.drawable.tx_test, R.drawable.sheep_pulltorefresh, 233, 3);

        topicList.add(topic1);
        topicList.add(topic2);
        topicList.add(topic3);
        topicList.add(topic4);
        topicList.add(topic5);
        topicList.add(topic6);*/
    }

    private void initView(View view) {


        mPulltoRefreshListView = (PullToRefreshListView) view.findViewById(R.id.id_pull_refresh_list_commufrag);
        mPulltoRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        final ILoadingLayout startLables = mPulltoRefreshListView.getLoadingLayoutProxy(true, false);
        startLables.setPullLabel("下拉刷新");
        startLables.setRefreshingLabel("正在努力刷新...");
        startLables.setReleaseLabel("松手刷新");

        ILoadingLayout endLables = mPulltoRefreshListView.getLoadingLayoutProxy(false, true);
        endLables.setPullLabel("上拉加载更多");
        endLables.setRefreshingLabel("正在加载...");
        endLables.setReleaseLabel("松手刷新");

        mAdapter = new TopicAdapter(getActivity(), R.layout.topic_item_image, topicList);
        mPulltoRefreshListView.setAdapter(mAdapter);
        mPulltoRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Topic topic = topicList.get(position - 1);
                T.showShort(getActivity(), topic.getTopic_name());
                System.out.println(position);
                Intent i = new Intent(getActivity(), com.freud.mrzz.atys.TopicActivity.class);
                Bundle b = new Bundle();
                b.putString("name", topic.getTopic_name());
                b.putString("user_name", topic.getUser_name());
                i.putExtras(b);
                startActivity(i);
            }
        });

        mPulltoRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                T.showShort(getActivity().getApplicationContext(), "pullDown");

                String label = DateUtils.formatDateTime(
                        getActivity().getApplicationContext(),
                        System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME
                                | DateUtils.FORMAT_SHOW_DATE
                                | DateUtils.FORMAT_ABBREV_ALL);
                // 显示最后更新的时间
                refreshView.getLoadingLayoutProxy()
                        .setLastUpdatedLabel(label);
                startLoad();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                T.showShort(getActivity().getApplicationContext(), "pullUp");
                String label = "上次刷新时间：" + DateUtils.formatDateTime(
                        getActivity().getApplicationContext(),
                        System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME
                                | DateUtils.FORMAT_SHOW_DATE
                                | DateUtils.FORMAT_ABBREV_ALL);
                // 显示最后更新的时间
                refreshView.getLoadingLayoutProxy()
                        .setLastUpdatedLabel(label);
                startLoad();
            }
        });
    }

    public static communityFrag_socialFrag newInstance(String title) {
        communityFrag_socialFrag tabFragment = new communityFrag_socialFrag();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    private void startLoad(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(mUrl, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(final JSONObject response) {
                        mHandler.obtainMessage(MSG_SUCCESS, response.toString()).sendToTarget();
                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", error.getMessage(), error);
            }
        }) {

            @Override
            protected Response<JSONObject> parseNetworkResponse(
                    NetworkResponse response) {

                try {
                    JSONObject jsonObject = new JSONObject(
                            new String(response.data, "UTF-8"));
                    return Response.success(jsonObject, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (Exception je) {
                    return Response.error(new ParseError(je));
                }
            }

        };
        mQuene.add(jsonObjectRequest);
    }

}
