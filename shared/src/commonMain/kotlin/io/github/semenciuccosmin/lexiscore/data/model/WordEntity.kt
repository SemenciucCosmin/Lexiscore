package io.github.semenciuccosmin.lexiscore.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "words",
    primaryKeys = ["id"]
)
data class WordEntity(
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "definition") val definition: String?,
    @ColumnInfo(name = "score") val score: Double?,
    @ColumnInfo(name = "favourite") val favourite: Boolean?,
)

val ok = """
Expected:
TableInfo {
name = 'words',
columns = {    
    Column {
       name = 'definition',
       type = 'TEXT',
       affinity = '2',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'favourite',
       type = 'INTEGER',
       affinity = '3',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'id',
       type = 'INTEGER',
       affinity = '3',
       notNull = 'true',
       primaryKeyPosition = '1',
       defaultValue = 'undefined'
    },
    Column {
       name = 'score',
       type = 'REAL',
       affinity = '4',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'word',
       type = 'TEXT',
       affinity = '2',
       notNull = 'true',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    }
},
foreignKeys = { }
indices = { }
                                                                                                    }
                                                                                                     Found:
                                                                                                    TableInfo {
name = 'words',
columns = {    
    Column {
       name = 'definition',
       type = 'TEXT',
       affinity = '2',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'favourite',
       type = 'INTEGER',
       affinity = '3',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'id',
       type = 'INTEGER',
       affinity = '3',
       notNull = 'false',
       primaryKeyPosition = '1',
       defaultValue = 'undefined'
    },
    Column {
       name = 'score',
       type = 'REAL',
       affinity = '4',
       notNull = 'false',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    },
    Column {
       name = 'word',
       type = 'TEXT',
       affinity = '2',
       notNull = 'true',
       primaryKeyPosition = '0',
       defaultValue = 'undefined'
    }
},
foreignKeys = { }
indices = { }
                                                                                                    }
""".trimIndent()
