package gr.dimitrisg.movies.data.repository

import androidx.lifecycle.LiveData
import gr.dimitrisg.movies.data.api.RestApi
import gr.dimitrisg.movies.data.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieRepository(private val restApi: RestApi) {
    lateinit var movieDetailDataSource: MovieDetailDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {
        movieDetailDataSource = MovieDetailDataSource(restApi, compositeDisposable)
        movieDetailDataSource.fetchMovieDetails(movieId)

        return movieDetailDataSource.movieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailDataSource.networkState
    }
}