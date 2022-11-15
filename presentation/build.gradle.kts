import java.nio.file.Path


fun generateSlides() {
    val outputFile = "build/slides.html"
    val inputFile = "src/main/markdown/Slides.md"
    exec("pandoc --standalone --variable theme=moon  -t revealjs -o $outputFile $inputFile")
}

fun generateImages() {
    val inputDir = "src/main/mermaid"
    val outputDir = "build"
    java.nio.file.Files.list(Path.of("src/main/mermaid/")).forEach {
        val name = it.toFile().name.removeSuffix(".mmd")
        exec("mmdc -i $inputDir/$name.mmd -o $outputDir/$name.png")

    }
}

fun exec(command: String) {
    Runtime.getRuntime().exec(command)
}

tasks.register("build") {
    doLast {
        File("build").mkdir()
        generateImages()
        generateSlides()

        exec("open build/slides.html")
    }
}

tasks.register("clean") {
    doLast {
        File("build").deleteRecursively()
    }
}

