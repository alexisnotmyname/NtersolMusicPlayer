package com.alex.ntersolexam.model

import android.os.Parcel
import android.os.Parcelable

data class Songs(
    val commentCount: Int,
    val dateCreated: String?,
    val guid: String?,
    val isFeatured: Boolean,
    val isLocked: Boolean,
    val isPublished: Boolean,
    val merchantDescription: String?,
    val merchantGUID: String?,
    val merchantName: String?,
    val name: String?,
    val normalizedProfileImageUrl: String?,
    val normalizedThumbnailImageBLOBGUID: String?,
    val normalizedThumbnailImageUrl: String?,
    val platform: String?,
    val postType: String?,
    val previewContentBLOBGUID: String?,
    val previewContentUrl: String?,
    val profileImageUrl: String?,
    val ratingAverage: Double,
    val ratingCount: Int,
    val reactionCount: Int,
    val secondsBeforeLock: Int,
    val thumbnailImageBLOBGUID: String?,
    val thumbnailImageUrl: String?,
    val unlockAmount: Double,
    val unlockDays: Int,
    val unlockTokenProfileKey: String?,
    val userDisplayName: String?,
    val userGUID: String?,
    val userUsername: String?,
    val viewCount: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(commentCount)
        parcel.writeString(dateCreated)
        parcel.writeString(guid)
        parcel.writeByte(if (isFeatured) 1 else 0)
        parcel.writeByte(if (isLocked) 1 else 0)
        parcel.writeByte(if (isPublished) 1 else 0)
        parcel.writeString(merchantDescription)
        parcel.writeString(merchantGUID)
        parcel.writeString(merchantName)
        parcel.writeString(name)
        parcel.writeString(normalizedProfileImageUrl)
        parcel.writeString(normalizedThumbnailImageBLOBGUID)
        parcel.writeString(normalizedThumbnailImageUrl)
        parcel.writeString(platform)
        parcel.writeString(postType)
        parcel.writeString(previewContentBLOBGUID)
        parcel.writeString(previewContentUrl)
        parcel.writeString(profileImageUrl)
        parcel.writeDouble(ratingAverage)
        parcel.writeInt(ratingCount)
        parcel.writeInt(reactionCount)
        parcel.writeInt(secondsBeforeLock)
        parcel.writeString(thumbnailImageBLOBGUID)
        parcel.writeString(thumbnailImageUrl)
        parcel.writeDouble(unlockAmount)
        parcel.writeInt(unlockDays)
        parcel.writeString(unlockTokenProfileKey)
        parcel.writeString(userDisplayName)
        parcel.writeString(userGUID)
        parcel.writeString(userUsername)
        parcel.writeInt(viewCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Songs> {
        override fun createFromParcel(parcel: Parcel): Songs {
            return Songs(parcel)
        }

        override fun newArray(size: Int): Array<Songs?> {
            return arrayOfNulls(size)
        }
    }

}