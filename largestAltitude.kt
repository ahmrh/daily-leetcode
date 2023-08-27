fun largestAltitude(gain: IntArray): Int {
    var highest = 0
    var altitude = 0
    
    gain.forEach{ 
        altitude += it
        if(highest < altitude) highest = altitude
    }    
    
    return highest
}
