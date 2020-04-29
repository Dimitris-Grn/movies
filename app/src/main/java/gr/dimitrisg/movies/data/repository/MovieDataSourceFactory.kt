package gr.dimitrisg.movies.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import gr.dimitrisg.movies.data.api.RestApi
import gr.dimitrisg.movies.data.model.popularmovie.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (
    private val restApi: RestApi,
    private val compositeDisposable: CompositeDisposable
): DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(restApi, compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)

        return movieDataSource
    }
}