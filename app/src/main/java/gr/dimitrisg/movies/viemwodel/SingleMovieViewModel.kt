package gr.dimitrisg.movies.viemwodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import gr.dimitrisg.movies.data.model.MovieDetails
import gr.dimitrisg.movies.data.repository.MovieRepository
import gr.dimitrisg.movies.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(
    private val movieRepository: MovieRepository,
    movieId: Int
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}