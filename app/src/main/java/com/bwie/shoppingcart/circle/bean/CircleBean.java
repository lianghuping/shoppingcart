package com.bwie.shoppingcart.circle.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CircleBean {


    /**
     * result : [{"commodityId":1,"content":"元气满满","createTime":1553266525000,"greatNum":69,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-26/20190326142936.png","id":790,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-22/6731420190322095525.png","nickName":"2A_dE4I6","userId":752,"whetherGreat":2},{"commodityId":1,"content":"wkq","createTime":1553218505000,"greatNum":2788,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":789,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-21/6128320190321203505.png","nickName":"HA_DM5T9","userId":11,"whetherGreat":2},{"commodityId":1,"content":"元气满满","createTime":1553216151000,"greatNum":207,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-26/20190326142936.png","id":788,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-21/2380920190321195551.png","nickName":"2A_dE4I6","userId":752,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552607214000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":787,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-14/2346920190314184654.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552577581000,"greatNum":7,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":786,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-14/0176820190314103301.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552527322000,"greatNum":8,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":785,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/4159620190313203522.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552527266000,"greatNum":1709,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":784,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/1876020190313203426.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552527149000,"greatNum":9,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":783,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/3726420190313203229.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552527134000,"greatNum":6,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":782,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/1745920190313203214.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552526643000,"greatNum":14,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":781,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/4315820190313202403.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552526623000,"greatNum":2128,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":780,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/1254720190313202343.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552525963000,"greatNum":5,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-27/20190327195853.png","id":779,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-13/3954720190313201243.jpg","nickName":"hehe","userId":1636,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552079239000,"greatNum":1455,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":778,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552079221000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":777,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552079202000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":776,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552078880000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":775,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552078767000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":774,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552078227000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":773,"image":"","nickName":"do_1plCu","userId":1614,"whetherGreat":2},{"commodityId":1,"content":"很好","createTime":1551997246000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":771,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-07/3187220190307162046.png","nickName":"rainbow","userId":32,"whetherGreat":2},{"commodityId":6,"content":"给大家推荐一个好商品","createTime":1551995199000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-02-27/20190227200822.jpg","id":768,"image":"","nickName":"天情","userId":195,"whetherGreat":2},{"commodityId":103,"content":"","createTime":1551924597000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":760,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/8172420190306200957.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":19,"content":"123","createTime":1551924001000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-07/20190307112048.jpg","id":759,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/5901220190306200001.jpg","nickName":"213","userId":895,"whetherGreat":2},{"commodityId":17,"content":"abc","createTime":1551919876000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-05/20190305193922.jpg","id":758,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/8016720190306185116.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/4716920190306185116.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/5872320190306185116.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/2645820190306185116.jpg","nickName":"王思聪","userId":16,"whetherGreat":2},{"commodityId":17,"content":"abc","createTime":1551919871000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-05/20190305193922.jpg","id":757,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/8506420190306185111.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/3075620190306185111.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/7912020190306185111.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/5208320190306185111.jpg","nickName":"王思聪","userId":16,"whetherGreat":2},{"commodityId":27,"content":"萨达SD敢达沙发上的","createTime":1551904722000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-05/20190305193922.jpg","id":756,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/1685220190306143842.jpg","nickName":"王思聪","userId":16,"whetherGreat":2},{"commodityId":1,"content":"12211","createTime":1551893023000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":754,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/1450820190306112343.png,http://172.17.8.100/images/small/circle_pic/2019-03-06/7302120190306112343.png","nickName":"HA_DM5T9","userId":11,"whetherGreat":2},{"commodityId":1,"content":"美美哒","createTime":1551891095000,"greatNum":3,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":752,"image":"","nickName":"ER_O2LS6","userId":256,"whetherGreat":2},{"commodityId":103,"content":"","createTime":1551888683000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":751,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/8742620190306101123.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":23,"content":"","createTime":1551888467000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":750,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/4086120190306100747.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":23,"content":"","createTime":1551888464000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":749,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/9278620190306100744.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":23,"content":"","createTime":1551887233000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":748,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/5130920190306094713.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":110,"content":"","createTime":1551886427000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":747,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/9052820190306093347.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":110,"content":"","createTime":1551886421000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":746,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/4231520190306093341.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":1,"content":"222","createTime":1551886415000,"greatNum":2,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":745,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/4582720190306093335.png","nickName":"HA_DM5T9","userId":11,"whetherGreat":2},{"commodityId":1,"content":"111","createTime":1551886024000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":744,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/9726820190306092704.png,http://172.17.8.100/images/small/circle_pic/2019-03-06/6024920190306092704.png","nickName":"HA_DM5T9","userId":11,"whetherGreat":2},{"commodityId":1,"content":"哈哈哈","createTime":1551885461000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":743,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-06/4809520190306091741.jpg,http://172.17.8.100/images/small/circle_pic/2019-03-06/9041620190306091741.jpg","nickName":"rainbow","userId":32,"whetherGreat":2},{"commodityId":8,"content":"","createTime":1551843686000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":741,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/2637820190305214126.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":110,"content":"","createTime":1551843547000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":740,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/7916020190305213907.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":14,"content":"","createTime":1551843432000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":739,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/3218420190305213712.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":14,"content":"","createTime":1551843427000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":738,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/3970120190305213707.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":14,"content":"","createTime":1551843349000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":737,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/4026320190305213549.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":8,"content":"","createTime":1551843045000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":736,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/1970320190305213045.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":104,"content":"","createTime":1551843010000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":735,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/6479120190305213010.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":1,"content":"啊阿斗","createTime":1551837856000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":733,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/6329520190305200416.png","nickName":"d5_38S30","userId":560,"whetherGreat":2},{"commodityId":1,"content":"","createTime":1551832029000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":732,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/7536220190305182709.png","nickName":"d5_38S30","userId":560,"whetherGreat":2},{"commodityId":6,"content":"测试一下","createTime":1551831441000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":731,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/8579320190305181721.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":6,"content":"哈哈哈 爱的魔力转圈圈","createTime":1551831398000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":730,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/3691820190305181638.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":3,"content":"给大家推荐这个商品","createTime":1551831346000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-06/20190306201017.jpg","id":729,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/0812520190305181546.jpg","nickName":"222","userId":600,"whetherGreat":2},{"commodityId":1,"content":"","createTime":1551828313000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":728,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/1983220190305172513.png","nickName":"d5_38S30","userId":560,"whetherGreat":2},{"commodityId":29,"content":"lallalal","createTime":1551826278000,"greatNum":1,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-05/20190305183909.png","id":727,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-05/9136220190305165118.png","nickName":"啦啦啦啦","userId":1545,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 1
         * content : 元气满满
         * createTime : 1553266525000
         * greatNum : 69
         * headPic : http://172.17.8.100/images/small/head_pic/2019-03-26/20190326142936.png
         * id : 790
         * image : http://172.17.8.100/images/small/circle_pic/2019-03-22/6731420190322095525.png
         * nickName : 2A_dE4I6
         * userId : 752
         * whetherGreat : 2
         */

        @SerializedName("commodityId")
        private int commodityId;
        @SerializedName("content")
        private String content;
        @SerializedName("createTime")
        private long createTime;
        @SerializedName("greatNum")
        private int greatNum;
        @SerializedName("headPic")
        private String headPic;
        @SerializedName("id")
        private int id;
        @SerializedName("image")
        private String image;
        @SerializedName("nickName")
        private String nickName;
        @SerializedName("userId")
        private int userId;
        @SerializedName("whetherGreat")
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
