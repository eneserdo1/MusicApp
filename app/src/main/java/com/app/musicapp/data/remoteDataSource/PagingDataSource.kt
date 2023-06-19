package com.app.musicapp.data.remoteDataSource

import androidx.paging.PagingSource
import com.app.musicapp.data.models.Result
import com.app.musicapp.data.network.ApiService
import retrofit2.HttpException
import javax.inject.Inject

class PagingDataSource @Inject constructor(private val apiService: ApiService) :
    PagingSource<Int, Result>() {

    companion object {
        const val STARTING_PAGE_INDEX = 1
        const val NETWORK_PAGE_SIZE = 20
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val serviceParams = HashMap<String, String>().apply {
                this["offset"] = position.toString()
                this["limit"] = NETWORK_PAGE_SIZE.toString()
            }
            val response = apiService.getMusicList(param = serviceParams)
            val responseDataList = response.body()?.results ?: emptyList<Result>()
            val nextKey = if (responseDataList.isEmpty()) {
                null
            } else {
                if (
                    params.loadSize == 3 * NETWORK_PAGE_SIZE
                ) {
                    position + 1
                } else {
                    position + (params.loadSize / NETWORK_PAGE_SIZE)
                }
            }


            val prevKey = if (position == 1) null else position - 1

            return LoadResult.Page(
                data = responseDataList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}