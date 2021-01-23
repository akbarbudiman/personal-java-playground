def quick_sort_partition(array: list, lowest_index: int, highest_index: int):
    pivot = array[highest_index]
    smaller_element_index = lowest_index

    for index in range(lowest_index, len(array)-1):
        if array[index] < pivot:
            array[smaller_element_index], array[index] = array[index], array[smaller_element_index]
            smaller_element_index = smaller_element_index + 1

    new_index_for_pivot = smaller_element_index
    array[new_index_for_pivot], array[highest_index] = pivot, array[new_index_for_pivot]
    return new_index_for_pivot


def quick_sort(array: list, lowest_index: int, highest_index: int):
    if lowest_index < highest_index:
        last_pivot_index = quick_sort_partition(array, lowest_index, highest_index)
        quick_sort(array, lowest_index, last_pivot_index-1)
        quick_sort(array, last_pivot_index+1, highest_index)


def quick_sort_without_swapping(array: list)->list:
    if len(array) > 1:
        pivot = array[-1]

        less_than_pivot = []
        greater_than_pivot = []
        for element in array[:-1]:
            if element < pivot:
                less_than_pivot.append(element)
            else:
                greater_than_pivot.append(element)

        less_than_pivot = quick_sort_without_swapping(less_than_pivot)
        greater_than_pivot = quick_sort_without_swapping(greater_than_pivot)

        array = []
        array.extend(less_than_pivot)
        array.append(pivot)
        array.extend(greater_than_pivot)

    return array


if __name__ == '__main__':
    array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    sorted_array = quick_sort_without_swapping(array_test)
    print(sorted_array)

    array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    quick_sort(array_test, 0, len(array_test)-1)
    print(array_test)
