package com.tutor.testtaker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Ques implements Parcelable{
    private String question;
    private String opt1,opt2,opt3,opt4;
    private String ans;
    private int id;
    private int user_profile;

    public Ques(String question, String opt1, String opt2, String opt3, String opt4, String ans) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.ans = ans;
    }

    protected Ques(Parcel in) {
        question = in.readString();
        opt1 = in.readString();
        opt2 = in.readString();
        opt3 = in.readString();
        opt4 = in.readString();
        ans = in.readString();
        id = in.readInt();
        user_profile = in.readInt();
    }

    public static final Creator<Ques> CREATOR = new Creator<Ques>() {
        @Override
        public Ques createFromParcel(Parcel in) {
            return new Ques(in);
        }

        @Override
        public Ques[] newArray(int size) {
            return new Ques[size];
        }
    };

    @Override
    public String toString() {
        return "editor{" +
                "question='" + question + '\'' +
                ", opt1='" + opt1 + '\'' +
                ", opt2='" + opt2 + '\'' +
                ", opt3='" + opt3 + '\'' +
                ", opt4='" + opt4 + '\'' +
                ", ans='" + ans + '\'' +
                ", id=" + id +
                ", user_profile=" + user_profile +
                '}';
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(int user_profile) {
        this.user_profile = user_profile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(opt1);
        dest.writeString(opt2);
        dest.writeString(opt3);
        dest.writeString(opt4);
        dest.writeString(ans);
        dest.writeInt(id);
        dest.writeInt(user_profile);
    }
}