package kt.scalerdesigns

interface FileSystem {

    fun getTotalFiles() : Int
    fun printFiles()
}

class File : FileSystem {
    override fun getTotalFiles() = 1

    override fun printFiles() {
        println("file printed")
    }

}

class Directory : FileSystem {
    val listOfFiles: MutableList<FileSystem> = mutableListOf()

    fun addFiles(file: FileSystem) {
        listOfFiles.add(file)
    }

    override fun getTotalFiles(): Int {
        var noOfFiles = 0;
        for (file in listOfFiles) {
            noOfFiles += file.getTotalFiles()
        }
        return noOfFiles
    }

    override fun printFiles() {
        for (file in listOfFiles) {
            file.printFiles()
        }
    }
}

fun main() {
    val parentDirectory = Directory()
    val directory = Directory()
    directory.addFiles(File())
    directory.addFiles(File())
    parentDirectory.addFiles(directory)
    parentDirectory.addFiles(File())
    println(parentDirectory.getTotalFiles())
}