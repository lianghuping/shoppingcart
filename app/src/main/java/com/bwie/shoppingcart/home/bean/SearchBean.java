package com.bwie.shoppingcart.home.bean;

import java.util.List;

public class SearchBean {


    /**
     * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/5/1.jpg","price":459,"commodityId":160,"saleNum":0,"commodityName":"简约百搭商务休闲鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/6/1.jpg","price":298,"commodityId":168,"saleNum":0,"commodityName":"李宁 狼塔低帮 男款跑步鞋ARHN205耐磨防滑运动鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/2/1.jpg","price":99,"commodityId":136,"saleNum":0,"commodityName":"板鞋休闲鞋男男士休闲运动鞋男士鞋子休闲皮鞋男士休闲鞋男鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/3/1.jpg","price":148,"commodityId":144,"saleNum":0,"commodityName":"冬季新款高帮帆布鞋加绒保暖平底百搭时尚气质绑带字母经典款帆布鞋男士系带休闲靴"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/px/4/1.jpg","price":119,"commodityId":152,"saleNum":0,"commodityName":"皮鞋男真皮黑色透气男士休闲皮鞋男鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/3/1.jpg","price":199,"commodityId":165,"saleNum":0,"commodityName":"特步XTEP 减震耐磨 男款全掌气垫跑鞋运动鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/7/1.jpg","price":99,"commodityId":141,"saleNum":0,"commodityName":"AUXTUN港仔原宿男鞋秋季鞋子男潮鞋百搭韩版潮流男士休闲鞋板鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/px/1/1.jpg","price":258,"commodityId":149,"saleNum":0,"commodityName":"新品蛇纹商务正装系带皮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/2/1.jpg","price":249,"commodityId":157,"saleNum":0,"commodityName":"舒适百搭套脚商务休闲鞋男士皮鞋男鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/7/1.jpg","price":258,"commodityId":162,"saleNum":0,"commodityName":"冬季新款 牛皮纯色保暖绒里纯色套脚休闲鞋英伦风商务休闲鞋"}]
     * message : 查询成功
     * status : 0000
     */
    private List<ResultEntity> result;
    private String message;
    private String status;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public class ResultEntity {
        /**
         * masterPic : http://172.17.8.100/images/small/commodity/nx/swxxx/5/1.jpg
         * price : 459
         * commodityId : 160
         * saleNum : 0
         * commodityName : 简约百搭商务休闲鞋
         */
        private String masterPic;
        private int price;
        private int commodityId;
        private int saleNum;
        private String commodityName;

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public int getPrice() {
            return price;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public String getCommodityName() {
            return commodityName;
        }
    }
}
