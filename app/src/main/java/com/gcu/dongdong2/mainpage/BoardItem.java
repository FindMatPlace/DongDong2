package com.gcu.dongdong2.mainpage;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class BoardItem implements Parcelable {
    private int profileImage;
    private String name;
    private String content;
    private Uri contentImageUri;
    private int id;

    public BoardItem(int profileImage, String name, String content, Uri contentImageUri, int id) { // 변경된 부분
        this.profileImage = profileImage;
        this.name = name;
        this.content = content;
        this.contentImageUri = contentImageUri; // 변경된 부분
        this.id = id;
    }

    protected BoardItem(Parcel in) {
        profileImage = in.readInt();
        contentImageUri = in.readParcelable(Uri.class.getClassLoader());
        name = in.readString();
        content = in.readString();
    }

    public static final Creator<BoardItem> CREATOR = new Creator<BoardItem>() {
        @Override
        public BoardItem createFromParcel(Parcel in) {
            return new BoardItem(in);
        }

        @Override
        public BoardItem[] newArray(int size) {
            return new BoardItem[size];
        }
    };

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Uri getContentImageUri() {
        return contentImageUri;
    }

    public void setContentImageUri(Uri contentImageUri) {
        this.contentImageUri = contentImageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(profileImage);
        dest.writeParcelable(contentImageUri, flags);
        dest.writeString(name);
        dest.writeString(content);
    }
}

