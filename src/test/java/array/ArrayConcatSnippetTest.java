/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests for 30 Seconds of Java code library.
 */
class ArrayConcatSnippetTest {

  @Test
  void testConstructor() {
    assertNotNull(new ArrayConcatSnippet());
  }

  /**
   * Tests for {@link ArrayConcatSnippet#arrayConcat(Object[], Object[])}.
   */
  @Test
  void testArrayConcat() {
    var integers = ArrayConcatSnippet.arrayConcat(new Integer[5], new Integer[5]);
    assertEquals(10, integers.length);

    var strings1 = new String[] {"a", "b"};
    var strings2 = new String[] {"c", "d"};
    var concatenatedStrings = ArrayConcatSnippet.arrayConcat(strings1, strings2);
    assertArrayEquals(new String[] {"a", "b", "c", "d"}, concatenatedStrings);

    var emptyStrings = ArrayConcatSnippet.arrayConcat(new String[0], new String[0]);
    assertEquals(0, emptyStrings.length);

    assertThrows(NullPointerException.class, () -> ArrayConcatSnippet.arrayConcat(null, null));
  }
}
