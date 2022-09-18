package abika.sinau.core.data

import abika.sinau.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */
abstract class NetworkResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map { result ->
                    Resource.Success(result)
                })
            }

            is ApiResponse.Error -> {
                emit(Resource.Error(apiResponse.errorMessage))
            }
            ApiResponse.Empty -> {}
        }
    }

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    fun asFlow(): Flow<Resource<ResultType>> = result
}