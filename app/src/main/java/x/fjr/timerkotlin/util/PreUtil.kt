package x.fjr.timerkotlin.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import x.fjr.timerkotlin.MainActivity
import java.util.*

/**
 * Created by franky.wijanarko on 07/03/18.
 */
class PreUtil(private var context: Context) {

    companion object {
        //static
        private const val TIMER_LENGTH = "timer_length"
        private const val PREF_FILE_NAME = "app_pref_file"
        private const val PREVIOUS_TIMER_LENGTH_SECOND = "previous_timer_length_second_id"
        private const val TIMER_STATE = "timer_state"
        private const val SECONDS_REMAINING = "seconds_remaining"
    }

    private var mPref: SharedPreferences

    init {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun getTimerLength(): Long {
        return mPref.getLong(TIMER_LENGTH, 10)
    }

    fun getPreviousTimerLengthSeconds(): Long {
        return mPref.getLong(PREVIOUS_TIMER_LENGTH_SECOND, 0)
    }

    fun setPreviousTimerLengthSeconds(seconds: Long) {
        mPref.edit().putLong(PREVIOUS_TIMER_LENGTH_SECOND, seconds).apply()
    }

    fun getTimerState(): MainActivity.TimerState {
        return MainActivity.TimerState.values()[mPref.getInt(TIMER_STATE, 0)]
    }

    fun setTimerState(state: MainActivity.TimerState) {
        mPref.edit().putInt(TIMER_STATE, state.ordinal).apply()
    }

    fun getSecondsRemaining(): Long {
        return mPref.getLong(SECONDS_REMAINING, 0)
    }

    fun setSecondsRemaining(seconds: Long) {
        mPref.edit().putLong(SECONDS_REMAINING, seconds).apply()
    }
}