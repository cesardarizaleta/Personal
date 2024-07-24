def merge_sort(unsorted_array):
    if len(unsorted_array) > 1:
        mid = len(unsorted_array) // 2
        left = unsorted_array[:mid]
        right = unsorted_array[mid:]

        merge_sort(left)
        merge_sort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                unsorted_array[k] = left[i]
                i += 1
            else:
                unsorted_array[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            unsorted_array[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            unsorted_array[k] = right[j]
            j += 1
            k += 1

# Example usage:
unsorted_array = [10, 3, 0, -1, 5]
merge_sort(unsorted_array)
print("Sorted array is", unsorted_array)
