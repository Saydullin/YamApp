package com.saydullin.yamapp.messaging

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyFirebaseMessagingReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Обработка полученного уведомления FCM
        // intent содержит данные и метаданные уведомления
    }
}