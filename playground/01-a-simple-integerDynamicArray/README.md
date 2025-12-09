I read this:
https://en.wikipedia.org/wiki/Dynamic_array

and decided to create a dynamic array of integers using tuples...

[Source](Main.java)

Output:
```
=== Test 1: Basic Operations ===
Dynamic Array contents (size=3, capacity=5):
[0] = (0, 6547)
[1] = (1, 500)
[2] = (2, 100)

Value at index 0: 6547
Value at index 1: 500
Value at index 2: 100

=== Test 2: Auto-expansion ===
Initial capacity: 5
After setting at index 10:
New capacity: 11
New size: 11
Dynamic Array contents (size=11, capacity=11):
[0] = (0, 6547)
[1] = (1, 500)
[2] = (2, 100)
[3] = null
[4] = null
[5] = null
[6] = null
[7] = null
[8] = null
[9] = null
[10] = (10, 999)

=== Test 3: Add and Remove ===
Dynamic Array contents (size=13, capacity=16):
[0] = (0, 6547)
[1] = (1, 500)
[2] = (2, 100)
[3] = null
[4] = null
[5] = null
[6] = null
[7] = null
[8] = null
[9] = null
[10] = (10, 999)
[11] = (11, 111)
[12] = (12, 222)

=== Test 4: Insert with Shift ===
After inserting 777 at index 1:
Dynamic Array contents (size=14, capacity=16):
[0] = (0, 6547)
[1] = (1, 777)
[2] = (2, 500)
[3] = (3, 100)
[4] = null
[5] = null
[6] = null
[7] = null
[8] = null
[9] = null
[10] = null
[11] = (11, 999)
[12] = (12, 111)
[13] = (13, 222)

=== Test 5: Compaction ===
After deleting indices 1 and 3:
Dynamic Array contents (size=14, capacity=16):
[0] = (0, 6547)
[1] = null
[2] = (2, 500)
[3] = null
[4] = null
[5] = null
[6] = null
[7] = null
[8] = null
[9] = null
[10] = null
[11] = (11, 999)
[12] = (12, 111)
[13] = (13, 222)
After compaction:
Dynamic Array contents (size=5, capacity=16):
[0] = (0, 6547)
[1] = (1, 500)
[2] = (2, 999)
[3] = (3, 111)
[4] = (4, 222)

=== Test 6: Search ===
Index of value 100: -1
Index of value 999: 2
Index of value 9999: -1

=== Test 7: Dump and Display ===

 ------ Dump ------ 

[(0, 6547), (1, 500), (2, 999), (3, 111), (4, 222)]

 ------ Display ------ 

Dynamic Array contents (size=5, capacity=16):
[0] = (0, 6547)
[1] = (1, 500)
[2] = (2, 999)
[3] = (3, 111)
[4] = (4, 222)

=== Test 8: Clear ===
After clear - Size: 0
Is empty: true
```