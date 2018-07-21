Kotlin sdk for hirez api using coroutines.

you can make very simple calls like

```kotlin
launch {
    val service = PaladinsService(devId, apiKey)
    val statusResponse = service.getServerStatus()
    println(statusResponse.status)
}
```