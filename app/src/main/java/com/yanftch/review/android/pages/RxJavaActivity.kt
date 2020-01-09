package com.yanftch.review.android.pages

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.verticalLayout
import java.util.concurrent.TimeUnit

/**
 * RxJava
 */
class RxJavaActivity : AppCompatActivity() {
    private var intervalObservable: Disposable? = null
    private val subject = PublishSubject.create<Long>()
    val observable: Observable<Long> get() = subject
    private var ticker: Observable<Long>

    init {
        ticker = Observable.interval(1, TimeUnit.SECONDS)
    }

    private fun intervalStart() {
        intervalObservable = ticker.onErrorReturnItem(-1L)
            .subscribe {
                if (it >= 0) subject.onNext(it)
            }
    }

    private fun intervalStop() {
        intervalObservable?.dispose()
        intervalObservable = null
    }


    @SuppressLint("CheckResult")
    private fun createMethod() {
        Observable.just(1, 2, 3, 4).map {
            "age=$it"
        }.subscribe {
            Log.e("debug_RxJavaActivity", "createMethod: $it")
        }
    }

    private fun intervalOperator(stop: Boolean = false) {
        if (!stop) {
            intervalStart()
            observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.e("debug_RxJavaActivity", "intervalOperator: 接受。。。。$it")

                }
        } else {
            intervalStop()
        }
    }

    private fun createView() = UI {
        verticalLayout {

            button {
                text = "create"
                onClick {
                    createMethod()
                }
            }
            button {
                text = "interval-start"
                onClick {
                    intervalOperator()
                }
            }
            button {
                text = "interval-stop"
                onClick {
                    intervalOperator(true)
                }
            }
        }
    }.view


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createView())
    }

    override fun onStart() {
        super.onStart()

    }
}
