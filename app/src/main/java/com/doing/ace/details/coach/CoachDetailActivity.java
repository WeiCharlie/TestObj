package com.doing.ace.details.coach;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

public class CoachDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView classIv, classLineIv, coachIv, coachLineIv, gymIv, gymLineIv;
    private TextView classTv, coachTv, gymTv;
    private LinearLayout classLlt, coachLlt, gymLlt;
    private ListView listView;
    private RelativeLayout coachRlt, gymRlt;
    private CoachClassAdapter coachClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_detail);

        initViews();
    }

    private void initViews() {

        classIv = findViewById(R.id.coach_detail_class_iv);
        classLineIv = findViewById(R.id.coach_detail_class_line_iv);
        coachIv = findViewById(R.id.coach_detail_coach_iv);
        coachLineIv = findViewById(R.id.coach_detail_coach_line_iv);
        gymIv = findViewById(R.id.coach_detail_gym_iv);
        gymLineIv = findViewById(R.id.coach_detail_gym_line_iv);
        classTv = findViewById(R.id.coach_detail_class_tv);
        coachTv = findViewById(R.id.coach_detail_coach_tv);
        gymTv = findViewById(R.id.coach_detail_gym_tv);

        classLlt = findViewById(R.id.class_llt);
        coachLlt = findViewById(R.id.coach_llt);
        gymLlt = findViewById(R.id.gym_llt);

        coachRlt = findViewById(R.id.coach_detail_coach_rlt);
        gymRlt = findViewById(R.id.coach_detail_gym_rlt);

        listView = findViewById(R.id.coach_detail_lv);

        listView.setAdapter(new CoachClassAdapter(this, null));

        classLlt.setOnClickListener(this);
        coachLlt.setOnClickListener(this);
        gymLlt.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.class_llt:
                classTv.setTextColor(getResources().getColor(R.color.Black));
                coachTv.setTextColor(getResources().getColor(R.color.un_check_color));
                gymTv.setTextColor(getResources().getColor(R.color.un_check_color));

                classLineIv.setVisibility(View.VISIBLE);
                coachLineIv.setVisibility(View.INVISIBLE);
                gymLineIv.setVisibility(View.INVISIBLE);

                classIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_class_check));
                coachIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_coach_uncheck));
                gymIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_gym_uncheck));

                listView.setVisibility(View.VISIBLE);
                coachRlt.setVisibility(View.GONE);
                gymRlt.setVisibility(View.GONE);

                break;
            case R.id.coach_llt:
                classTv.setTextColor(getResources().getColor(R.color.un_check_color));
                coachTv.setTextColor(getResources().getColor(R.color.Black));
                gymTv.setTextColor(getResources().getColor(R.color.un_check_color));

                classLineIv.setVisibility(View.INVISIBLE);
                coachLineIv.setVisibility(View.VISIBLE);
                gymLineIv.setVisibility(View.INVISIBLE);

                classIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_class_uncheck));
                coachIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_coach_check));
                gymIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_gym_uncheck));

                listView.setVisibility(View.GONE);
                coachRlt.setVisibility(View.VISIBLE);
                gymRlt.setVisibility(View.GONE);
                break;
            case R.id.gym_llt:
                classTv.setTextColor(getResources().getColor(R.color.un_check_color));
                coachTv.setTextColor(getResources().getColor(R.color.un_check_color));
                gymTv.setTextColor(getResources().getColor(R.color.Black));

                classLineIv.setVisibility(View.INVISIBLE);
                coachLineIv.setVisibility(View.INVISIBLE);
                gymLineIv.setVisibility(View.VISIBLE);

                classIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_class_uncheck));
                coachIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_coach_uncheck));
                gymIv.setImageDrawable(getResources().getDrawable(R.drawable.coach_detail_gym_check));

                listView.setVisibility(View.GONE);
                coachRlt.setVisibility(View.GONE);
                gymRlt.setVisibility(View.VISIBLE);
                break;
        }
    }

    // TODO: 2018/8/13 页面下健身圈列表还未完善

    public void backCoachDetail(View view) {
    }
}
