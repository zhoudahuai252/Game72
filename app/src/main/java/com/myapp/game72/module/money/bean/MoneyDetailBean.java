package com.myapp.game72.module.money.bean;

public class MoneyDetailBean  {

    /**
     * id : 801
     * name : 三国群英塔防
     * score : 8.0
     * version : 1.15.1
     * icon : http://i3.72g.com/upload/201604/201604071526531822.png
     * snapshot : http://i3.72g.com/upload/201604/201604071525121201.jpg,http://i3.72g.com/upload/201604/201604071525128096.jpg,http://i3.72g.com/upload/201604/201604071525133949.jpg,http://i3.72g.com/upload/201604/201604071525137340.jpg
     * size : 65.4 MB
     * dl_back_jifen : 200
     * android_dl : http://twzw.center.gzyouai.com:8888/sgz/sgqytf_tencent_8_1.15.1_196.apk
     * ios_dl : null
     * count_dl : 640
     * game_desc : 一款以养成、搜集、策略、塔防等玩法众多的手机网游。
     它画面写实复古，内容精彩丰富，整个游戏架构在三国的主题背景之上，打破传统游戏模式，战斗富有策略和挑战。在游戏中提供了闯关战斗、精英关卡、竞技场、锻造、招贤等特色玩法。在战斗中感受酷炫的技能特效，扫平来犯千军万马；联网PK对战，征伐群雄，酣畅淋漓，体验倍感畅爽！
     * swxx :
     * game_task_state : 1
     * limit_number : 0
     */

    private InfoBean info;
    /**
     * info : {"id":"801","name":"三国群英塔防","score":"8.0","version":"1.15.1","icon":"http://i3.72g.com/upload/201604/201604071526531822.png","snapshot":"http://i3.72g.com/upload/201604/201604071525121201.jpg,http://i3.72g.com/upload/201604/201604071525128096.jpg,http://i3.72g.com/upload/201604/201604071525133949.jpg,http://i3.72g.com/upload/201604/201604071525137340.jpg","size":"65.4 MB","dl_back_jifen":"200","android_dl":"http://twzw.center.gzyouai.com:8888/sgz/sgqytf_tencent_8_1.15.1_196.apk","ios_dl":null,"count_dl":"640","game_desc":"一款以养成、搜集、策略、塔防等玩法众多的手机网游。\n它画面写实复古，内容精彩丰富，整个游戏架构在三国的主题背景之上，打破传统游戏模式，战斗富有策略和挑战。在游戏中提供了闯关战斗、精英关卡、竞技场、锻造、招贤等特色玩法。在战斗中感受酷炫的技能特效，扫平来犯千军万马；联网PK对战，征伐群雄，酣畅淋漓，体验倍感畅爽！","swxx":"","game_task_state":"1","limit_number":"0"}
     * page : null
     * state : success
     */

    private Object page;
    private String state;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class InfoBean {
        private String id;
        private String name;
        private String score;
        private String version;
        private String icon;
        private String snapshot;
        private String size;
        private String dl_back_jifen;
        private String android_dl;
        private Object ios_dl;
        private String count_dl;
        private String game_desc;
        private String swxx;
        private String game_task_state;
        private String limit_number;

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

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSnapshot() {
            return snapshot;
        }

        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
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

        public Object getIos_dl() {
            return ios_dl;
        }

        public void setIos_dl(Object ios_dl) {
            this.ios_dl = ios_dl;
        }

        public String getCount_dl() {
            return count_dl;
        }

        public void setCount_dl(String count_dl) {
            this.count_dl = count_dl;
        }

        public String getGame_desc() {
            return game_desc;
        }

        public void setGame_desc(String game_desc) {
            this.game_desc = game_desc;
        }

        public String getSwxx() {
            return swxx;
        }

        public void setSwxx(String swxx) {
            this.swxx = swxx;
        }

        public String getGame_task_state() {
            return game_task_state;
        }

        public void setGame_task_state(String game_task_state) {
            this.game_task_state = game_task_state;
        }

        public String getLimit_number() {
            return limit_number;
        }

        public void setLimit_number(String limit_number) {
            this.limit_number = limit_number;
        }
    }
}
