package com.example.gjtk12.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gjtk12.MainActivity3;
import com.example.gjtk12.R;
import com.example.gjtk12.bean.CLWZRight;

import java.util.List;

/**
 * @auther 公杰
 * @description:
 * @data :2021/11/22 0022 下午 04:20
 */
public class RightAdapter extends ArrayAdapter<CLWZRight> {
    private LinearLayout lineWzxq;
    private TextView dateTv;
    private TextView roadRight;
    private TextView msgTv;
    private TextView scoreTv;
    private TextView moneyTv;

    public RightAdapter(@NonNull Context context, int resource, @NonNull List<CLWZRight> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CLWZRight right = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.right_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.dateTv.setText(right.getTime());
        holder.roadRight.setText(right.getRoad());
        holder.msgTv.setText(right.getMessage());
        holder.scoreTv.setText("扣分：" + right.getScore() + "\r分");
        holder.moneyTv.setText("罚款：" + right.getMoney() + "\r元");
        holder.lineWzxq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), MainActivity3.class);
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }



    static class ViewHolder {
        TextView dateTv;
        TextView roadRight;
        TextView msgTv;
        TextView scoreTv;
        TextView moneyTv;
        LinearLayout lineWzxq;

        public ViewHolder(View view) {
            lineWzxq =view.findViewById(R.id.line_wzxq);
            dateTv = view.findViewById(R.id.date_tv);
            roadRight = view.findViewById(R.id.road_right);
            msgTv = view.findViewById(R.id.msg_tv);
            scoreTv = view.findViewById(R.id.score_tv);
            moneyTv = view.findViewById(R.id.money_tv);
        }
    }
}
