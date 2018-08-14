package com.doing.ace.main.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doing.ace.R;
import com.doing.ace.base.BaseFragment;
import com.doing.ace.main.mine.AboutUsActivity;
import com.doing.ace.main.mine.CardCouponActivity;
import com.doing.ace.main.mine.ConnectActivity;
import com.doing.ace.main.mine.EditActivity;
import com.doing.ace.main.mine.MyCardActivity;
import com.doing.ace.main.mine.MyClassActivity;
import com.doing.ace.main.mine.MyOrderActivity;
import com.doing.ace.main.mine.UserProtocolActivity;

/**
 * 我的页面
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout aboutRlt, connectRlt, userPRlt, cardCouponRlt;
    private TextView cardTv, classTc;
    private TextView moreOrderTv, noUseTv, useTv, evaluationTv, asTv;
    private ImageView avatarIv;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MineFragment.
     */
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        aboutRlt = view.findViewById(R.id.mine_about_rlt);
        userPRlt = view.findViewById(R.id.user_pro_rlt);
        connectRlt = view.findViewById(R.id.connect_us_rlt);
        cardCouponRlt = view.findViewById(R.id.card_coupon_rlt);

        cardTv = view.findViewById(R.id.mine_my_card_tv);
        classTc = view.findViewById(R.id.mine_my_class_tv);
        avatarIv = view.findViewById(R.id.mine_avatar_iv);

        asTv = view.findViewById(R.id.mine_after_sale_tv);
        noUseTv = view.findViewById(R.id.mine_nouse_order_tv);
        useTv = view.findViewById(R.id.mine_use_order_tv);
        evaluationTv = view.findViewById(R.id.mine_no_evaluation_tv);
        moreOrderTv = view.findViewById(R.id.mine_more_order_tv);

        aboutRlt.setOnClickListener(this);
        userPRlt.setOnClickListener(this);
        cardTv.setOnClickListener(this);
        classTc.setOnClickListener(this);
        avatarIv.setOnClickListener(this);
        connectRlt.setOnClickListener(this);
        asTv.setOnClickListener(this);
        noUseTv.setOnClickListener(this);
        useTv.setOnClickListener(this);
        evaluationTv.setOnClickListener(this);
        moreOrderTv.setOnClickListener(this);
        cardCouponRlt.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.mine_about_rlt:
                Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.user_pro_rlt:
                Intent intentU = new Intent(getActivity(), UserProtocolActivity.class);
                startActivity(intentU);
                break;
            case R.id.connect_us_rlt:
                Intent intentC = new Intent(getActivity(), ConnectActivity.class);
                startActivity(intentC);
                break;
            case R.id.mine_my_card_tv:
                Intent intentCard = new Intent(getActivity(), MyCardActivity.class);
                startActivity(intentCard);
                break;
            case R.id.mine_my_class_tv:
                Intent intentClass = new Intent(getActivity(), MyClassActivity.class);
                startActivity(intentClass);
                break;
            case R.id.mine_avatar_iv:
                Intent intentEdit = new Intent(getActivity(), EditActivity.class);
                startActivity(intentEdit);
                break;
            case R.id.mine_use_order_tv:
                Intent intentUse = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentUse);
                break;
            case R.id.mine_nouse_order_tv:
                Intent intentNo = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentNo);
                break;
            case R.id.mine_no_evaluation_tv:
                Intent intentEva = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentEva);
                break;
            case R.id.mine_more_order_tv:
                Intent intentO = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentO);
                break;
            case R.id.mine_after_sale_tv:
                Intent intentA = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intentA);
                break;
            case R.id.card_coupon_rlt:
                Intent intentCoupon = new Intent(getActivity(), CardCouponActivity.class);
                startActivity(intentCoupon);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
