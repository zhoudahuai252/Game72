package com.myapp.game72.module.gift.bean;

import java.util.List;

public class GiftBean {

    /**
     * total : 79
     * pagesize : 10
     * page : 1
     * page_total : 8
     */

    private PageEntity page;
    /**
     * info : [{"id":"571","name":"德尔玛（deerma）ED02 电子称 体重秤 人体秤","consume":"110000","icon":"http://i5.265g.com/images/201510/201510211638534206.jpg","remain":"3"},{"id":"559","name":"265G定制电源","consume":"60000","icon":"http://i4.265g.com/images/201501/201501161438002343.jpg","remain":"34"},{"id":"579","name":"飞科(FLYCO)专业电动理发器成人儿童电推剪","consume":"75000","icon":"http://i6.265g.com/images/201512/201512011651149252.png","remain":"9"},{"id":"560","name":"小米（MI）小米手环","consume":"89000","icon":"http://i2.265g.com/images/201501/201501221518213753.jpg","remain":"18"},{"id":"570","name":"联想 乐檬 K3 Note（K50-t3s） 16G 典雅黄","consume":"910000","icon":"http://i2.265g.com/images/201510/201510211634494406.jpg","remain":"8"},{"id":"574","name":"凯速黑玫瑰液压摇摆踏步机","consume":"300000","icon":"http://i7.265g.com/images/201510/201510211656019607.png","remain":"3"},{"id":"512","name":"50元电信话费直冲","consume":"51000","icon":"http://i2.265g.com/images/201503/201503251059126602.jpg","remain":"64"},{"id":"563","name":"骏网10元游戏充值卡","consume":"10000","icon":"http://i5.265g.com/images/201503/201503301345024885.jpg","remain":"29"},{"id":"583","name":"爱奇艺会员年卡","consume":"236000","icon":"http://i6.265g.com/images/201603/201603211218597820.jpg","remain":"50"},{"id":"582","name":"爱奇艺会员半年","consume":"118000","icon":"http://i6.265g.com/images/201603/201603211218597820.jpg","remain":"50"}]
     * page : {"total":"79","pagesize":10,"page":1,"page_total":8}
     * state : success
     */

    private String state;
    /**
     * id : 571
     * name : 德尔玛（deerma）ED02 电子称 体重秤 人体秤
     * consume : 110000
     * icon : http://i5.265g.com/images/201510/201510211638534206.jpg
     * remain : 3
     */

    private List<InfoEntity> info;

    public PageEntity getPage() {
        return page;
    }

    public void setPage(PageEntity page) {
        this.page = page;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InfoEntity> getInfo() {
        return info;
    }

    public void setInfo(List<InfoEntity> info) {
        this.info = info;
    }

    public static class PageEntity {
        private String total;
        private int pagesize;
        private int page;
        private int page_total;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_total() {
            return page_total;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }
    }

    public static class InfoEntity {
        private String id;
        private String name;
        private String consume;
        private String icon;
        private String remain;

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

        public String getConsume() {
            return consume;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getRemain() {
            return remain;
        }

        public void setRemain(String remain) {
            this.remain = remain;
        }
    }
}
