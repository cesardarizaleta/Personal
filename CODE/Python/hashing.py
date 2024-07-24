def hashingSortRecursive(arr, n):
    if n <= 1:
        return arr
    else:
        # Choose a random pivot element
        pivot = arr[n // 2]

        # Divide the array into three parts: left (elements less than pivot),
        # middle (elements equal to pivot), and right (elements greater than pivot)
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]

        # Recursively sort the left and right partitions
        left = hashingSortRecursive(left, len(left))
        right = hashingSortRecursive(right, len(right))

        # Combine the sorted partitions with the middle partition
        return left + middle + right

arr = [12, 34, 54, 2, 3]
print("Array before sorting:")
print(arr)
arr = hashingSortRecursive(arr, len(arr))
print("Array after sorting:")
print(arr)
