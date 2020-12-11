package com.chanchuan.data.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 10:28
 *
 *
 */
abstract class BaseObserver<T> : Observer<Any?> {
    private var mDisposable: Disposable? = null
    override fun onSubscribe(d: Disposable) {
        mDisposable = d
    }

    override fun onNext(t: Any) {
        onSuccess(t)
        dispose()
    }


    override fun onError(e: Throwable) {
        onFailed(e)
        dispose()
    }


    override fun onComplete() {
        dispose()
    }

    abstract fun onSuccess(t: Any)

    abstract fun onFailed(e: Throwable)

    private fun dispose() {
        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }
}