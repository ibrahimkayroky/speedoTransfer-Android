package com.gradproj.SpeedoTransferApp.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.util.Date

//import com.fasterxml.jackson.annotation.JsonFormat
data class RegisterRequest(
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
   // val birthDate: LocalDate,

    val country: String,

    val email: String,
    val name: String,
    val password: String,

    )