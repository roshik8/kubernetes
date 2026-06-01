/*
Copyright 2020 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.util;

import jakarta.annotation.Nullable;

public final class Strings {

  private static final String ELLIPSIS = "…";

  private Strings() {
    throw new AssertionError("not supported");
  }

  public static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  public static String nullToEmpty(@Nullable String string) {
    return (string == null) ? "" : string;
  }

  /**
   * Truncates {@code value} to at most {@code maxLength} characters, appending a single ellipsis
   * character (U+2026) when truncation occurs. Returns {@code null} when {@code value} is {@code
   * null}.
   *
   * @throws IllegalArgumentException if {@code maxLength} is less than 1
   */
  public static @Nullable String truncate(@Nullable String value, int maxLength) {
    if (maxLength < 1) {
      throw new IllegalArgumentException("maxLength must be at least 1, was: " + maxLength);
    }
    if (value == null || value.length() <= maxLength) {
      return value;
    }
    return value.substring(0, maxLength - 1) + ELLIPSIS;
  }
}
