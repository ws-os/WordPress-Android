package org.wordpress.android.viewmodel.activitylog

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.WorkerThread
import org.wordpress.android.fluxc.Dispatcher
import org.wordpress.android.fluxc.model.SiteModel
import org.wordpress.android.fluxc.model.activity.ActivityLogModel
import org.wordpress.android.fluxc.store.ActivityLogStore
import javax.inject.Inject

class ActivityLogViewModel() : ViewModel() {
    private lateinit var dispatcher: Dispatcher
    private lateinit var activityLogStore: ActivityLogStore

    private val events: MutableLiveData<List<ActivityLogModel>> = MutableLiveData()

    var site: SiteModel? = null

    @Inject
    constructor(dispatcher: Dispatcher, activityLogStore: ActivityLogStore) : this() {
        this.dispatcher = dispatcher
        this.activityLogStore = activityLogStore

        dispatcher.register(this)
    }

    override fun onCleared() {
        super.onCleared()

        dispatcher.unregister(this)
    }

    @WorkerThread
    fun fetchActivityLogEntries() {
//        events.postValue(activityLogStore.getEvents())
    }
}