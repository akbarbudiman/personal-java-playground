def selection_sort(array: list)->list:
    for index in range(0, len(array)-1):
        minimum_index = index
        for unsorted_subarray_index in range(index, len(array)):
            if array[unsorted_subarray_index] < array[minimum_index]:
                minimum_index = unsorted_subarray_index
        array[index], array[minimum_index] = array[minimum_index], array[index]
    return array


if __name__ == '__main__':
    array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    sorted_array = selection_sort(array_test)
    print(sorted_array)
