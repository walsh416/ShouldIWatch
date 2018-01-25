package csc214.kotlintest.shouldiwatchkotlin

import android.content.Context
import android.content.SharedPreferences
import android.support.v4.content.SharedPreferencesCompat

/**
 * Created by Tim on 1/23/18.
 */


class Prefs (context: Context) {
    val PREFS_FILENAME = "csc214.kotlintest.shouldiwatchkotlin.prefs"
    val PREFS_DEFICIT = "deficit"
    val PREFS_DAYS_AGO = "daysAgo"
    val PREFS_NUM_GAMES = "numGames"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var deficit: Int
        get() = prefs.getInt(PREFS_DEFICIT, 0)
        set(value) = prefs.edit().putInt(PREFS_DEFICIT, value).apply()

    var daysAgo: Int
        get() = prefs.getInt(PREFS_DAYS_AGO, 0)
        set(value) = prefs.edit().putInt(PREFS_DAYS_AGO, value).apply()

    var numGames: Int
        get() = prefs.getInt(PREFS_NUM_GAMES, 0)
        set(value) = prefs.edit().putInt(PREFS_NUM_GAMES, value).apply()
}