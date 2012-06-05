package android.kotlin

public trait KotlinParcelable {


}

//public class MyParcelable implements Parcelable {
//private int mData;
//
//public int describeContents() {
//return 0;
//}
//
//public void writeToParcel(Parcel out, int flags) {
//out.writeInt(mData);
//}
//
//public static final Parcelable.Creator<MyParcelable> CREATOR
//= new Parcelable.Creator<MyParcelable>() {
//public MyParcelable createFromParcel(Parcel in) {
//return new MyParcelable(in);
//}
//
//public MyParcelable[] newArray(int size) {
//return new MyParcelable[size];
//}
//};
//
//private MyParcelable(Parcel in) {
//mData = in.readInt();
//}
//}