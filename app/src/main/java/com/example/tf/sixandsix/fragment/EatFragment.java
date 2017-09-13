package com.example.tf.sixandsix.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tf.sixandsix.R;
import com.example.tf.sixandsix.adapter.EatFragmentAdapter;
import com.example.tf.sixandsix.adapter.IAdapterOnClick;
import com.example.tf.sixandsix.bean.EatModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/8.
 */

public class EatFragment extends Fragment {
    private RecyclerView rv;
    private EatFragmentAdapter adapter;
    private List<EatModel> eatModels;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_eat, null, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.eat_rv);

        eatModels = new ArrayList<>();

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        eatModels.add(new EatModel("http://img.taopic.com/uploads/allimg/120410/2302-12041020395698.jpg", "1", "这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。这个米饭饼甜的、咸的，都好吃，依据个人喜好。做咸的可加入食盐和胡椒粉，再搭配点蔬菜，表面煎得老一点，吃起来口感酥脆。煎得嫩一点，吃起来口感软糯。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://img.taopic.com/uploads/allimg/120505/154508-12050516163610.jpg", "2", "碗中的清水不要加多了，多了的话需要加入的面粉就多，那样煎出来的饼就不够香。如果立即操作，也可直接把土豆刨成丝，然后加入鸡蛋。摊饼之前，锅不要烧得太热，太热了，饼糊一下锅就熟，便不会流动，也就较难摊平。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://pic16.photophoto.cn/20100801/0013025619054425_b.jpg", "3", "在蛋糊下锅40秒左右的时候，底部已经凝固了，此时便可以开始铺馅料，建议把火关了，以免动作不熟练，还没铺好，蛋饼已完全熟了。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://img07.tooopen.com/images/20170413/tooopen_sy_205727331887.jpg", "4", "蔬菜不是固定搭配，也可换成自己喜欢的，但要容易熟的为好。2：面粉不要加太多，一点点就可以。 3：也可以不用模具，直接煎。如果用的话，模具内壁记得抹上一层油，这样才好脱离蛋饼。依然全程小火。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://www.taopic.com/uploads/allimg/120115/6599-1201151Q53066.jpg", "5", "辣椒酱没有固定的量，依据自己喜欢的口味加减。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://img3.imgtn.bdimg.com/it/u=2104524188,188359717&fm=27&gp=0.jpg", "5", "西葫芦洗净刨成丝放入碗中，加入1茶勺的盐拌匀静置片刻，腌制至西葫芦变软、出汁。", 12, 12, "2017-09-12"));
        eatModels.add(new EatModel("http://pic3.16pic.com/00/12/62/16pic_1262783_b.jpg", "6", "因为加了白糖，翻炒几下会有一点汤汁出来，盖上盖子闷1、2分钟。", 12, 12, "2017-09-12"));
        adapter = new EatFragmentAdapter(eatModels, getActivity());
        adapter.setListener(new IAdapterOnClick() {
            @Override
            public void setOnClickListener(View v) {
                Toast.makeText(getActivity(), "点我干啥", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setOnLongClickListener(View v) {

                Toast.makeText(getActivity(), "点我那么长时间干啥", Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(adapter);
    }
}
