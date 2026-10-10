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

package algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for 30 Seconds of Java code library.
 */
class BinarySearchIn2dArraySnippetTest {

  @Test
  void testConstructor() {
    assertNotNull(new BinarySearchIn2dArraySnippet());
  }

  /**
   * Tests for {@link BinarySearchIn2dArraySnippet#binarySearchIn2darr(int[][], int)}.
   */
  @Test
  void testBinarySearchIn2darr() {
    int[][] arr = {
      {3, 4, 7, 9},
      {12, 24, 26, 29},
      {34, 55, 88, 99},
      {100, 189, 232, 234}
    };

    // Original tests
    assertArrayEquals(new int[]{1, 2},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 26));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 69));

    // rows == 1 branch
    int[][] twoRows = {{1, 3, 5, 7}, {10, 20, 30, 40}};
    assertArrayEquals(new int[]{0, 1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(twoRows, 3));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(twoRows, 6));

    // Found at rstart at cmid
    assertArrayEquals(new int[]{1, 1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 24));

    // Fallthrough branches and edge cases
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 2));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 30));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(arr, 300));

    // Test matrix for rend at cmid
    int[][] small = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    assertArrayEquals(new int[]{2, 1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(small, 8));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(small, 0));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearchIn2darr(small, 10));

    // Helper binarySearch direct branches
    assertArrayEquals(new int[]{0, 1},
        BinarySearchIn2dArraySnippet.binarySearch(arr, 4, 0, 0, 3));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearch(arr, 8, 0, 0, 3));
    assertArrayEquals(new int[]{-1, -1},
        BinarySearchIn2dArraySnippet.binarySearch(arr, 1, 0, 0, 3));
  }
}
