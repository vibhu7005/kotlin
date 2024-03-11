package kt.scalerdesigns

interface FileSystem {
    fun printFiles()
}

class File : FileSystem {
    override fun printFiles() {
        println("file printed")
    }

}

class Directory : FileSystem {
    val listOfFiles : MutableList<FileSystem> = mutableListOf()

    fun addFiles(file : FileSystem) {
        listOfFiles.add(file)
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
    parentDirectory.printFiles()
}