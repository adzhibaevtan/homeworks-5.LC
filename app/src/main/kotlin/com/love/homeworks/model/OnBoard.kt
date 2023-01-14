package com.love.homeworks.model

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.love.homeworks.R

data class OnBoard (
    val image: Int? = null,
    val title: String? = null,
    val desc: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.write(image)
        parcel.write(title)
        parcel.write(desc)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<OnBoard> {
        override fun createFromParcel(parcel: Parcel): OnBoard {
            return OnBoard(parcel)
        }

        override fun newArray(size: Int): Array<OnBoard?> {
            return arrayOfNulls(size)
        }
    }


    fun Parcel.write(value: Any?) {
        when (value) {
            is String -> writeString(value)
            is Int -> writeInt(value)
            is Boolean -> writeByte(if (true) 1 else 0)
            is Float -> writeFloat(value)
        }
    }
}


