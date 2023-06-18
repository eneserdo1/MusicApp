package com.app.musicapp.common.models

import android.os.Parcel
import android.os.Parcelable

data class MusicUiModel(
    val id: Int = 0,
    val artistId: Int ? = null,
    val artistName: String ? = null,
    val artistViewUrl: String ? = null,
    val artworkUrl100: String ? = null,
    val artworkUrl30: String ? = null,
    val artworkUrl60: String ? = null,
    val collectionArtistId: Int ? = null,
    val collectionArtistName: String ? = null,
    val collectionArtistViewUrl: String ? = null,
    val collectionCensoredName: String ? = null,
    val collectionExplicitness: String ? = null,
    val collectionHdPrice: Double ? = null,
    val collectionId: Int ? = null,
    val collectionName: String ? = null,
    val collectionPrice: Double ? = null,
    val collectionViewUrl: String ? = null,
    val contentAdvisoryRating: String ? = null,
    val country: String ? = null,
    val currency: String ? = null,
    val discCount: Int ? = null,
    val discNumber: Int ? = null,
    val hasITunesExtras: Boolean ? = null,
    val isStreamable: Boolean ? = null,
    val kind: String ? = null,
    val longDescription: String ? = null,
    val previewUrl: String ? = null,
    val primaryGenreName: String ? = null,
    val releaseDate: String ? = null,
    val shortDescription: String ? = null,
    val trackCensoredName: String ? = null,
    val trackCount: Int ? = null,
    val trackExplicitness: String ? = null,
    val trackHdPrice: Double ? = null,
    val trackHdRentalPrice: Double ? = null,
    val trackId: Int ? = null,
    val trackName: String ? = null,
    val trackNumber: Int ? = null,
    val trackPrice: Double ? = null,
    val trackRentalPrice: Double ? = null,
    val trackTimeMillis: Int ? = null,
    val trackViewUrl: String ? = null,
    val wrapperType: String ? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeValue(artistId)
        parcel.writeString(artistName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeValue(collectionArtistId)
        parcel.writeString(collectionArtistName)
        parcel.writeString(collectionArtistViewUrl)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(collectionExplicitness)
        parcel.writeValue(collectionHdPrice)
        parcel.writeValue(collectionId)
        parcel.writeString(collectionName)
        parcel.writeValue(collectionPrice)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeValue(discCount)
        parcel.writeValue(discNumber)
        parcel.writeValue(hasITunesExtras)
        parcel.writeValue(isStreamable)
        parcel.writeString(kind)
        parcel.writeString(longDescription)
        parcel.writeString(previewUrl)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
        parcel.writeString(shortDescription)
        parcel.writeString(trackCensoredName)
        parcel.writeValue(trackCount)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(trackHdPrice)
        parcel.writeValue(trackHdRentalPrice)
        parcel.writeValue(trackId)
        parcel.writeString(trackName)
        parcel.writeValue(trackNumber)
        parcel.writeValue(trackPrice)
        parcel.writeValue(trackRentalPrice)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(trackViewUrl)
        parcel.writeString(wrapperType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MusicUiModel> {
        override fun createFromParcel(parcel: Parcel): MusicUiModel {
            return MusicUiModel(parcel)
        }

        override fun newArray(size: Int): Array<MusicUiModel?> {
            return arrayOfNulls(size)
        }
    }
}