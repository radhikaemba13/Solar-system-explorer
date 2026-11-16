```python
from functools import reduce

students = [45, 60, 75, 35, 90]

# Filter students who scored 50 or above
passed = list(filter(lambda x: x >= 50, students))
print("Passed Students:", passed)

# Add 5 grace marks, maximum 100
grace_marks = list(map(lambda x: min(x + 5, 100), students))
print("Marks After Grace:", grace_marks)

# Calculate total marks
total = reduce(lambda x, y: x + y, grace_marks)
print("Total Marks:", total)
```
