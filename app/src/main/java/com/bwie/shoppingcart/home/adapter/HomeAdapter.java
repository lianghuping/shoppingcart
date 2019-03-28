package com.bwie.shoppingcart.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.activity.AttributionActivity;
import com.bwie.shoppingcart.home.bean.BannerBean;
import com.bwie.shoppingcart.home.bean.HomeBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private final int a=1;
    private final int b=2;
    private final int c=3;
    private Context context;
    private HomeBean list;
    private View mView;
    private HotAdapter four;
    private MagicAdapter five;
    private QualityAdapter six;
    private BannerBean banner1;

    public HomeAdapter(Context context, HomeBean list, BannerBean banner1) {

        this.context = context;
        this.list = list;
        this.banner1 = banner1;
    }

    public void setList(HomeBean list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            mView = View.inflate(viewGroup.getContext(), R.layout.iteam_home1, null);
            return new AViewHodler(mView);
        } else if (i == 2) {
            return new A1ViewHodler(LayoutInflater.from(context).inflate(R.layout.iteam_home2, viewGroup, false));
        } else if (i==3){
            return new A2ViewHodler(LayoutInflater.from(context).inflate(R.layout.iteam_home3, viewGroup, false));
        }
        else {
            return new A3ViewHodler(LayoutInflater.from(context).inflate(R.layout.banner, viewGroup, false));
        }

    }


    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, final int i) {

        if (banner1 != null) {
            final HomeBean.ResultEntity result = list.getResult();
            if (viewHolder instanceof AViewHodler) {
                final List<HomeBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList = result.getRxxp().getCommodityList();
                ((AViewHodler) viewHolder).name1.setText(list.getResult().getRxxp().getName());
                GridLayoutManager linearLayoutManager = new GridLayoutManager(context, 3);
                ((AViewHodler) viewHolder).rv3.setLayoutManager(linearLayoutManager);
                four = new HotAdapter(commodityList,context);
                ((AViewHodler) viewHolder).rv3.setAdapter(four);



              ((AViewHodler) viewHolder).rexiao_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AttributionActivity.class);
                        intent.putExtra("ids",result.getRxxp().getId());
                        context.startActivity(intent);
                    }
                });
            }
            if (viewHolder instanceof A1ViewHodler) {
                ((A1ViewHodler) viewHolder).name2.setText(list.getResult().getMlss().getName());
                List<HomeBean.ResultEntity.MlssEntity.CommodityListEntity> mlss = result.getMlss().getCommodityList();
                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                ((A1ViewHodler) viewHolder).rv1.setLayoutManager(layoutManager);
                five = new MagicAdapter(mlss,context);
                ((A1ViewHodler) viewHolder).rv1.setAdapter(five);
                ((A1ViewHodler) viewHolder).moli_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AttributionActivity.class);
                        intent.putExtra("ids",result.getMlss().getId());
                        context.startActivity(intent);
                    }
                });
            }
            if(viewHolder instanceof A2ViewHodler){
                ((A2ViewHodler) viewHolder).name3.setText(list.getResult().getPzsh().getName());
                List<HomeBean.ResultEntity.PzshEntity.CommodityListEntity> pzsh = list.getResult().getPzsh().getCommodityList();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
                ((A2ViewHodler) viewHolder).rv2.setLayoutManager(gridLayoutManager);
                six = new QualityAdapter(pzsh,context);
                ((A2ViewHodler) viewHolder).rv2.setAdapter(six);
                ((A2ViewHodler) viewHolder).pzsh_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AttributionActivity.class);
                        intent.putExtra("ids",result.getPzsh().getId());
                        context.startActivity(intent);
                    }
                });
            }

            if(viewHolder instanceof A3ViewHodler){
                 //Toast.makeText(context,""+banner1.result.get(0).imageUrl,Toast.LENGTH_SHORT).show();
                ((A3ViewHodler) viewHolder).banner.setData(banner1.getResult(), null);
                ((A3ViewHodler) viewHolder).banner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(banner1.getResult().get(position).getImageUrl()).into((ImageView) view);
                        banner.setPageChangeDuration(1000);
                    }
                });
            }


        }

    }
    @Override
    public int getItemViewType(int position) {
        return position%4;
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    class AViewHodler extends RecyclerView.ViewHolder {

        private final TextView name1;
        private final RecyclerView rv3;
        private final ImageView rexiao_image;

        public AViewHodler(@NonNull View itemView) {
            super(itemView);
            name1 = itemView.findViewById(R.id.text_re);
            rv3 = itemView.findViewById(R.id.rv3);
            rexiao_image = itemView.findViewById(R.id.rexiao_image);
        }
    }

    class A1ViewHodler extends RecyclerView.ViewHolder {
        private final TextView name2;

        private final RecyclerView rv1;
        private final ImageView moli_image;
        public A1ViewHodler(@NonNull View itemView) {
            super(itemView);


            rv1 = itemView.findViewById(R.id.rv1);

            name2 = itemView.findViewById(R.id.text_name2);
            moli_image = itemView.findViewById(R.id.moli_image);

        }
    }

    class A2ViewHodler extends RecyclerView.ViewHolder {

        private final TextView name3;
        private final RecyclerView rv2;
        private final ImageView pzsh_image;

        public A2ViewHodler(@NonNull View itemView) {
            super(itemView);
            rv2 = itemView.findViewById(R.id.rv2);
            name3 = itemView.findViewById(R.id.text_name3);
            pzsh_image = itemView.findViewById(R.id.pzsh_image);
        }
    }

    class A3ViewHodler extends RecyclerView.ViewHolder {
        XBanner banner;
        public A3ViewHodler(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }



}
