package com.camilogo1200.ipinfo.data.database.room.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.camilogo1200.ipinfo.data.database.room.DataBase
import com.camilogo1200.ipinfo.data.database.room.dao.IpInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PersistenceModuleInjector {
    private const val CONST_DATABASE_NAME = "IPINFO"

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context,
        coroutineScope: CoroutineScope,
        callback: RoomDatabase.Callback
    ): DataBase {

        return Room.databaseBuilder(context, DataBase::class.java, CONST_DATABASE_NAME)
            //.createFromAsset("database/ip-info.db")
            //.fallbackToDestructiveMigration()
            //.addCallback(callback)
            //.enableMultiInstanceInvalidation()
            .build()

    }

    @Provides
    @Singleton
    fun provideStoryDatabaseCallBack(
        @ApplicationContext context: Context,
        coroutineScope: CoroutineScope,
    ): RoomDatabase.Callback {
        return object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //ipInfoDao.deleteAllIps()
            }
        }
    }

    @Singleton
    @Provides
    fun providesIpInfoDao(database: DataBase): IpInfoDao = database.IpInfoDao()
}