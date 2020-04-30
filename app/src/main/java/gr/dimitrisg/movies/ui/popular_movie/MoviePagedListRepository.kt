package gr.dimitrisg.movies.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import gr.dimitrisg.movies.data.api.POST_PER_PAGE
import gr.dimitrisg.movies.data.api.RestApi
import gr.dimitrisg.movies.data.model.popularmovie.Movie
import gr.dimitrisg.movies.data.repository.MovieDataSource
import gr.dimitrisg.movies.data.repository.MovieDataSourceFactory
import gr.dimitrisg.movies.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository (private val apiService: RestApi) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState
        )
    }
}