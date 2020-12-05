package tech.threecrabs

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "stories")
data class Story(

    @Id
    @GeneratedValue
    var id: Long?,

    var name: String
)
