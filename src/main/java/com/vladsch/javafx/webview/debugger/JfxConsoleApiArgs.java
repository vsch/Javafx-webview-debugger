/*
 *   The MIT License (MIT)
 *   <p>
 *   Copyright (c) 2018-2020 Vladimir Schneider (https://github.com/vsch)
 *   <p>
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *   <p>
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *   <p>
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE
 *
 */

package com.vladsch.javafx.webview.debugger;

import com.vladsch.boxed.json.BoxedJsValue;

public class JfxConsoleApiArgs {
    private final Object[] myArgs;
    private final String myLogType;
    private final BoxedJsValue[] myJsonParams;
    private long myTimestamp;
    private String myPausedParam;

    public JfxConsoleApiArgs(final Object[] args, final String logType, final long timestamp) {
        myArgs = args;
        myLogType = logType;
        myJsonParams = new BoxedJsValue[args.length];
        myTimestamp = timestamp;
        myPausedParam = null;
    }

    public String getPausedParam() {
        return myPausedParam;
    }

    public void setPausedParam(final String pausedParam) {
        myPausedParam = pausedParam;
    }

    public void setParamJson(int paramIndex, BoxedJsValue paramJson) {
        myJsonParams[paramIndex] = paramJson;
    }

    public void clearAll() {
        int iMax = myArgs.length;
        for (int i = 0; i < iMax; i++) {
            myArgs[i] = null;
            myJsonParams[i] = null;
        }
    }

    public long getTimestamp() {
        return myTimestamp;
    }

    public Object[] getArgs() {
        return myArgs;
    }

    public String getLogType() {
        return myLogType;
    }

    public BoxedJsValue[] getJsonParams() {
        return myJsonParams;
    }
}
