package com.app.taxiassistindrive.services

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityEvent.*
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.app.taxiassistindrive.VLog
import com.app.taxiassistindrive.ui.GENERAL_TAG

class AccService : AccessibilityService() {


	override fun onCreate() {
		super.onCreate()
	}


	override fun onServiceConnected() {
		super.onServiceConnected()
		VLog.d(GENERAL_TAG, "onServiceConnected")
		val info = AccessibilityServiceInfo()
		info.flags = AccessibilityServiceInfo.DEFAULT
		info.eventTypes =
			TYPE_NOTIFICATION_STATE_CHANGED or TYPE_WINDOW_STATE_CHANGED or
					TYPE_WINDOW_CONTENT_CHANGED or TYPE_VIEW_TEXT_CHANGED or
					TYPE_VIEW_TEXT_SELECTION_CHANGED
		info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
		info.notificationTimeout = 1000
		info.packageNames = null
		serviceInfo = info
	}

	override fun onAccessibilityEvent(p0: AccessibilityEvent) {
		try {
			delegateAccEvent(p0)
		} catch (ex: Exception) {
			VLog.d("Exception in delegating accv event : ${ex.message}")
		}
	}

	private fun delegateAccEvent(p0: AccessibilityEvent) {
		when (p0.eventType) {
			TYPE_WINDOW_CONTENT_CHANGED -> {
				VLog.d("Type  Window Content Changed on AccEvent")


			}
			TYPE_WINDOW_STATE_CHANGED -> {
				VLog.d("Type  Window State Changed on AccEvent")


			}
		}
	}

	override fun onInterrupt() {
		VLog.d(GENERAL_TAG, "onServiceInteruppted")

	}


}
