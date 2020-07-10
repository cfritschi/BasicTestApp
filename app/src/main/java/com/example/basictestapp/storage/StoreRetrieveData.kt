package com.example.basictestapp.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.util.*

class StoreRetrieveData(private var context: Context, private var fileName: String) {

    companion object {
        var gson = Gson()
    }

    @Throws(JSONException::class, IOException::class)
    fun saveToFile(items: List<ToDoItem>) {
        val jsonTutsList: String = gson.toJson(items)
        context.openFileOutput(fileName, Context.MODE_PRIVATE).write(jsonTutsList.toByteArray(Charsets.UTF_8))
    }

    @Throws(IOException::class, JSONException::class)
    fun loadFromFile(): List<ToDoItem>? {
        val items = ArrayList<ToDoItem>()
        val fileContent = File(context.filesDir, fileName).readText(Charsets.UTF_8)
        val jsonItems = gson.fromJson(fileContent, JsonElement::class.java)
        if (jsonItems is JsonArray) {
            jsonItems.forEach {item ->
                items.add(gson.fromJson(item as JsonElement, ToDoItem::class.java))
            }
        }
        return items
    }
}
