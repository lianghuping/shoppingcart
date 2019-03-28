package com.bwie.shoppingcart.home.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bounced2Bean {


    /**
     * result : [{"id":"1001002001","name":"外套"},{"id":"1001002002","name":"裙装"},{"id":"1001002003","name":"打底毛衣"},{"id":"1001002004","name":"卫衣"},{"id":"1001002005","name":"裤装"}]
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
         * id : 1001002001
         * name : 外套
         */

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return

                    "name=" + name +"\n"
                    ;
        }
    }
}
