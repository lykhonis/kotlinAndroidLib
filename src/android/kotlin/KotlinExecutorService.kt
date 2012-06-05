package android.kotlin

import java.util.concurrent.ExecutorService
import java.util.concurrent.Callable
import java.util.concurrent.Future

public inline fun ExecutorService.execute(action: () -> Unit): Unit {
    execute(runnable(action))
}

public inline fun ExecutorService.submit<T>(action: () -> T?): Future<out T>? {
    return submit(object : Callable<T> {
        public override fun call(): T? = action()
    })
}

public inline fun ExecutorService.submit(action: () -> Unit): Future<out Any?>? {
    return submit(runnable(action))
}

public inline fun ExecutorService.submit<T>(result: T, action: () -> Unit): Future<out T>? {
    return submit(runnable(action), result)
}
