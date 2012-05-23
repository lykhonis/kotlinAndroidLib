package android.kotlin

import android.os.AsyncTask

fun async<Params, Progress, Result>(
        inBackground: (args: Array<Params?>) -> Result?,
        preExecute: (() -> Unit) ? = null,
        postExecute: ((result: Result?) -> Unit) ? = null
) {
    object : AsyncTask<Params, Progress, Result>() {

        protected override fun doInBackground(p0: Array<Params?>) = inBackground(p0)

        protected override fun onPreExecute() = preExecute?.invoke()

        protected override fun onPostExecute(result: Result?) = postExecute?.invoke(result)

        protected override fun onProgressUpdate(values: Array<Progress?>) {

        }

        protected override fun onCancelled(result: Result?) {

        }

        protected override fun onCancelled() {

        }
    }
}