package gr.dimitrisg.movies.data.repository

// api key
// 6e63c2317fbe963d76c3bdc2b785f6d1
enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {

    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "Success")
            LOADING = NetworkState(Status.RUNNING, "Running")
            ERROR =NetworkState(Status.FAILED, "Something went wriong")
        }
    }

}