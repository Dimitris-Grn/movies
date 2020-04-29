package gr.dimitrisg.movies.data.repository

import androidx.lifecycle.LiveData
import gr.dimitrisg.movies.data.api.RestApi
import gr.dimitrisg.movies.data.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieRepository(private val restApi: RestApi) {
    lateinit var dataSource: DataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {
        dataSource = DataSource(restApi, compositeDisposable)
        dataSource.fetchMovieDetails(movieId)

        return dataSource.movieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return dataSource.networkState
    }
}