package com.app.taxiassistindrive

import com.app.taxiassistindrive.ui.GENERAL_TAG
import timber.log.Timber

object VLog {

    fun d(message: String, tag: String = GENERAL_TAG) {
        Timber.tag(tag).d(message)
    }

    fun e(message: String,tag:String = GENERAL_TAG) {
        Timber.tag(tag).e(message)
    }


}
