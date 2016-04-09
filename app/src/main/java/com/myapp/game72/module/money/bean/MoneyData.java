package com.myapp.game72.module.money.bean;

import java.util.List;

public class MoneyData {
    @Override
    public String toString() {
        return "MoneyData{" +
                "page=" + page +
                ", state='" + state + '\'' +
                ", info=" + info +
                '}';
    }

    /**
     * total : 17
     * pagesize : 10
     * page : 1
     * page_total : 2
     */

    private PageEntity page;
    /**
     * info : [{"id":"798","name":"星辰奇缘","score":"8.0","icon":"http://i3.72g.com/upload/201604/201604011722162255.png","size":"151MB","dl_back_jifen":"300","android_dl":"http://market-download.kkk5.com/xcqy/xcqy_0_6803.apk ","ios_dl":"","count_dl":"776","all_prize":2500},{"id":"796","name":"部落冲突：皇室战争","score":"9.0","icon":"http://i5.72g.com/upload/201602/201602170932156972.jpg","size":"86.94MB","dl_back_jifen":"200","android_dl":"http://api.np.mobilem.360.cn/redirect/down/?from=lm_226231&appid=3247379","ios_dl":"","count_dl":"848","all_prize":3200},{"id":"799","name":" 决战SF","score":"8.0","icon":"http://i3.72g.com/upload/201604/201604011728107134.png","size":"36.9MB","dl_back_jifen":"200","android_dl":"http://market-download.kkk5.com/jzsf/jzsf_0_6774.apk","ios_dl":"","count_dl":"711","all_prize":1700},{"id":"795","name":"皇图","score":"8.0","icon":"http://i3.72g.com/upload/201510/201510201430336075.png","size":"144MB","dl_back_jifen":"100","android_dl":"http://dl.sy.9377.com/ht/ht_9377_sig_ht_masbz6.apk","ios_dl":"","count_dl":"986","all_prize":3800},{"id":"794","name":"超级群英传","score":"8.5","icon":"http://i3.72g.com/upload/201603/201603031832369249.png","size":"23.91M","dl_back_jifen":"100","android_dl":"http://market-download.kkk5.com/cjqyz/kkk_sgqyz_6343.apk","ios_dl":"","count_dl":"1502","all_prize":1500},{"id":"797","name":"女王号令","score":"8.0","icon":"http://i3.72g.com/upload/201603/201603311618008944.png","size":"214","dl_back_jifen":"100","android_dl":"http://dl.sy.9377.com/nwhl/nwhl_9377_nv_mas6.apk","ios_dl":"","count_dl":"808","all_prize":3800},{"id":"793","name":"坦克前线","score":"8.5","icon":"http://i3.72g.com/upload/201603/201603031020598919.png","size":"24.2M","dl_back_jifen":"100","android_dl":"http://market-download.kkk5.com/hjtk/RedAlerttank_0_2446.apk","ios_dl":"","count_dl":"1510","all_prize":1300},{"id":"792","name":"曹操传","score":"7.5","icon":"http://i3.72g.com/upload/201602/201602241014186510.png","size":"72.2MB","dl_back_jifen":"200","android_dl":"http://market-download.kkk5.com/ccz/3kzhuan6088.apk","ios_dl":"","count_dl":"3950","all_prize":2000},{"id":"791","name":"超级舰队","score":"7.5","icon":"http://i3.72g.com/upload/201602/201602231700217209.png","size":"19.5MB","dl_back_jifen":"100","android_dl":"http://market-download.kkk5.com/cjjd/SuperOfFleet_0_6265.apk","ios_dl":"","count_dl":"3863","all_prize":1500},{"id":"789","name":"御剑飞仙","score":"7.8","icon":"http://i3.72g.com/upload/201601/201601291631591381.png","size":"130MB","dl_back_jifen":"300","android_dl":"http://market-download.kkk5.com/yjfx/journey_0_6321.apk","ios_dl":"","count_dl":"4253","all_prize":2500}]
     * page : {"total":17,"pagesize":10,"page":1,"page_total":2}
     * state : success
     */

    private String state;
    /**
     * id : 798
     * name : 星辰奇缘
     * score : 8.0
     * icon : http://i3.72g.com/upload/201604/201604011722162255.png
     * size : 151MB
     * dl_back_jifen : 300
     * android_dl : http://market-download.kkk5.com/xcqy/xcqy_0_6803.apk
     * ios_dl :
     * count_dl : 776
     * all_prize : 2500
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
        private int total;
        private int pagesize;
        private int page;
        private int page_total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
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
        private String score;
        private String icon;
        private String size;
        private String dl_back_jifen;
        private String android_dl;
        private String ios_dl;
        private String count_dl;
        private int all_prize;

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

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDl_back_jifen() {
            return dl_back_jifen;
        }

        public void setDl_back_jifen(String dl_back_jifen) {
            this.dl_back_jifen = dl_back_jifen;
        }

        public String getAndroid_dl() {
            return android_dl;
        }

        public void setAndroid_dl(String android_dl) {
            this.android_dl = android_dl;
        }

        public String getIos_dl() {
            return ios_dl;
        }

        public void setIos_dl(String ios_dl) {
            this.ios_dl = ios_dl;
        }

        public String getCount_dl() {
            return count_dl;
        }

        public void setCount_dl(String count_dl) {
            this.count_dl = count_dl;
        }

        public int getAll_prize() {
            return all_prize;
        }

        public void setAll_prize(int all_prize) {
            this.all_prize = all_prize;
        }
    }
}
