package me.zhenhao.forcedroid.fuzzdroid.crashreporter

import android.os.Parcel
import android.os.Parcelable
import me.zhenhao.forcedroid.fuzzdroid.tracing.TraceItem


/**
 * Created by tom on 6/8/17.
 */
class CrashReportItem : TraceItem {

    var exceptionMessage: String? = null
        private set

    private constructor() : super()

    constructor(exceptionMessage: String, lastExecutedStatement: Int) : super(lastExecutedStatement) {
        this.exceptionMessage = exceptionMessage
    }

    override fun writeToParcel(parcel: Parcel, arg1: Int) {
        super.writeToParcel(parcel, arg1)
        parcel.writeString(exceptionMessage)
    }

    override fun readFromParcel(parcel: Parcel) {
        super.readFromParcel(parcel)
        exceptionMessage = parcel.readString()
    }

    companion object {

        private val serialVersionUID = 5787737805848107595L

        val CREATOR: Parcelable.Creator<CrashReportItem> = object : Parcelable.Creator<CrashReportItem> {

            override fun createFromParcel(parcel: Parcel): CrashReportItem {
                val ci = CrashReportItem()
                ci.readFromParcel(parcel)
                return ci
            }

            override fun newArray(size: Int): Array<CrashReportItem?> {
                return arrayOfNulls(size)
            }

        }
    }

}