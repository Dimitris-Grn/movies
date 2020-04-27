package gr.dimitrisg.movies.data.repository

import androidx.lifecycle.LiveData
import gr.dimitrisg.movies.data.api.RestApi
import gr.dimitrisg.movies.data.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieRepository(private val restApi: RestApi) {
    lateinit var networkDatasource: NetworkDatasource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {
        networkDatasource = NetworkDatasource(restApi, compositeDisposable)
        networkDatasource.fetchMovieDetails(movieId)

        return networkDatasource.movieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return networkDatasource.networkState
    }
}