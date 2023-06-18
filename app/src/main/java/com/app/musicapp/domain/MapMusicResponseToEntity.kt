package com.app.musicapp.domain

import com.app.musicapp.data.localDataSource.MusicEntity
import com.app.musicapp.data.models.MusicListResponseItem

object MapMusicResponseToEntity {
    fun mapResponseToEntity(response: MusicListResponseItem): List<MusicEntity> {
        val entityList = mutableListOf<MusicEntity>()
        response.results.forEach { result ->
            val entity = MusicEntity(
                artistId = result.artistId,
                artistName = result.artistName,
                artistViewUrl = result.artistViewUrl,
                artworkUrl100 = result.artworkUrl100,
                artworkUrl30 = result.artworkUrl30,
                artworkUrl60 = result.artworkUrl60,
                collectionArtistId = result.collectionArtistId,
                collectionArtistName = result.collectionArtistName,
                collectionArtistViewUrl = result.collectionArtistViewUrl,
                collectionCensoredName = result.collectionCensoredName,
                collectionExplicitness = result.collectionExplicitness,
                collectionHdPrice = result.collectionHdPrice,
                collectionId = result.collectionId,
                collectionName = result.collectionName,
                collectionPrice = result.collectionPrice,
                collectionViewUrl = result.collectionViewUrl,
                contentAdvisoryRating = result.contentAdvisoryRating,
                country = result.country,
                currency = result.currency,
                discCount = result.discCount,
                discNumber = result.discNumber,
                hasITunesExtras = result.hasITunesExtras,
                isStreamable = result.isStreamable,
                kind = result.kind,
                longDescription = result.longDescription,
                previewUrl = result.previewUrl,
                primaryGenreName = result.primaryGenreName,
                releaseDate = result.releaseDate,
                shortDescription = result.shortDescription,
                trackCensoredName = result.trackCensoredName,
                trackCount = result.trackCount,
                trackExplicitness = result.trackExplicitness,
                trackHdPrice = result.trackHdPrice,
                trackHdRentalPrice = result.trackHdRentalPrice,
                trackId = result.trackId,
                trackName = result.trackName,
                trackNumber = result.trackNumber,
                trackPrice = result.trackPrice,
                trackRentalPrice = result.trackRentalPrice,
                trackTimeMillis = result.trackTimeMillis,
                trackViewUrl = result.trackViewUrl,
                wrapperType = result.wrapperType
            )
            entityList.add(entity)
        }
        return entityList
    }

}