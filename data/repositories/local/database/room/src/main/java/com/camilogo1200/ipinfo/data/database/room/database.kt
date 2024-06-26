package com.camilogo1200.ipinfo.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.camilogo1200.ipinfo.data.database.room.converters.Converters
import com.camilogo1200.ipinfo.data.database.room.dao.IpInfoDao
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity

@Database(
    entities = [IpInfoEntity::class],
    version = 25
)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {
    abstract fun IpInfoDao(): IpInfoDao
}