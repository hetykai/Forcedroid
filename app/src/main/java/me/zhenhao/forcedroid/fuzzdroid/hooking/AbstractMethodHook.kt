package me.zhenhao.forcedroid.fuzzdroid.hooking

import me.zhenhao.forcedroid.fuzzdroid.tracing.BytecodeLogger

/**
 * Created by tom on 6/8/17.
 */
abstract class AbstractMethodHook {

    protected fun getLastCodePosition(): Int {
        return BytecodeLogger.getLastExecutedStatement()
    }

    abstract fun isValueReplacementNecessary(): Boolean

}