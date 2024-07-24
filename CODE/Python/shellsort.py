def shellSortRecursive(arr, n, gap=None):
    if gap is None:
        gap = n // 2
    if gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap
            arr[j] = temp
        return shellSortRecursive(arr, n, gap // 2)
    return arr

arr = [12, 34, 54, 2, 3]
print("Array before sorting:")
print(arr)
arr = shellSortRecursive(arr, len(arr))
print("Array after sorting:")
print(arr)
