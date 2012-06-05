package android.kotlin

import java.util.concurrent.Callable

public inline fun callable<T>(action: () -> T?): Callable<out T> {
    return object : Callable<T> {
        public override fun call(): T? = action()
    }
}
