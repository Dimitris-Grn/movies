package gr.dimitrisg.movies.data.model


import com.google.gson.annotations.SerializedName
import gr.dimitrisg.movies.data.model.Movie

data class MovieResponse(
    val page: Int,
    @SerializedName("results")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)