# OpenAi Api Library

**v0.1.4**

The OpenAi Api Library v1.2 is an Android library that abstracts and connects the logic behind making network calls to OpenAi's Api, thereby simplifying the process of passing and generating responses to the OpenAi Api. This Project is for the HNGx 2023 Native Mobile Track. This Networking used behind this project is the kotlin ktor.

## Installation Guide
#### Getting started
To use this Library in your Project, you will need to follow carefully the listed guides below and step by step.

- First, you will need to add Internet Permissions to your Manifest.xml file to be able to make the Internet call.
```
<uses-permission android:name="android.permission.INTERNET" />
```

- Second, you will need to add these listed dependencies in your apps build.gradle.kts file. If you are using Groovy for your scripts, then you can solve this by simply using single quotes and removing the brackets.
```
dependencies {
    implementation("com.github.hngx-org:openai-api-library:0.1.4")
}
```

### Maven Repository
Now you will need to add the maven repository to your Top Level Gradle file(if you are using older android studio versions) or your settings.gradle kts for kotlin or settings.gradle for Groovy.
For Kotlin Gradle(settings.gradle.kts) add the below inside repositories{ } which is inside the dependencyResolutionManagement{ } : 
For Kotlin gradle
```
repositories {
    maven("https://jitpack.io")
}
 ```
For groovy
```
repositories {
    maven { url 'https://jitpack.io' }
}
```

## Usage Guide
### Library Information and Usage
The library has been created in a such a way that all you have to do is call an Object `OpenAiCaller` which contains two functions. One function  for the generated response and one for generated response and user chat logs. The library also makes use of kotlin coroutines(which is also embedded in ktor) to asynchronously handle the Api calls in a background thread, so you can safely call it in your main thread or a coroutineScope. 

### Library Usage
In order for a request to be successful, you will need to pass along a _'Cookie'_ to validate that the user has the rights to make use of this service. Please make reference to the Auth library on how to retrieve the cookies for each request. It is under the **Fetching User Profile** section.

### Examples
 
First, you can instantiate the class like so 
```val openApiClient = OpenAiCaller ```

Or you may not even need to instantiate the class as the functions are static because of the companion Object used. So you can just directly call it like this: 
```val response = OpenAiCaller.generateChatResponse() ```

Next for a generated  response, you will need to pass along the user prompt and cookie: 
```
 viewModelScope.launch {
    val response = OpenApiCaller.generateChatResponse("What is a tank like?", "session="RandomGeneratedCookie"")
     // Do something with response
 }
```

And then lastly for a generated response with user chat logs(the stored user sessions) or history, you will need to pass along the current prompt, the user chat logs and history and lastly the cookie again. Like the below :
```
viewModelScope.launch {
    val response = openApiClient.generateUserChatResponse("What was my last question?", 
            arrayOf("User : What color is an Apple?", "Ai : An Apple is red in color."), "session="RandomGeneratedCookie"")
            
    // Do something with response
}
```

## Error Handling
When an error occurs from a request, a HttpResponseValidator which is part of the ktor library checks the statusCode and returns an exception for each possible statusCode gotten due to an error that occurred from a request.
#### Example 
```
HttpResponseValidator {
    validateResponse {
        when (val v = it.status.value) {
            400 -> throw BadRequestsException(
                "Bad Request"
            )
         }
    }
}
```

we set a bunch of Exceptions for each possible statusCode, so you can easily catch or find these exceptions from the library if anything goes wrong on the server end. You can easily do this using a try catch {} block.
#### Example
```
try {
    viewModelScope.launch {
        val response = OpenApiCaller.generateChatResponse("What is a tank like?", "session="RandomGeneratedCookie"")
        // Do something with response
        Log.d(TAG, "The received response is $response")
    }
} catch(e : Exception) {
    Log.d(TAG, "Error received from server request is $e exception")
    // Example of this should be "Error received from server request is [PaymentRequiredException...]"
}
```

## Contributors and Collaborators of this Project.
### Slack Usernames.
Daniel Chinedum Iroka
Lara
ChinazaBlossom

### Github usernames
@daniel-iroka 
@OmolaraIdowu 
@Chinazablossom 
