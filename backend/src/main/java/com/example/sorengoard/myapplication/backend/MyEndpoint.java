/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.sorengoard.myapplication.backend;

import com.example.JokesJavaLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.sorengoard.example.com",
                ownerName = "backend.myapplication.sorengoard.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a joke from the java library and returns it.
     */
    @ApiMethod(name = "makeJoke")
    public MyBean makeJoke(@Named("joke") String joke) {
        MyBean response = new MyBean();
        JokesJavaLibrary jjl = new JokesJavaLibrary();
        String jokeTwo = jjl.jokeTwo;
        response.setData(jokeTwo);

        return response;
    }

}
