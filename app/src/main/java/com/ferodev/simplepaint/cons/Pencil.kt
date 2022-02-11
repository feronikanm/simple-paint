package com.ferodev.simplepaint.cons

import android.graphics.Path

class Pencil {

    var color = 0
    var path: Path? = null

    constructor(color: Int, path: Path?) {
        this.color = color
        this.path = path
    }
}