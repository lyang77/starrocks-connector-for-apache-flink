/*
 * Copyright 2021-present StarRocks, Inc. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.starrocks.data.load.stream.compress;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/** Count how many bytes written. */
public class CountingOutputStream extends FilterOutputStream {

    private long count;

    public CountingOutputStream(OutputStream out) {
        super(out);
    }

    public long getCount() {
        return this.count;
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        this.count += len;
    }

    public void write(int b) throws IOException {
        this.out.write(b);
        ++this.count;
    }

}
