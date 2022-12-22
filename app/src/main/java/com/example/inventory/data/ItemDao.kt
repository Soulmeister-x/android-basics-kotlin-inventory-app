package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    // retrieve a particular item from the item table based on the given id
    @Query("SELECT * from item WHERE id = :id")
    fun getItemById(id: Int): Flow<Item>

    // retrieve all items as a list
    @Query("SELECT * from item ORDER BY item_name ASC")
    fun getItems(): Flow<List<Item>>
}