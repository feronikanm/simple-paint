package com.ferodev.simplepaint.cons

class Ellipse {

    var startX : Float = 0F
    var startY : Float = 0F
    var stopX : Float = 0F
    var stopY : Float = 0F
    var color = 0

    constructor(startX: Float, startY: Float, stopX: Float, stopY: Float, color: Int) {
        this.startX = startX
        this.startY = startY
        this.stopX = stopX
        this.stopY = stopY
        this.color = color
    }
}