package com.example.basictestapp.storage

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StoreRetrieveDataTest {

    private val TEST_FILENAME = "testitems.json"
    private val storeRetrieveData = lazy { getDataStorage() }

    @Test
    fun testSaveAndLoadFile() {
        var items = MutableList(1) {ToDoItem("ToDo1", "ToDo1Descr", false, null, 1, "id1")}
        items.add(ToDoItem("ToDo2", "ToDo2Descr", false, null, 2, "id2"))
        storeRetrieveData.value.saveToFile(items)
        storeRetrieveData.value.loadFromFile().also {readedItems ->
            assertSame(items.size, readedItems?.size)
            items.forEach{
                assertTrue("item ($it) not on base items", items.contains(it))
            }
        }
    }

    fun getDataStorage() : StoreRetrieveData {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        return StoreRetrieveData(appContext, TEST_FILENAME);
    }
}