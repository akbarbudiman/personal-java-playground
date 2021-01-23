from math import ceil


def merge(left_array: list, right_array: list)->list:
    merged_array = []

    while len(left_array) > 0 and len(right_array) > 0:
        if left_array[0] < right_array[0]:
            merged_array.append(left_array.pop(0))
        else:
            merged_array.append(right_array.pop(0))

    for element in left_array:
        merged_array.append(element)
    for element in right_array:
        merged_array.append(element)

    return merged_array


def merge_sort(array: list)->list:
    if len(array) <= 1:
        return array
    middle_index = ceil(len(array)/2)
    left_array = merge_sort(array[:middle_index])
    right_array = merge_sort(array[middle_index:])
    return merge(left_array, right_array)


def testing_merge():
    case = 0

    case = case + 1
    left_array = [-2, 5, 7]
    right_array = [-1, 4, 8]
    merged_array = merge(left_array, right_array)
    expected_merged_array = [-2, -1, 4, 5, 7, 8]
    print(str(case), str(merged_array == expected_merged_array))

    case = case + 1
    left_array = [-2, 0, 5, 7]
    right_array = [-1, 4, 8]
    merged_array = merge(left_array, right_array)
    expected_merged_array = [-2, -1, 0, 4, 5, 7, 8]
    print(str(case), str(merged_array == expected_merged_array))

    case = case + 1
    left_array = [1, 3, 9, 9, 9]
    right_array = [2, 4, 6, 8]
    merged_array = merge(left_array, right_array)
    expected_merged_array = [1, 2, 3, 4, 6, 8, 9, 9, 9]
    print(str(case), str(merged_array == expected_merged_array))

    case = case + 1
    left_array = [-2, 0, 5, 7, 8, 8]
    right_array = [-1, 4, 9]
    merged_array = merge(left_array, right_array)
    expected_merged_array = [-2, -1, 0, 4, 5, 7, 8, 8, 9]
    print(str(case), str(merged_array == expected_merged_array))


if __name__ == '__main__':
    # testing_merge()

    array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    sorted_array = merge_sort(array_test)
    print(sorted_array)
