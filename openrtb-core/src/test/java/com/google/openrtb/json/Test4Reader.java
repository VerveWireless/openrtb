/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openrtb.json;

import static com.google.openrtb.json.OpenRtbJsonUtils.endArray;
import static com.google.openrtb.json.OpenRtbJsonUtils.getCurrentName;
import static com.google.openrtb.json.OpenRtbJsonUtils.startArray;

import com.google.openrtb.OpenRtb.BidResponse;
import com.google.openrtb.TestExt;

import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

/**
 * Repeated extension: {@code "test4arr": [10, 20]}, scalar type {@code Integer}.
 */
public class Test4Reader extends OpenRtbJsonExtReader<BidResponse.Builder> {

  public Test4Reader() {
    super("test4arr");
  }

  @Override protected void read(BidResponse.Builder msg, JsonParser par) throws IOException {
    if ("test4arr".equals(getCurrentName(par))) {
      for (startArray(par); endArray(par); par.nextToken()) {
        msg.addExtension(TestExt.testResponse4, par.getIntValue());
      }
    }
  }
}
