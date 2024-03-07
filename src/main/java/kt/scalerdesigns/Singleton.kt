package kt.scalerdesigns

import java.util.concurrent.locks.Lock
import kotlin.properties.Delegates

class Dart private constructor() {
    companion object {
        @Volatile
        private lateinit var dart: Dart
        fun getInstance(): Dart {
            if (!::dart.isInitialized) {
                synchronized(this) {
                    if (!::dart.isInitialized) {
                        dart = Dart()
                    }
                }
            }
            return dart
        }
    }
}