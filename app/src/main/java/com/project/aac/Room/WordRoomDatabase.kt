package com.project.aac.Room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.project.aac.Room.Word
import com.project.aac.Room.WordDao

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java, "word_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

    abstract fun wordDao(): WordDao

}
