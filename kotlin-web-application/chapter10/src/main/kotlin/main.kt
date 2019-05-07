import spark.Spark.get


fun main() {
    get("/hello") { request, response ->
        val name = request.queryParams("name")
        "Hello, ${name ?: "world"}!"
    }
}