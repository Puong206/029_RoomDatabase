package com.example.a029_roomdatabase.view.route

import com.example.a029_roomdatabase.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "edit_siswa"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}