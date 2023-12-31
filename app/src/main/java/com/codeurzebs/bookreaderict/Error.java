package com.codeurzebs.bookreaderict;

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */


import androidx.annotation.Keep;

/**
 * Adds some default error status codes.
 */

@Keep
public class Error {

    public static final int NONE = 1000;
    public static final int INVALID_ACCESS_TOKEN = 8001;
    public static final int INVALID_STATE = 8002;
    public static final int INVALID_CONTENT = 8003;

}