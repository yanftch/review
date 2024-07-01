package com.yanftch.review

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log

class MyContentProvider : ContentProvider() {
    private val TAG = "debug_MyContentProvider.kt"
    override fun onCreate(): Boolean {
        val isMyApp = context is MyApp
        Log.e(TAG, "onCreate: MyContentProvider 初始化, context = $context, isMyApp = $isMyApp")
        return true
    }

    override fun query(
        uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?
    ): Cursor? {

        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }
}