package gr.dimitrisg.movies.ui.popular_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import gr.dimitrisg.movies.R
import gr.dimitrisg.movies.ui.single_movie_details.SingleMovie

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}