I read https://en.wikipedia.org/wiki/Linked_list and wrote this :yawning_face:

[Source](Main.java)

Output:
```
=== Test 1: add (1, 20, 30) ===

LinkedList Structure:
Node[0] | value=10 | next=20
Node[1] | value=20 | next=30
Node[2] | value=30 | next=<null>
HEAD -> 10
TAIL -> 30
SIZE -> 3

=== Test 2: addFirst (5) ===

LinkedList Structure:
Node[0] | value=5 | next=10
Node[1] | value=10 | next=20
Node[2] | value=20 | next=30
Node[3] | value=30 | next=<null>
HEAD -> 5
TAIL -> 30
SIZE -> 4

=== Test 3: insertAt (index: 2, value: 15) ===

LinkedList Structure:
Node[0] | value=5 | next=10
Node[1] | value=10 | next=15
Node[2] | value=15 | next=20
Node[3] | value=20 | next=30
Node[4] | value=30 | next=<null>
HEAD -> 5
TAIL -> 30
SIZE -> 5

=== Test 4: remove (0, 2) ===

Before Remove:
LinkedList Structure:
Node[0] | value=5 | next=10
Node[1] | value=10 | next=15
Node[2] | value=15 | next=20
Node[3] | value=20 | next=30
Node[4] | value=30 | next=<null>
HEAD -> 5
TAIL -> 30
SIZE -> 5

After Remove:
LinkedList Structure:
Node[0] | value=10 | next=15
Node[1] | value=15 | next=30
Node[2] | value=30 | next=<null>
HEAD -> 10
TAIL -> 30
SIZE -> 3

=== Test 5: get (0, 1, last) ===
get(0) = 10
get(1) = 15
get(last) = 30

=== Test 6: exist (5, 15, 30, 100) ===
exist(5) = false
exist(15) = true
exist(30) = true
exist(100) = false
```
