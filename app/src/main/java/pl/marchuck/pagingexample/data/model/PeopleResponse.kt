package pl.marchuck.pagingexample.data.model

import com.google.gson.annotations.SerializedName

data class PeopleResponse(

        @field:SerializedName("next")
        val next: String? = null,

        @field:SerializedName("previous")
        val previous: String? = null,

        @field:SerializedName("count")
        val count: Int = 0,

        @field:SerializedName("results")
        val results: List<Person?>? = null
)