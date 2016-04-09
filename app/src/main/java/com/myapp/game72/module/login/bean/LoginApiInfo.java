package com.myapp.game72.module.login.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LoginApiInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * uid : 318464875
     * detail_address :
     * hpic : http://www.yuu1.com//data/avatar/avatar_7.png
     * nickname : 啊啊都是大富大贵
     * qq :
     * receiver : 13970239406
     * sex : 0
     * phone : 13970239406
     * username : 13970239406
     * score : 300
     * expend : 300
     * code : 84760
     * invite_num : 0
     * token : 3dcf36tgHkO0wli4y6F28qrAnzGs2MGUbJnewMeG/xOgQMpmET2DCBRkf0BEcZQiK6KIE5HauA
     */

    private InfoEntity info;
    /**
     * info : {"uid":"318464875","detail_address":"","hpic":"http://www.yuu1.com//data/avatar/avatar_7.png","nickname":"啊啊都是大富大贵","qq":"","receiver":"13970239406","sex":"0","phone":"13970239406","username":"13970239406","score":"300","expend":"300","code":"84760","invite_num":"0","token":"3dcf36tgHkO0wli4y6F28qrAnzGs2MGUbJnewMeG/xOgQMpmET2DCBRkf0BEcZQiK6KIE5HauA"}
     * page : null
     * state : success
     */

    private Object page;
    private String state;

    public InfoEntity getInfo() {
        return info;
    }

    public void setInfo(InfoEntity info) {
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

    public static class InfoEntity implements Serializable{
        private static final long serialVersionUID = 1L;
        private String uid;
        private String detail_address;
        private String hpic;
        private String nickname;
        private String qq;
        private String receiver;
        private String sex;
        private String phone;
        private String username;
        private String score;
        private String expend;
        private String code;
        private String invite_num;
        private String token;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getDetail_address() {
            return detail_address;
        }

        public void setDetail_address(String detail_address) {
            this.detail_address = detail_address;
        }

        public String getHpic() {
            return hpic;
        }

        public void setHpic(String hpic) {
            this.hpic = hpic;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getExpend() {
            return expend;
        }

        public void setExpend(String expend) {
            this.expend = expend;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getInvite_num() {
            return invite_num;
        }

        public void setInvite_num(String invite_num) {
            this.invite_num = invite_num;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }


        public InfoEntity() {
        }


    }


    public LoginApiInfo() {
    }

    protected LoginApiInfo(Parcel in) {
        this.info = in.readParcelable(InfoEntity.class.getClassLoader());
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.state = in.readString();
    }

    public static final Parcelable.Creator<LoginApiInfo> CREATOR = new Parcelable.Creator<LoginApiInfo>() {
        @Override
        public LoginApiInfo createFromParcel(Parcel source) {
            return new LoginApiInfo(source);
        }

        @Override
        public LoginApiInfo[] newArray(int size) {
            return new LoginApiInfo[size];
        }
    };
}
