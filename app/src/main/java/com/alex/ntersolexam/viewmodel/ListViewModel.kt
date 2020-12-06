package com.alex.ntersolexam.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.alex.ntersolexam.model.ApiService
import com.alex.ntersolexam.model.Songs
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(application: Application) : AndroidViewModel(application) {

    val songs by lazy { MutableLiveData<List<Songs>>()}
    val loadError by lazy {MutableLiveData<Boolean>()}
    val loading by lazy {MutableLiveData<Boolean>()}

    private val disposable = CompositeDisposable()
    private val apiService = ApiService()

    fun refresh() {
        loading.value = true;
        searchSongs("RevCastFilms", "Audio")
    }

    private fun searchSongs(platform: String, postType: String) {
        disposable.add(
            apiService.searchSongs(platform, postType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Songs>>(){
                    override fun onSuccess(list: List<Songs>) {
                        loadError.value = false
                        loading.value = false
                        songs.value = list
                    }

                    override fun onError(e: Throwable) {
                        loadError.value = true
                        loading.value = false
                        songs.value = null
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}