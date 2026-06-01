/*
Copyright 2026 The Kubernetes Authors.
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

import static io.kubernetes.client.util.Strings.truncate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

// [AI-HW] generated under CLAUDE.md rules
class StringsTest {

  @Test
  void truncateNull() {
    assertThat(truncate(null, 5)).isNull();
  }

  @Test
  void truncateEmpty() {
    assertThat(truncate("", 5)).isEmpty();
  }

  @Test
  void truncateBelowLimit() {
    assertThat(truncate("hello", 10)).isEqualTo("hello");
  }

  @Test
  void truncateAtExactLimit() {
    assertThat(truncate("hello", 5)).isEqualTo("hello");
  }

  @Test
  void truncateAboveLimit() {
    assertThat(truncate("hello world", 6)).isEqualTo("hello…");
  }

  @Test
  void truncateMaxLengthOne() {
    assertThat(truncate("hello", 1)).isEqualTo("…");
  }

  @Test
  void truncateMaxLengthZeroThrows() {
    assertThatThrownBy(() -> truncate("hello", 0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("maxLength must be at least 1");
  }

  @Test
  void truncateNegativeMaxLengthThrows() {
    assertThatThrownBy(() -> truncate("hello", -3))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("maxLength must be at least 1");
  }
}
